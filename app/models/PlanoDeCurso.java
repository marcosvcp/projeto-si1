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
import javax.persistence.Transient;
import javax.transaction.NotSupportedException;

import managers.GerenciadorDeCadeiras;
import play.db.ebean.Model;

/**
 * Entidade que representa o Plano de Curso do sistema.
 */
@Entity
public class PlanoDeCurso extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	// TODO PADRÃO DE PROJETO: ALTA COESÃO - so haverá informações coerentes com
	// a classe
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "plano_periodo", joinColumns = { @JoinColumn(name = "fk_plano") }, inverseJoinColumns = { @JoinColumn(name = "fk_periodo") })
	private List<Periodo> periodos;

	@Transient
	public Map<String, Cadeira> mapaDeCadeiras;

	@Transient
	public static final int PRIMEIRO_PERIODO = 1;

	@Transient
	public static final int MAXIMO_CREDITOS = 28;

	public PlanoDeCurso() {
		// TODO Responsabilidade Atribuita seguindo o padrão Creator
		// O plano de curso ficou responsável por criar os períodos.
		mapaDeCadeiras = GerenciadorDeCadeiras.getMapaDeCadeiras();
		this.periodos = new ArrayList<Periodo>();
		for (int i = 1; i < 11; i++) {
			this.periodos.add(new Periodo(i));
		}
		// distribuiCadeiras(new ArrayList<Cadeira>(GerenciadorDeCadeiras
		// .getMapaDeCadeiras().values()));
	}

	/**
	 * Retorna o período passado como argumento.
	 * 
	 * @param numPeriodo
	 *            número relativo ao periodo 1,2,3...
	 */
	public Periodo getPeriodo(int numPeriodo) {
		return this.periodos.get(numPeriodo);
	}

	public List<Periodo> getPeriodos() {
		return this.periodos;
	}

	/**
	 * Retorna o Map de cadeiras já alocadas no plano de curso.
	 */
	public Map<String, Cadeira> getMapCadeirasAlocadas() {
		Map<String, Cadeira> alocadas = new HashMap<String, Cadeira>();
		for (Periodo periodo : periodos) {
			alocadas.putAll(periodo.getMapCadeiras());
		}
		return alocadas;
	}

	public boolean isAlocadaNoLugarCorreto(Cadeira c, Periodo p) {
		return verificaPreRequisitos(c, p.getNumero());
	}

	/**
	 * Retorna o Map de cadeiras ainda não alocadas no plano de curso.
	 */
	public Map<String, Cadeira> getMapCadeirasDisponiveis() {
		Map<String, Cadeira> disponiveis = new HashMap<String, Cadeira>();
		Map<String, Cadeira> alocadas = getMapCadeirasAlocadas();
		for (String nomeCadeira : mapaDeCadeiras.keySet()) {
			if (!alocadas.containsKey(nomeCadeira)) {
				disponiveis.put(nomeCadeira, mapaDeCadeiras.get(nomeCadeira));
			}
		}
		return disponiveis;
	}

	/**
	 * Retorna a lista de cadeira disponíveis para alocação ordenadas em ordem
	 * alfabética.
	 */
	public List<Cadeira> getCadeiraDispniveisOrdenadas() {
		List<Cadeira> cadeirasOrdenadas = new ArrayList<Cadeira>();
		cadeirasOrdenadas.addAll(getMapCadeirasDisponiveis().values());
		Collections.sort(cadeirasOrdenadas);
		return cadeirasOrdenadas;
	}

	/**
	 * Adiciona uma {@code cadeira} ao {@code periodo}
	 * 
	 * @throws Exception
	 */
	public void addCadeira(String cadeiraNome, int periodo) throws Exception {
		// TODO PADRÃO DE PROJETO: CONTROLLER - para manter o baixo acoplamento
		// essa classe vai ser a responsável por adicionar um cadeira ao periodo
		Cadeira cadeira = mapaDeCadeiras.get(cadeiraNome);
		if (getPeriodo(periodo).getCreditos() + cadeira.getCreditos() > MAXIMO_CREDITOS) {
			throw new NotSupportedException("limite de créditos ultrapassado!");
		}
		getPeriodo(periodo).addCadeira(cadeira);
	}

	/**
	 * Verifica se os pre-requisitos de uma certa cadeira já foram concluídos.
	 */
	private boolean verificaPreRequisitos(Cadeira cadeira, int periodo) {
		Map<String, Cadeira> alocadas = getMapCadeirasAlocadas();
		for (Cadeira cadeiraPeriodo : cadeira.getPreRequisitos()) {
			if (!alocadas.containsKey(cadeiraPeriodo.getNome())) {
				return false;
			}
		}
		// verifica se a cadeira tem algum pre-requisito em um periodo posterior
		// ao que está sendo adicionado
		for (int i = periodo; i < periodos.size(); i++) {
			for (Cadeira c : periodos.get(i).getCadeiras()) {
				if (cadeira.getPreRequisitos().contains(c)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Remove o período e todos os posteriores
	 */
	public void removePeriodo(int periodo) {
		this.periodos = periodos.subList(0, periodo - 1);
	}

	public void removeCadeira(String cadeira) throws Exception {
		// TODO PADRÃO DE PROJETO: CONTROLLER - para manter o baixo acoplamento
		// essa classe vai ser a responsável por remover uma cadeira ao periodo
		if (getMapCadeirasAlocadas().get(cadeira) == null) {
			throw new Exception("Essa Cadeira não está alocada!");
		}
		Cadeira removida = getMapCadeirasAlocadas().get(cadeira);
		// procura pela cadeira entre os periodos.
		for (Periodo periodo : periodos) {
			// remove a cadeira
			if (periodo.getMapCadeiras().get(cadeira) != null) {
				periodo.removerCadeira(removida);
			}
			// verifica as cadeiras que tem a cadeira a ser removida como
			// pre-requisito e remove
			for (Cadeira c : periodo.getCadeiras()) {
				if (c.getPreRequisitos().contains(removida)) {
					removeCadeira(c.getNome());
				}
			}
		}
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

	/**
	 * Distribui as cadeiras recém-retiradas do xml e adiciona em seus
	 * respectivos períodos
	 */
	public void distribuiCadeiras() {
		for (Cadeira c : mapaDeCadeiras.values()) {
			Periodo p = getPeriodo(c.getPeriodoDefault());
			try {
				System.out.println("QUEBROU AQUI " + c);
				p.addCadeira(c);
			} catch (Exception e) {
				System.out.println("QUEBROU AQUI");
			}
		}
	}

	public void distribuiCadeiras(List<Cadeira> cadeiras) {
		Map<String, Cadeira> mapa = new HashMap<String, Cadeira>();
		for (Cadeira c : cadeiras) {
			mapa.put(c.getNome(), c);
		}
		mapaDeCadeiras = mapa;
		distribuiCadeiras();
	}
}