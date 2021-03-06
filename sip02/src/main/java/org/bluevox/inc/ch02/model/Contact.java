/**
 * 
 */
package org.bluevox.inc.ch02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import org.bluevox.inc.util.StringUtils;

/**
 * @author wnorman
 *
 */
@Entity
@Table(name = "contact")
@NamedQuery(
		name = "findContactsByEmail",
		query = "from Contact where email like :email")
public class Contact {
	private Long id;
	private String lastName;
	private String firstName;
	private String middleInitial;
	private String email;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() { return id; }
	
	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Length(min = 1, max = 40)
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@NotNull
	@Length(min = 1, max = 40)
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Length(max = 1)
	@Column(name = "mi")
	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	@Email
	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Transient
	public String getFullName() {
		String fullName = lastName + ", " + firstName;
		if (! (middleInitial == null || "".equals(middleInitial.trim()))) {
			fullName += " " + middleInitial + ".";
		}
		return fullName;
	}
	
	@Override
	public String toString() {
		return "[Contact: id=" + id
				+ ", firstName=" + firstName
				+ ", middleInitial=" + middleInitial
				+ ", lastName=" + lastName
				+ ", email=" + email
				+ "]";
	}

}
