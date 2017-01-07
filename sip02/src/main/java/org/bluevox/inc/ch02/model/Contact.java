/**
 * 
 */
package org.bluevox.inc.ch02.model;

/**
 * @author wnorman
 *
 */
public class Contact {
	private Long id;
	private String lastName;
	private String firstName;
	private String middleInitial;
	private String email;
	
	public Long getId() { return id; }
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
