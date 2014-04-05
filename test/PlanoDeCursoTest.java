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

	private PlanoDeCurso plano;

	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
		plano = new PlanoDeCurso();
		plano.distribuiCadeiras(Cadeira.findByType("comum"));

	}

	@Test
	public void deveAtualizarCreditosDoPeriodo()
			throws LimiteDeCreditosUltrapassadoException {
		Assert.assertEquals(24, plano.getPeriodo(1).getCreditos());
		Assert.assertEquals(26, plano.getPeriodo(2).getCreditos());
		Assert.assertEquals(28, plano.getPeriodo(3).getCreditos());
		plano.addCadeira("Cálculo II", 1);
		Assert.assertEquals(28, plano.getPeriodo(1).getCreditos());
		Assert.assertEquals(22, plano.getPeriodo(2).getCreditos());
		Assert.assertEquals(28, plano.getPeriodo(3).getCreditos());

	}

	@Test
	public void deveAtualizarDificuldadeDoPeriodo()
			throws LimiteDeCreditosUltrapassadoException {
		Assert.assertEquals(25, plano.getPeriodo(1).getDificuldadeTotal());
		Assert.assertEquals(37, plano.getPeriodo(2).getDificuldadeTotal());
		plano.addCadeira("Cálculo II", 1);
		Assert.assertEquals(32, plano.getPeriodo(1).getDificuldadeTotal());
		Assert.assertEquals(30, plano.getPeriodo(2).getDificuldadeTotal());
	}

	@Test
	public void deveIniciarPlanoDeCursoComTodasDisciplinasAlocadas() {
		Assert.assertEquals(55, plano.getCadeirasAlocadas().size());
	}

	@Test
	public void naoDeveExcederLimiteDeCreditosPorPeriodo() {
		Assert.assertEquals(24, plano.getPeriodo(1).getCreditos());
		try {
			plano.addCadeira("Cálculo II", 1);
		} catch (LimiteDeCreditosUltrapassadoException e) {
			e.getMessage();
		}
		Assert.assertEquals(28, plano.getPeriodo(1).getCreditos());
		try {
			plano.addCadeira("Programação II", 1);
			Assert.fail("Adicionou uma disciplina que nao deveria");
		} catch (LimiteDeCreditosUltrapassadoException e) {
			e.getMessage();
		}
		Assert.assertEquals(28, plano.getPeriodo(1).getCreditos());
	}

	@Test
	public void devePermitirRemoverUmPreRequisito()
			throws LimiteDeCreditosUltrapassadoException {
		Assert.assertEquals(55, plano.getCadeirasAlocadas().size());
		Assert.assertEquals(0, plano.getCadeiraDispniveisOrdenadas().size());

		Assert.assertEquals(24, plano.getPeriodo(1).getCreditos());
		Assert.assertEquals(6, plano.getPeriodo(1).getCadeiras().size());
		Assert.assertEquals(26, plano.getPeriodo(2).getCreditos());
		Assert.assertEquals(28, plano.getPeriodo(3).getCreditos());

		plano.removeCadeira("Cálculo I");

		Assert.assertEquals(20, plano.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, plano.getPeriodo(1).getCadeiras().size());
		Assert.assertEquals(18, plano.getPeriodo(2).getCreditos());
		Assert.assertEquals(20, plano.getPeriodo(3).getCreditos());

		Assert.assertEquals(34, plano.getCadeirasAlocadas().size());
		Assert.assertEquals(21, plano.getCadeiraDispniveisOrdenadas().size());

		plano.addCadeira("Cálculo I", 1);

		Assert.assertEquals(24, plano.getPeriodo(1).getCreditos());
		Assert.assertEquals(6, plano.getPeriodo(1).getCadeiras().size());

		Assert.assertEquals(35, plano.getCadeirasAlocadas().size());
		Assert.assertEquals(20, plano.getCadeiraDispniveisOrdenadas().size());

		plano.removeCadeira("Cálculo I");

		Assert.assertEquals(34, plano.getCadeirasAlocadas().size());
		Assert.assertEquals(21, plano.getCadeiraDispniveisOrdenadas().size());

		Assert.assertEquals(20, plano.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, plano.getPeriodo(1).getCadeiras().size());

		plano.addCadeira("Cálculo II", 1);

		Assert.assertEquals(24, plano.getPeriodo(1).getCreditos());
		Assert.assertEquals(6, plano.getPeriodo(1).getCadeiras().size());

		Assert.assertEquals(35, plano.getCadeirasAlocadas().size());
		Assert.assertEquals(20, plano.getCadeiraDispniveisOrdenadas().size());

		plano.removeCadeira("Cálculo II");

		Assert.assertEquals(34, plano.getCadeirasAlocadas().size());
		Assert.assertEquals(21, plano.getCadeiraDispniveisOrdenadas().size());

		Assert.assertEquals(20, plano.getPeriodo(1).getCreditos());
		Assert.assertEquals(5, plano.getPeriodo(1).getCadeiras().size());

	}

	@Test
	public void deveCalcularOsConjuntosDeCreditos() {
		Assert.assertEquals(plano.getCreditosPeriodoAtual(), 24);
		Assert.assertEquals(plano.getCreditosPeriodosFuturos(), 190);
		Assert.assertEquals(plano.getCreditosPeriodosPassados(), 0);
		Assert.assertEquals(plano.getCreditosQueFaltamParaSeFormar(), 214);
		Assert.assertEquals(plano.totalCreditosCadeirasNaoAlocadas(), 0);
		plano.setPeriodoAtual(4);

		Assert.assertEquals(plano.getCreditosPeriodoAtual(), 26);
		Assert.assertEquals(plano.getCreditosPeriodosFuturos(), 110);
		Assert.assertEquals(plano.getCreditosPeriodosPassados(), 78);
		Assert.assertEquals(plano.totalCreditosCadeirasNaoAlocadas(), 0);
		Assert.assertEquals(plano.getCreditosQueFaltamParaSeFormar(), 136);

		plano.removeCadeira("Cálculo I");

		Assert.assertEquals(plano.getCreditosPeriodoAtual(), 10);
		Assert.assertEquals(plano.getCreditosPeriodosFuturos(), 60);
		Assert.assertEquals(plano.getCreditosPeriodosPassados(), 58);
		Assert.assertEquals(plano.totalCreditosCadeirasNaoAlocadas(), 86);
		Assert.assertEquals(plano.getCreditosQueFaltamParaSeFormar(), 156);
	}

}
