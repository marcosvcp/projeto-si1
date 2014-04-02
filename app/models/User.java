package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import com.google.common.base.Objects;

/**
 * User entity managed by Ebean
 */
@Entity
@Table(name = "account")
public class User extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@Constraints.Required
	@Formats.NonEmpty
	private String email;

	@Constraints.Required
	private String name;

	@Constraints.Required
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	private PlanoDeCurso plano;

	public static Model.Finder<String, User> find = new Model.Finder<String, User>(
			String.class, User.class);

	/**
	 * Retrieve all users.
	 */
	public static List<User> findAll() {
		return find.all();
	}

	/**
	 * Retrieve a User from email.
	 */
	public static User findByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}

	/**
	 * Authenticate a User.
	 */
	public static User authenticate(String email, String password) {
		return find.where().eq("email", email).eq("password", password)
				.findUnique();
	}

	/**
	 * 
	 * @return o plano de curso do usuario
	 */
	public PlanoDeCurso getPlano() {
		return plano;
	}

	/**
	 * Altera o plano de curso do usuario
	 * @param plano
	 */
	public void setPlano(PlanoDeCurso plano) {
		this.plano = plano;
	}

	/**
	 * 
	 * @return o email do usuario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * altera o email do usuario
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return nome do usuario
	 */
	public String getName() {
		return name;
	}

	/**
	 * altera nome do usuario
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return a senha do usuario
	 */
	public String getPassword() {
		return password;
	}
	

	/**
	 * altera a senha do usuario
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
		this.password = String.valueOf(this.hashCode());
	}
	
	
	/**
	 * toString para usuario
	 */
	@Override
	public String toString() {
		return "User(" + getName() + ")";
	}

	/**
	 * hashCode para usuario
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(email, password);
	}
}
