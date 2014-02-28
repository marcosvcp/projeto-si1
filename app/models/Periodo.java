package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import managers.GerenciadorDeCadeiras;
import play.db.ebean.Model;

import com.google.common.base.Objects;

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
	private List<Cadeira> cadeiras;
	
	private int numeroDoPeriodo;

	public Periodo() {
		cadeiras = new ArrayList<Cadeira>();
	}
	public Periodo(int numeroDoPeriodo) {
		this.numeroDoPeriodo = numeroDoPeriodo;
		cadeiras = new ArrayList<Cadeira>();
		for (Cadeira cadeira : GerenciadorDeCadeiras.getMapaDeCadeiras()
				.values()) {
			if (cadeira.getPeriodoDefault() == numeroDoPeriodo) {
				cadeiras.add(cadeira);
			}
		}
	}

	public int getNumero() {
		return numeroDoPeriodo;
	}

	public Collection<Cadeira> getCadeiras() {
		return cadeiras;
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
		for (Cadeira c : cadeiras) {
			sum += c.getCreditos();
		}
		return sum;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(numeroDoPeriodo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodo other = (Periodo) obj;
		return Objects.equal(this.numeroDoPeriodo, other.getNumero());
	}

}