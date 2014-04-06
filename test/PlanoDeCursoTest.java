import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import models.Cadeira;
import models.PlanoDeCurso;
import models.exceptions.LimiteDeCreditosUltrapassadoException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are
 * interested in mocking a whole application, see the wiki for more details.
 * 
 */
public class PlanoDeCursoTest {

	private PlanoDeCurso planoPadrao;
	private PlanoDeCurso planoComum;
	private PlanoDeCurso planoNovo;

	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
		planoPadrao = new PlanoDeCurso();
		planoComum = new PlanoDeCurso();
		planoNovo = new PlanoDeCurso();
		planoPadrao.distribuiCadeiras(Cadeira.findByType("padrao"));
		planoComum.distribuiCadeiras(Cadeira.findByType("comum"));
		planoNovo.distribuiCadeiras(Cadeira.findByType("novo"));

	}

	@Test
	public void deveAtualizarCreditosDoPeriodo()
			throws LimiteDeCreditosUltrapassadoException {
		Assert.assertEquals(24, planoPadrao.getPeriodo(1).getCreditos());
		Assert.assertEquals(26, planoPadrao.getPeriodo(2).getCreditos());
		Assert.assertEquals(28, planoPadrao.getPeriodo(3).getCreditos());
		planoPadrao.addCadeira("Cálculo II", 1);
		Assert.assertEquals(28, planoPadrao.getPeriodo(1).getCreditos());
		Assert.assertEquals(22, planoPadrao.getPeriodo(2).getCreditos());
		Assert.assertEquals(28, planoPadrao.getPeriodo(3).getCreditos());
		
		Assert.assertEquals(24, planoComum.getPeriodo(1).getCreditos());
		Assert.assertEquals(24, planoComum.getPeriodo(2).getCreditos());
		planoComum.addCadeira("Cálculo II", 1);
		Assert.assertEquals(28, planoComum.getPeriodo(1).getCreditos());
		Assert.assertEquals(20, planoComum.getPeriodo(2).getCreditos());
		
		Assert.assertEquals(20, planoNovo.getPeriodo(1).getCreditos());
		Assert.assertEquals(20, planoNovo.getPeriodo(2).getCreditos());
		planoNovo.addCadeira("Cálculo I", 1);
		Assert.assertEquals(24, planoNovo.getPeriodo(1).getCreditos());
		Assert.assertEquals(16, planoNovo.getPeriodo(2).getCreditos());

	}

	@Test
	public void deveAtualizarDificuldadeDoPeriodo()
			throws LimiteDeCreditosUltrapassadoException {
		Assert.assertEquals(25, planoPadrao.getPeriodo(1).getDificuldadeTotal());
		Assert.assertEquals(37, planoPadrao.getPeriodo(2).getDificuldadeTotal());
		planoPadrao.addCadeira("Cálculo II", 1);
		Assert.assertEquals(32, planoPadrao.getPeriodo(1).getDificuldadeTotal());
		Assert.assertEquals(30, planoPadrao.getPeriodo(2).getDificuldadeTotal());
		

		Assert.assertEquals(25, planoComum.getPeriodo(1).getDificuldadeTotal());
		Assert.assertEquals(38, planoComum.getPeriodo(2).getDificuldadeTotal());
		planoComum.addCadeira("Cálculo II", 1);
		Assert.assertEquals(32, planoComum.getPeriodo(1).getDificuldadeTotal());
		Assert.assertEquals(31, planoComum.getPeriodo(2).getDificuldadeTotal());
		

		Assert.assertEquals(20, planoNovo.getPeriodo(1).getDificuldadeTotal());
		Assert.assertEquals(24, planoNovo.getPeriodo(2).getDificuldadeTotal());
		planoNovo.addCadeira("Cálculo I", 1);
		Assert.assertEquals(27, planoNovo.getPeriodo(1).getDificuldadeTotal());
		Assert.assertEquals(17, planoNovo.getPeriodo(2).getDificuldadeTotal());
	}

	@Test
	public void deveIniciarplanoPadraoDeCursoComTodasDisciplinasAlocadas() {
		Assert.assertEquals(55, planoPadrao.getCadeirasAlocadas().size());
	}
	
	@Test
	public void deveIniciarplanoComumDeCursoComTodasDisciplinasObrigatoriasAlocadas() {
		Assert.assertEquals(44, planoComum.getCadeirasAlocadas().size());
	}
	
	@Test
	public void deveIniciarplanoNovoDeCursoComTodasDisciplinasAlocadas() {
		Assert.assertEquals(48, planoNovo.getCadeirasAlocadas().size());
		Assert.assertEquals(0, planoNovo.getCadeiraDispniveisOrdenadas().size());
	}

	@Test
	public void naoDeveExcederLimiteDeCreditosPorPeriodo() throws LimiteDeCreditosUltrapassadoException {
		Assert.assertEquals(24, planoPadrao.getPeriodo(1).getCreditos());
		planoPadrao.addCadeira("Cálculo II", 1);
		Assert.assertEquals(28, planoPadrao.getPeriodo(1).getCreditos());
		try {
			planoPadrao.addCadeira("Programação II", 1);
			Assert.fail("Adicionou uma disciplina que nao deveria");
		} catch (LimiteDeCreditosUltrapassadoException e) {
			e.getMessage();
		}
		Assert.assertEquals(28, planoPadrao.getPeriodo(1).getCreditos());
		
		
		Assert.assertEquals(24, planoComum.getPeriodo(1).getCreditos());
		planoComum.addCadeira("Cálculo II", 1);
		Assert.assertEquals(28, planoComum.getPeriodo(1).getCreditos());
		try {
			planoComum.addCadeira("Programação II", 1);
			Assert.fail("Adicionou uma disciplina que nao deveria");
		} catch (LimiteDeCreditosUltrapassadoException e) {
			e.getMessage();
		}
		Assert.assertEquals(28, planoComum.getPeriodo(1).getCreditos());
		
		
		Assert.assertEquals(24, planoNovo.getPeriodo(3).getCreditos());
		planoNovo.addCadeira("Cálculo I", 3);
		Assert.assertEquals(28, planoNovo.getPeriodo(3).getCreditos());
		try {
			planoNovo.addCadeira("Programação II", 3);
			Assert.fail("Adicionou uma disciplina que nao deveria");
		} catch (LimiteDeCreditosUltrapassadoException e) {
			e.getMessage();
		}
		Assert.assertEquals(28, planoNovo.getPeriodo(3).getCreditos());
	}

	@Test
	public void devePermitirRemoverUmPreRequisito()
			throws LimiteDeCreditosUltrapassadoException {
		Assert.assertEquals(55, planoPadrao.getCadeirasAlocadas().size());
		Assert.assertEquals(0, planoPadrao.getCadeiraDispniveisOrdenadas().size());

		Assert.assertEquals(24, planoPadrao.getPeriodo(1).getCreditos());
		Assert.assertEquals(6, planoPadrao.getPeriodo(1).getCadeiras().size());
		Assert.assertEquals(26, planoPadrao.getPeriodo(2).getCreditos());
		Assert.assertEquals(28, planoPadrao.getPeriodo(3).getCreditos());

		planoPadrao.removeCadeira("Cálculo I");

		Assert.assertEquals(20, planoPadrao.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, planoPadrao.getPeriodo(1).getCadeiras().size());
		Assert.assertEquals(18, planoPadrao.getPeriodo(2).getCreditos());
		Assert.assertEquals(20, planoPadrao.getPeriodo(3).getCreditos());

		Assert.assertEquals(34, planoPadrao.getCadeirasAlocadas().size());
		Assert.assertEquals(21, planoPadrao.getCadeiraDispniveisOrdenadas().size());

		planoPadrao.addCadeira("Cálculo I", 1);

		Assert.assertEquals(24, planoPadrao.getPeriodo(1).getCreditos());
		Assert.assertEquals(6, planoPadrao.getPeriodo(1).getCadeiras().size());

		Assert.assertEquals(35, planoPadrao.getCadeirasAlocadas().size());
		Assert.assertEquals(20, planoPadrao.getCadeiraDispniveisOrdenadas().size());

		planoPadrao.removeCadeira("Cálculo I");

		Assert.assertEquals(34, planoPadrao.getCadeirasAlocadas().size());
		Assert.assertEquals(21, planoPadrao.getCadeiraDispniveisOrdenadas().size());

		Assert.assertEquals(20, planoPadrao.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, planoPadrao.getPeriodo(1).getCadeiras().size());

		planoPadrao.addCadeira("Cálculo II", 1);

		Assert.assertEquals(24, planoPadrao.getPeriodo(1).getCreditos());
		Assert.assertEquals(6, planoPadrao.getPeriodo(1).getCadeiras().size());

		Assert.assertEquals(35, planoPadrao.getCadeirasAlocadas().size());
		Assert.assertEquals(20, planoPadrao.getCadeiraDispniveisOrdenadas().size());

		planoPadrao.removeCadeira("Cálculo II");

		Assert.assertEquals(34, planoPadrao.getCadeirasAlocadas().size());
		Assert.assertEquals(21, planoPadrao.getCadeiraDispniveisOrdenadas().size());

		Assert.assertEquals(20, planoPadrao.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, planoPadrao.getPeriodo(1).getCadeiras().size());

		
		
		Assert.assertEquals(24, planoComum.getPeriodo(1).getCreditos());
		Assert.assertEquals(6, planoComum.getPeriodo(1).getCadeiras().size());
		Assert.assertEquals(24, planoComum.getPeriodo(2).getCreditos());

		planoComum.removeCadeira("Cálculo I");

		Assert.assertEquals(20, planoComum.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, planoComum.getPeriodo(1).getCadeiras().size());
		Assert.assertEquals(16, planoComum.getPeriodo(2).getCreditos());

		Assert.assertEquals(23, planoComum.getCadeirasAlocadas().size());

		planoComum.addCadeira("Cálculo I", 1);

		Assert.assertEquals(24, planoComum.getPeriodo(1).getCreditos());
		Assert.assertEquals(6, planoComum.getPeriodo(1).getCadeiras().size());

		planoComum.removeCadeira("Cálculo I");

		Assert.assertEquals(20, planoComum.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, planoComum.getPeriodo(1).getCadeiras().size());

		planoComum.addCadeira("Cálculo II", 1);

		Assert.assertEquals(24, planoComum.getPeriodo(1).getCreditos());
		Assert.assertEquals(6, planoComum.getPeriodo(1).getCadeiras().size());

		planoComum.removeCadeira("Cálculo II");

		Assert.assertEquals(20, planoComum.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, planoComum.getPeriodo(1).getCadeiras().size());

		
		
		Assert.assertEquals(48, planoNovo.getCadeirasAlocadas().size());

		Assert.assertEquals(20, planoNovo.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, planoNovo.getPeriodo(1).getCadeiras().size());
		Assert.assertEquals(20, planoNovo.getPeriodo(2).getCreditos());

		planoNovo.removeCadeira("Matemática Discreta I");

		Assert.assertEquals(16, planoNovo.getPeriodo(1).getCreditos());
		Assert.assertEquals(4, planoNovo.getPeriodo(1).getCadeiras().size());
		Assert.assertEquals(16, planoNovo.getPeriodo(2).getCreditos());

		Assert.assertEquals(42, planoNovo.getCadeirasAlocadas().size());

		planoNovo.addCadeira("Cálculo I", 1);

		Assert.assertEquals(20, planoNovo.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, planoNovo.getPeriodo(1).getCadeiras().size());

		planoNovo.removeCadeira("Cálculo I");

		Assert.assertEquals(16, planoNovo.getPeriodo(1).getCreditos());
		Assert.assertEquals(4, planoNovo.getPeriodo(1).getCadeiras().size());

		planoNovo.addCadeira("Cálculo II", 1);

		Assert.assertEquals(20, planoNovo.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, planoNovo.getPeriodo(1).getCadeiras().size());

		planoNovo.removeCadeira("Cálculo II");

		Assert.assertEquals(16, planoNovo.getPeriodo(1).getCreditos());
		Assert.assertEquals(4, planoNovo.getPeriodo(1).getCadeiras().size());		
	}

	@Test
	public void deveCalcularOsConjuntosDeCreditos(){
		Assert.assertEquals(planoPadrao.getCreditosPeriodoAtual(), 24);
		Assert.assertEquals(planoPadrao.getCreditosPeriodosFuturos(), 190);
		Assert.assertEquals(planoPadrao.getCreditosPeriodosPassados(), 0);
		Assert.assertEquals(planoPadrao.getCreditosQueFaltamParaSeFormar(), 214);
		Assert.assertEquals(planoPadrao.totalCreditosCadeirasNaoAlocadas(), 0);
		planoPadrao.setPeriodoAtual(4);

		Assert.assertEquals(planoPadrao.getCreditosPeriodoAtual(), 26);
		Assert.assertEquals(planoPadrao.getCreditosPeriodosFuturos(), 110);
		Assert.assertEquals(planoPadrao.getCreditosPeriodosPassados(), 78);
		Assert.assertEquals(planoPadrao.totalCreditosCadeirasNaoAlocadas(), 0);
		Assert.assertEquals(planoPadrao.getCreditosQueFaltamParaSeFormar(), 136);

		planoPadrao.removeCadeira("Cálculo I");

		Assert.assertEquals(planoPadrao.getCreditosPeriodoAtual(), 10);
		Assert.assertEquals(planoPadrao.getCreditosPeriodosFuturos(), 60);
		Assert.assertEquals(planoPadrao.getCreditosPeriodosPassados(), 58);
		Assert.assertEquals(planoPadrao.totalCreditosCadeirasNaoAlocadas(), 86);
		Assert.assertEquals(planoPadrao.getCreditosQueFaltamParaSeFormar(), 156);
		
		
		
		
		Assert.assertEquals(planoComum.getCreditosPeriodoAtual(), 24);
		Assert.assertEquals(planoComum.getCreditosPeriodosFuturos(), 148);
		Assert.assertEquals(planoComum.getCreditosPeriodosPassados(), 0);

		planoComum.setPeriodoAtual(4);

		Assert.assertEquals(planoComum.getCreditosPeriodoAtual(), 22);
		Assert.assertEquals(planoComum.getCreditosPeriodosFuturos(), 78);
		Assert.assertEquals(planoComum.getCreditosPeriodosPassados(), 72);
		
		planoComum.removeCadeira("Cálculo I");

		Assert.assertEquals(planoComum.getCreditosPeriodoAtual(), 14);
		Assert.assertEquals(planoComum.getCreditosPeriodosFuturos(), 20);
		Assert.assertEquals(planoComum.getCreditosPeriodosPassados(), 52);

		
		
		
		Assert.assertEquals(planoNovo.getCreditosPeriodoAtual(), 20);
		Assert.assertEquals(planoNovo.getCreditosPeriodosFuturos(), 172);
		
		planoNovo.setPeriodoAtual(4);

		Assert.assertEquals(planoNovo.getCreditosPeriodoAtual(), 24);
		Assert.assertEquals(planoNovo.getCreditosPeriodosFuturos(), 104);
		Assert.assertEquals(planoNovo.getCreditosPeriodosPassados(), 64);
		Assert.assertEquals(planoNovo.totalCreditosCadeirasNaoAlocadas(), 0);

		planoNovo.removeCadeira("Cálculo I");

		Assert.assertEquals(planoNovo.getCreditosPeriodoAtual(), 20);
		Assert.assertEquals(planoNovo.getCreditosPeriodosFuturos(), 100);
		Assert.assertEquals(planoNovo.getCreditosPeriodosPassados(), 56);
		Assert.assertEquals(planoNovo.totalCreditosCadeirasNaoAlocadas(), 16);
		Assert.assertEquals(planoNovo.getCreditosQueFaltamParaSeFormar(), 136);


	}

}
