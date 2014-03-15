package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import models.exceptions.LimiteDeCreditosUltrapassadoException;
import models.validators.ValidadorMaximoCreditos;
import play.db.ebean.Model;

/**
 * Entidade que representa o Plano de Curso do sistema.
 */
@Entity
public class PlanoDeCurso extends Model {

	// PADRÃO DE PROJETO: ALTA COESÃO - so haverá informações coerentes com
	// a classe

	private static final long serialVersionUID = 1L;

	@Id
	Long id;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "TB_PLANO_PERIODO", joinColumns = { @JoinColumn(name = "CD_PLANO_PERIODO") }, inverseJoinColumns = { @JoinColumn(name = "CD_PERIODO") })
	private List<Periodo> periodos;

	@OneToOne
	List<Cadeira> cadeirasDisponiveis;

	private Map<String, Cadeira> mapaDeCadeiras;

	@Transient
	public static final int MAXIMO_CREDITOS = 28;

	@Transient
	public static final int MINIMO_CREDITOS = 14;

	@Transient
	public static final int ULTIMO_PERIODO = 10;

	@Transient
	public static Finder<Long, PlanoDeCurso> find = new Finder<Long, PlanoDeCurso>(
			Long.class, PlanoDeCurso.class);
	/**
	 * Construtor
	 */
	public PlanoDeCurso() {
		// Responsabilidade Atribuita seguindo o padrão Creator
		// O plano de curso ficou responsável por criar os períodos.
		this.periodos = new ArrayList<Periodo>();
		this.cadeirasDisponiveis =  new ArrayList<Cadeira>();

		for (int i = 1; i <= ULTIMO_PERIODO; i++) {
			periodos.add(new Periodo(i));
		}
		// seta o mapa de cadeiras com as cadeiras do xml
		this.mapaDeCadeiras = new HashMap<String, Cadeira>();

		// irá distribuir as cadeiras entre os periodos
		distribuiCadeiras();
	}

	/**
	 * 
	 * @return id do plano de curso
	 */
	public Long getId() {
		return id;
	}

	/**
	 * cria plano de curso na tabela
	 * 
	 * @param p
	 */
	public static void create(PlanoDeCurso p) {
		p.save();
	}

	/**
	 * deleta o plano a partir de sua id
	 * 
	 * @param id
	 */
	public static void delete(Long id) {
		find.ref(id).delete();
	}

	/**
	 * atualiza o plano
	 * 
	 * @param id
	 */
	public static void atualizar(Long id) {
		PlanoDeCurso p = find.ref(id);
		p.update();
	}

	/**
	 * Distribui as cadeiras em seus respectivos períodos.
	 */
	private void distribuiCadeiras() {
		for (Cadeira c : mapaDeCadeiras.values()) {
			if (c.getPeriodo() != 0) {
				Periodo p = getPeriodo(c.getPeriodo());
				p.addCadeira(c);
			}
		}
	}

	/**
	 * Distribui Cadeiras entre os periodos quando o plano é iniciado pela
	 * primeira vez.
	 */
	public void distribuiCaderas(List<Cadeira> cadeiras) {
		atualizaMapaCadeira(cadeiras);
		distribuiCadeiras();
	}

	/**
	 * Atualiza o mapadecadeiras das disciplinas com base em uma lista de todas
	 * as cadeiras existentes.
	 */
	public void atualizaMapaCadeira(List<Cadeira> cadeiras) {
		Map<String, Cadeira> mapa = new HashMap<String, Cadeira>();
		for (Cadeira c : cadeiras) {
			mapa.put(c.getNome(), c);
		}
		mapaDeCadeiras = mapa;
	}

	/**
	 * Adiciona um periodo à lista de períodos, de acordo com o tamanho da
	 * lista.
	 * 
	 * Seguindo o padrão creator.
	 */
	public void addPeriodo() {
		this.periodos.add(new Periodo(this.periodos.size() + 1));
	}

	/**
	 * adiciona um periodo, especificando qual o seu numero
	 * 
	 * @param num_periodo
	 */
	public void addPeriodo(int num_periodo) {
		this.periodos.add(new Periodo(num_periodo));
	}

	/**
	 * Retorna o período passado como argumento.
	 * 
	 * @param numPeriodo
	 *            número relativo ao periodo 1,2,3...
	 */
	public Periodo getPeriodo(int numPeriodo) {
		return this.periodos.get(numPeriodo - 1);
	}
	
	/**
	 * 
	 * @return lista com todos os periodos
	 */
	public List<Periodo> getPeriodos() {
		return this.periodos;
	}
	
	/**
	 * 
	 * @return um mapa de cadeira do curso
	 */
	public Map<String, Cadeira> getMapaCadeira() {
		return mapaDeCadeiras;
	}

	/**
	 * Retorna uma lista de cadeiras já alocadas nos periodoss.
	 */
	public List<Cadeira> getCadeirasAlocadas() {
		List<Cadeira> alocadas = new ArrayList<Cadeira>();
		for (Periodo periodo : periodos) {
			alocadas.addAll(periodo.getCadeiras());
		}
		return alocadas;
	}

	/**
	 * Retorna o Map de cadeiras ainda não alocadas no plano de curso.
	 */
	public Map<String, Cadeira> getMapCadeirasDisponiveis() {
		Map<String, Cadeira> disponiveis = new HashMap<String, Cadeira>();
		List<Cadeira> alocadas = getCadeirasAlocadas();
		for (Cadeira c : mapaDeCadeiras.values()) {
			if (!alocadas.contains(c) && !(this.cadeirasDisponiveis.contains(c))) {
				disponiveis.put(c.getNome(), c);
			}
		}
		return disponiveis;
	}

	/**
	 * Retorna a lista de cadeira disponíveis para alocação ordenadas em ordem
	 * alfabética.
	 */
	public List<Cadeira> getCadeiraDispniveisOrdenadas() {
		cadeirasDisponiveis.addAll(getMapCadeirasDisponiveis().values());
		Collections.sort(cadeirasDisponiveis);
		return cadeirasDisponiveis;
	}

	/**
	 * Adiciona uma {@code cadeira} ao {@code periodo}
	 * 
	 * @throws LimiteUltrapassadoException
	 * 
	 * @throws Exception
	 */
	public void addCadeira(String cadeiraNome, int periodo)
			throws LimiteDeCreditosUltrapassadoException {
		// PADRÃO DE PROJETO: CONTROLLER - para manter o baixo acoplamento
		// essa classe vai ser a responsável por adicionar um cadeira ao periodo
		Cadeira cadeira = mapaDeCadeiras.get(cadeiraNome);
		Periodo periodoCorrente = getPeriodo(periodo);
		int creditosTotais = periodoCorrente.getCreditos()
				+ cadeira.getCreditos();
		periodoCorrente.setValidador(new ValidadorMaximoCreditos());
		if (!periodoCorrente.getValidador().validaPeriodo(creditosTotais)) {
			throw new LimiteDeCreditosUltrapassadoException(
					"Limite de Créditos Ultrapassado!");
		}
		// verificaPreRequisitos(cadeira, periodo);

		// remove cadeira do periodo ou da lista de disciplinas disponiveis
		if (cadeirasDisponiveis.contains(cadeira)) {
			cadeirasDisponiveis.remove(cadeira);
		}
		for (Periodo p : periodos) {
			if (p.getCadeiras().contains(cadeira)) {
				p.removerCadeira(cadeira);
			}
		}

		// adiciona essa cadeira no periodo escolhido
		getPeriodo(periodo).addCadeira(cadeira);
	}

	/**
	 * remove uma cadeira
	 * 
	 * @param cadeira
	 */
	public void removeCadeira(String cadeira) {
		// PADRÃO DE PROJETO: CONTROLLER - para manter o baixo acoplamento
		// essa classe vai ser a responsável por remover uma cadeira ao periodo
		// if (getMapCadeirasAlocadas().get(cadeira) == null) {
		// throw new Exception("Essa Cadeira não está alocada!");
		// }
		Cadeira removida = mapaDeCadeiras.get(cadeira);
		// procura pela cadeira entre os periodos.
		getPeriodo(removida.getPeriodo()).removerCadeira(removida);
		// removida.setPeriodo(0);
		List<Cadeira> paraRemover = new ArrayList<Cadeira>();
		for (Periodo p : periodos) {
			for (Cadeira c : p.getCadeiras()) {
				if (c.isPreRequisito(removida)) {
					paraRemover.add(c);
				}
			}
		}
		for (Cadeira c : paraRemover) {
			removeCadeira(c.getNome());
		}
	}
	
	/**
	 * Verifica se uma cadeira esta alocada corretamentes
	 * 
	 * @param c
	 * @param p
	 * @return
	 */
	public boolean isAlocadaNoLugarCorreto(Cadeira c, Periodo p) {
		return verificaPreRequisitos(c, p.getNumero());
	}

	/**
	 * Verifica se os pre-requisitos de uma certa cadeira já foram concluídos.
	 */
	private boolean verificaPreRequisitos(Cadeira cadeira, int periodo) {
		// verifica se a cadeira tem algum pre-requisito em um periodo posterior
		// ao que está sendo adicionado
		for (int i = periodo; i <= getPeriodos().size(); i++) {
			for (Cadeira c : getPeriodo(i).getCadeiras()) {
				if (cadeira.getPreRequisitos().contains(c)) {
					return false;
				}
			}
		}
		for (Cadeira c : cadeira.getPreRequisitos()) {
			if (this.getCadeiraDispniveisOrdenadas().contains(c)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Retorna true caso a {@code cadeira} seja pre-requisito de alguma outra
	 * nos {@code periodos}.
	 */
	public boolean isPreRequisito(String cad) {
		Cadeira cadeira = mapaDeCadeiras.get(cad);
		// procura pela cadeira entre os periodos.
		for (Periodo periodo : periodos) {
			// verifica as cadeiras que tem a cadeira a ser removida como
			// pre-requisito
			for (Cadeira cadeiraDoPeriodo : periodo.getCadeiras()) {
				if (cadeiraDoPeriodo.getPreRequisitos().contains(cadeira)) {
					return true;
				}
			}
		}
		return false;
	}
}