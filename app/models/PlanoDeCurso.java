package models;

import java.util.ArrayList;
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
import models.exceptions.LimiteDeCreditosUltrapassadoException;
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
		mapaDeCadeiras = GerenciadorDeCadeiras.getMapaDeCadeiras();
	}

	public PlanoDeCurso(boolean iniciaPeriodos) {
		this();
		// TODO Responsabilidade Atribuita seguindo o padrão Creator
		// O plano de curso ficou responsável por criar os períodos.
		if (iniciaPeriodos) {
			this.setPeriodos(new ArrayList<Periodo>());
			for (int i = 1; i < 11; i++) {
				this.getPeriodos().add(new Periodo(i));
			}
		}
	}

	/**
	 * Retorna o período passado como argumento.
	 * 
	 * @param numPeriodo
	 *            número relativo ao periodo 1,2,3...
	 */
	public Periodo getPeriodo(int numPeriodo) {
		return this.getPeriodos().get(numPeriodo);
	}

	public List<Periodo> getPeriodos() {
		return this.periodos;
	}

	public boolean isAlocadaNoLugarCorreto(Cadeira c, Periodo p) {
		return verificaPreRequisitos(c, p.getNumero());
	}

	/**
	 * Adiciona uma {@code cadeira} ao {@code periodo}
	 * 
	 * @throws Exception
	 */
	public void transfereCadeira(String cadeiraNome, int periodo)
			throws Exception {
		// TODO PADRÃO DE PROJETO: CONTROLLER - para manter o baixo acoplamento
		// essa classe vai ser a responsável por adicionar um cadeira ao periodo
		Cadeira cadeira = mapaDeCadeiras.get(cadeiraNome);
		if (getPeriodo(periodo).getCreditos() + cadeira.getCreditos() > MAXIMO_CREDITOS) {
			throw new LimiteDeCreditosUltrapassadoException("limite de créditos ultrapassado!");
		}
		removeCadeira(cadeira);
		getPeriodo(periodo).addCadeira(cadeira);
	}

	/**
	 * Verifica se os pre-requisitos de uma certa cadeira já foram concluídos.
	 */
	private boolean verificaPreRequisitos(Cadeira cadeira, int periodo) {
		// verifica se a cadeira tem algum pre-requisito em um periodo posterior
		// ao que está sendo adicionado
		for (int i = periodo; i < getPeriodos().size(); i++) {
			for (Cadeira c : getPeriodos().get(i).getCadeiras()) {
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
		this.setPeriodos(getPeriodos().subList(0, periodo - 1));
	}

	public void removeCadeira(Cadeira cadeira) throws Exception {
		// TODO PADRÃO DE PROJETO: CONTROLLER - para manter o baixo acoplamento
		// essa classe vai ser a responsável por remover uma cadeira ao periodo
		// procura pela cadeira entre os periodos.
		for (Periodo periodo : getPeriodos()) {
			// remove a cadeira
			if (periodo.getCadeiras().contains(cadeira)) {
				periodo.removerCadeira(cadeira);
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
		for (Periodo periodo : getPeriodos()) {
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
			p.addCadeira(c);
		}
	}

	public void distribuiCadeiras(List<Cadeira> cadeiras) {
		Map<String, Cadeira> mapa = new HashMap<String, Cadeira>();
		for (Cadeira c : cadeiras) {
			mapa.put(c.getNome(), c);
		}
		mapaDeCadeiras = mapa;
		// distribuiCadeiras();
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
}