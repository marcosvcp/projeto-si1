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
	// -- Queries

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

	// --

	public String toString() {
		return "User(" + getName() + ")";
	}

	public PlanoDeCurso getPlano() {
		return plano;
	}

	public void setPlano(PlanoDeCurso plano) {
		this.plano = plano;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		this.password = String.valueOf(this.hashCode());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(email, password);
	}

}
