package fidelity.xtrac.com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String eMail;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	public User() {
	}

	public User(String eMail, String firstName, String lastName, String phoneNumber) {
		this.eMail = eMail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
