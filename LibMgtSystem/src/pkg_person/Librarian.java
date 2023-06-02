package pkg_person;

public class Librarian extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2169225889916199395L;
	private int id;
	private String doj;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", doj=" + doj + ", name=" + name + ", emailID=" + emailID + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", dob=" + dob + "]";
	}
	public Librarian(String name, String emailID, String phoneNumber, String address, String dob, int id, String doj) {
		super(name, emailID, phoneNumber, address, dob);
		this.id = id;
		this.doj = doj;
	}
	public Librarian() {
		super();
	}
	

}
