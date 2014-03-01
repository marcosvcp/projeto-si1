package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import play.db.ebean.Model;

/**
 * Entidade que representa um período
 */
@Entity
public class Periodo extends Model {

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

	public Periodo() {
		cadeiras = new ArrayList<Cadeira>();
	}

	public Periodo(int numeroDoPeriodo) {
		this.numero = numeroDoPeriodo;
		cadeiras = new ArrayList<Cadeira>();
	}

	public Long getId() {
		return id;
	}

	public static void create(Periodo p) {
		p.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static void atualizar(Long id) {
		Periodo p = find.ref(id);
		p.update();
	}

	public void addCadeira(Cadeira cadeira) {
		cadeiras.add(cadeira);
	}

	public void removerCadeira(Cadeira cadeira) {
		cadeiras.remove(cadeira);
	}

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

	public List<Cadeira> getCadeiras() {
		Collections.sort(cadeiras);
		return cadeiras;
	}

	public void setCadeiras(List<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Cadeira> getListaCadeiras() {
		return cadeiras;
	}

	public Cadeira getCadeira(String cadeira) {
		for (Cadeira c : cadeiras) {
			if (c.getNome().equals(cadeira)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Periodo " + getNumero();
	}

}