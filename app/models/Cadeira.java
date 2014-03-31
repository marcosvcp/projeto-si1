package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import com.google.common.base.Objects;

/**
 * Entidade que representa uma Cadeira.
 */
@Entity
public class Cadeira extends Model implements Comparable<Cadeira> {

	private static final long serialVersionUID = 1L;

	// PADRÃO DE PROJETO: ALTA COESÃO - so haverá informações coerentes com
	// a classe

	@Id
	private Long id;

	@Constraints.Required
	@Column(unique = true, nullable = false)
	private String nome;

	private int creditos;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "CADEIRA_REQUISITO", joinColumns = { @JoinColumn(name = "CD_CADEIRA_1") }, inverseJoinColumns = { @JoinColumn(name = "CD_CADEIRA_2") })
	private List<Cadeira> preRequisitos;

	private int dificuldade; // dificuldade de 1 - 10

	@Column(name = "periodo_default")
	private int periodo;

	/**
	 * Construtor
	 */
	public Cadeira() {
		setPreRequisitos(new ArrayList<Cadeira>());
	}

	/**
	 * Retorna verdadeiro caso a cadeira {@code c} seja pre-requisito, Seguindo
	 * o padrão Information Expert, quem deve saber se uma cadeira é
	 * pre-requisito é a mesma.
	 */
	public boolean isPreRequisito(Cadeira c) {
		return this.getPreRequisitos().contains(c);
	}

	// PADRÃO DE PROJETO: INFORMATION EXPERT - a classe cadeira é a
	// responsável por guardar e adicionar pre-requisitos
	/**
	 * Adiciona um pre Requisito a cadeira
	 * 
	 * @param c
	 */
	public void addPreRequisito(Cadeira... c) {
		Cadeira[] lista = c;
		for (Cadeira cadeira : lista) {
			getPreRequisitos().add(cadeira);
		}
	}

	/**
	 * 
	 * @return lista de objeto Cadeira que sao pre requisitos da cadeira
	 */
	public List<Cadeira> getPreRequisitos() {
		return preRequisitos;
	}

	/**
	 * 
	 * @return nome da cadeira
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * seta a qt de creditos da cadeira
	 * 
	 * @param creditos
	 */
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	/**
	 * 
	 * @return qt de creditos da cadeira
	 */
	public int getCreditos() {
		return this.creditos;
	}

	/**
	 * seta dificuldade da cadeira
	 * 
	 * @param dificuldade
	 */
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	/**
	 * 
	 * @return a dificuldade da cadeira
	 */
	public int getDificuldade() {
		return dificuldade;
	}

	/**
	 * seta nome da cadeira
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * seta os pre requisitos da cadeira
	 * 
	 * @param lista
	 *            dos novos preRequisitos a ser setado
	 */
	public void setPreRequisitos(List<Cadeira> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

	/**
	 * 
	 * @return periodo da cadeira
	 */
	public int getPeriodo() {
		return periodo;
	}

	/**
	 * seta o periodo da cadeira
	 * 
	 * @param periodo
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public static Finder<Long, Cadeira> find = new Finder<Long, Cadeira>(
			Long.class, Cadeira.class);

	/**
	 * cria cadeira na tabela
	 * 
	 * @param c
	 */
	public static void create(Cadeira c) {
		c.save();
	}

	/**
	 * deleta cadeira a partir de sua id
	 * 
	 * @param id
	 */
	public static void delete(Long id) {
		find.ref(id).delete();
	}

	/**
	 * atualiza dados da cadeira
	 * 
	 * @param id
	 */
	public static void atualizar(Long id) {
		Cadeira p = find.ref(id);
		p.update();
	}

	/**
	 * Compara cadeiras
	 */
	@Override
	public int compareTo(Cadeira c) {
		return getNome().compareTo(c.getNome());
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(getNome(), creditos);
	}

	/**
	 * Verifica se duas cadeiras sao iguais
	 */
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
				&& Objects.equal(this.getNome(), other.getNome());
	}

	/**
	 * toString da cadeira que mostra nome, creditos e seus pre requisitos
	 */
	@Override
	public String toString() {
		String nomesPreRequisitos = "";
		if (preRequisitos.size() == 0) {
			nomesPreRequisitos += "Nenhum";
		} else {
			for (Cadeira c : preRequisitos) {
				nomesPreRequisitos += c.getNome() + " ; ";
			}
		}
		return "Pre-Requisitos: " + nomesPreRequisitos;
	}

	/**
	 * 
	 * @return id da cadeira
	 */
	public Long getId() {
		return id;
	}

	/**
	 * seta id da cadeira
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

}