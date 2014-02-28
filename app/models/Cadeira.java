package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

import com.google.common.base.Objects;

/**
 * Entidade que representa uma Cadeira.
 */
@Entity
public class Cadeira extends Model implements Comparable<Cadeira> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// TODO PADRÃO DE PROJETO: ALTA COESÃO - so haverá informações coerentes com
	// a classe
	@Id
	private Long id;

	private String nome;

	private int creditos;

	private int dificuldade; // dificuldade de 1 - 10

	private int periodoDefault;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cadeira_requisito", joinColumns = { @JoinColumn(name = "fk_cadeira") }, inverseJoinColumns = { @JoinColumn(name = "fk_requisito") })
	private List<Cadeira> preRequisitos;

	// Construtor Default
	public Cadeira() {
		setPreRequisitos(new ArrayList<Cadeira>());
	}

	public Cadeira(String nome, int dificuldade) {
		this.setNome(nome);
		this.creditos = 4;
		this.dificuldade = dificuldade;
		setPreRequisitos(new ArrayList<Cadeira>());
	}

	public Cadeira(String nome, int dificuldade, int creditos) {
		this(nome, dificuldade);
		this.creditos = creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getCreditos() {
		return this.creditos;
	}

	public String getNome() {
		return this.nome;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public static Finder<Long, Cadeira> find = new Finder<Long, Cadeira>(
			Long.class, Cadeira.class);

	public List<Cadeira> getPreRequisitos() {
		return preRequisitos;
	}

	// TODO PADRÃO DE PROJETO: INFORMATION EXPERT - a classe cadeira é a
	// responsável por guardar e adicionar pre-requisitos
	public void addPreRequisito(Cadeira... c) {
		Cadeira[] lista = c;
		for (Cadeira cadeira : lista) {
			getPreRequisitos().add(cadeira);
		}
	}

	/**
	 * Retorna verdadeiro caso a cadeira {@code c} seja pre-requisito, Seguindo
	 * o padrão Information Expert, quem deve saber se uma cadeira é
	 * pre-requisito é a mesma.
	 */
	public boolean isPreRequisito(Cadeira c) {
		return this.getPreRequisitos().contains(c);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getNome(), creditos, getPreRequisitos());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadeira other = (Cadeira) obj;
		return Objects.equal(this.getCreditos(), other.getCreditos())
				&& Objects.equal(this.getNome(), other.getNome())
				&& Objects.equal(this.getPreRequisitos(),
						other.getPreRequisitos());
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPreRequisitos(List<Cadeira> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

	@Override
	public int compareTo(Cadeira c) {
		return getNome().compareTo(c.getNome());
	}

	public int getPeriodoDefault() {
		return periodoDefault;
	}

	public void setPeriodoDefault(int periodoDefault) {
		this.periodoDefault = periodoDefault;
	}

	@Override
	public String toString() {
		return getNome();
	}
}