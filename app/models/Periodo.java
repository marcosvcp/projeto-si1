package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import models.validators.*;
import play.db.ebean.Model;

/**
 * Entidade que representa um período
 */
@Entity
public class Periodo extends Model implements Comparable<Periodo> {

	private static final long serialVersionUID = 1L;

	@Id
	Long id;

	private int numero;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "TB_PERIODO_CADEIRA", joinColumns = { @JoinColumn(name = "CD_PERIODO_CADEIRA") }, inverseJoinColumns = { @JoinColumn(name = "CD_CADEIRA") })
	private List<Cadeira> cadeiras;

	@Transient
	public static Finder<Long, Periodo> find = new Finder<Long, Periodo>(
			Long.class, Periodo.class);

	@Transient
	private ValidadorDePeriodo validador;

	/**
	 * Construtor default
	 */
	public Periodo() {
		cadeiras = new ArrayList<Cadeira>();
	}

	/**
	 * Construtor que recebe o numero do periodo
	 * 
	 * @param numeroDoPeriodo
	 */
	public Periodo(int numeroDoPeriodo) {
		this();
		this.numero = numeroDoPeriodo;
		cadeiras = new ArrayList<Cadeira>();
		this.validador = new ValidadorDeCreditos();
	}

	/**
	 * 
	 * @return id do periodo
	 */
	public Long getId() {
		return id;
	}

	/**
	 * cria periodo na tabela
	 * 
	 * @param p
	 */
	public static void create(Periodo p) {
		p.save();
	}

	/**
	 * deleta periodo a partir de sua id
	 * 
	 * @param id
	 */
	public static void delete(Long id) {
		find.ref(id).delete();
	}

	/**
	 * atualiza periodo
	 * 
	 * @param id
	 */
	public static void atualizar(Long id) {
		Periodo p = find.ref(id);
		p.update();
	}

	/**
	 * adiciona uma cadeira ao periodo
	 * 
	 * @param cadeira
	 */
	public void addCadeira(Cadeira cadeira) {
		cadeiras.add(cadeira);
	}

	/**
	 * remove uma cadeira do periodo
	 * 
	 * @param cadeira
	 */
	public void removerCadeira(Cadeira cadeira) {
		cadeiras.remove(cadeira);
	}

	/**
	 * 
	 * @return dificuldade do periodo
	 */
	public int getDificuldadeTotal() {
		int difi = 0;
		for (Cadeira c : getCadeiras()) {
			difi += c.getDificuldade();
		}
		return difi;
	}

	/**
	 * Calcula o total de Créditos do Periodo
	 * 
	 * Responsabilidade Atribuída seguindo o padrão Information Expert
	 */
	public int getCreditos() {
		int sum = 0;
		for (Cadeira c : getCadeiras()) {
			sum += c.getCreditos();
		}
		return sum;
	}

	/**
	 * 
	 * @return lista ordenada das cadeiras do periodo
	 */
	public List<Cadeira> getCadeiras() {
		Collections.sort(cadeiras);
		return cadeiras;
	}

	/**
	 * altera as cadeiras do periodo
	 * 
	 * @param lista
	 *            de cadeiras que vao substituir as antigas cadeiras do periodo
	 */
	public void setCadeiras(List<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}

	/**
	 * 
	 * @return numero do periodo
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * seta numero do periodo
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * 
	 * @return lista de cadeiras
	 */
	public List<Cadeira> getListaCadeiras() {
		return cadeiras;
	}

	/**
	 * busca uma cadeira no periodo
	 * 
	 * @param cadeira
	 * @return cadeira referente a String buscada
	 */
	public Cadeira getCadeira(String cadeira) {
		for (Cadeira c : cadeiras) {
			if (c.getNome().equals(cadeira)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * toString do periodo
	 */
	@Override
	public String toString() {
		return "Periodo " + getNumero();
	}

	/**
	 * 
	 * @return a estrategia atual do validador
	 */
	public ValidadorDePeriodo getValidador() {
		return validador;
	}

	/**
	 * Modifica a estrategia do validador
	 * 
	 * @param validador
	 *            estrategia a ser usada
	 */
	public void setValidador(ValidadorDePeriodo validador) {
		this.validador = validador;
	}

	@Override
	public int compareTo(Periodo o) {
		return this.getNumero() - o.getNumero();
	}
}