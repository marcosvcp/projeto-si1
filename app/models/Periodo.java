package models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import managers.GerenciadorDeCadeiras;
import play.db.ebean.Model;

/**
 * Entidade que representa um período
 */
@Entity
public class Periodo extends Model {

	@Id
	private Long id;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "periodo_cadeira", joinColumns = { @JoinColumn(name = "fk_periodo") }, inverseJoinColumns = { @JoinColumn(name = "fk_cadeira") })
	private Map<String, Cadeira> cadeiras;
	private int numeroDoPeriodo;

	public Periodo(int numeroDoPeriodo) {
		this.numeroDoPeriodo = numeroDoPeriodo;
		cadeiras = new HashMap<String, Cadeira>();
		for(Cadeira cadeira: GerenciadorDeCadeiras.getMapaDeCadeiras().values()) {
			if(cadeira.getPeriodoDefault() == numeroDoPeriodo) {
				cadeiras.put(cadeira.getNome(), cadeira);
			}
		}
	}

	public int getNumero() {
		return numeroDoPeriodo;
	}

	public Collection<Cadeira> getCadeiras() {
		return cadeiras.values();
	}

	public Map<String, Cadeira> getMapCadeiras() {
		return cadeiras;
	}

	public Cadeira getCadeira(String cadeira) {
		return cadeiras.get(cadeira);
	}

	public void addCadeira(Cadeira cadeira) {
		cadeiras.put(cadeira.getNome(), cadeira);
	}

	public void removerCadeira(Cadeira cadeira) {
		cadeiras.remove(cadeira.getNome());
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
		for (Cadeira c : cadeiras.values()) {
			sum += c.getCreditos();
		}
		return sum;
	}

}