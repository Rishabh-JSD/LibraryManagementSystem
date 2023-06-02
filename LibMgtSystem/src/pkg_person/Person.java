package pkg_person;

import java.io.Serializable;
import java.util.regex.Pattern;

abstract public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4248511315144701150L;
	protected String name;
	protected String emailID;
	protected String phoneNumber;
	protected String address;
	protected String dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		boolean isValidName = Pattern.matches("[a-zA-Z]+", name);
		if(isValidName)
			this.name = name;
		else
			this.name = "Name is Not Valid ";
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		boolean isValidEmail = Pattern.matches("^(.+)@(.+)$" , emailID);
		if(isValidEmail)
			this.emailID = emailID;
		else
			this.emailID = "Email ID is Not Valid ";
		
	}
	public String getPhoneNumber() {
		
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		boolean isValidPhoneNumber = Pattern.matches("^(\\\\d{3}[- .]?){2}\\\\d{4}$", phoneNumber);
		if(isValidPhoneNumber)
			this.phoneNumber = phoneNumber;
		else
			this.phoneNumber = "please enter valid mobile number";
		
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		boolean isValidDob = Pattern.matches("\\d{2}-\\d{2}-\\d{4}", dob);
		if(isValidDob)
			this.dob = dob;
		else
			this.dob = "01-01-2000";
	}
	public Person(String name, String emailID, String phoneNumber, String address, String dob) {
		super();
		this.setName(name);
		this.setEmailID(emailID);
		this.setPhoneNumber(phoneNumber);
		this.address = address;
		this.setDob(dob);
	}
	public Person() {
		super();
	}

}
