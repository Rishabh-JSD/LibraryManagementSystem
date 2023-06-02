package pkg_person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.ListIterator;

public class StudentManager {
	ObjectOutputStream oos_student = null;
	ObjectInputStream ois_student = null;
	
	File student_flie = null;
	
	ArrayList<Student> student_list = null;
	
	@SuppressWarnings("unchecked")
	public StudentManager() {
		student_flie = new File("Student.dat");
		student_list = new ArrayList<Student>();
		
		if(student_flie.exists()) {
			try {
				ois_student = new ObjectInputStream(new FileInputStream (student_flie));
				student_list = (ArrayList<Student>) ois_student.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addAStudent(Student student) {
		student_list.add(student);
	}
	public Student get (int rollNo) {
		for(Student student : student_list) {
			if(student.getRollNo() == rollNo)
				return student;
		}
		return null;
	}
	public void viewAllStudents() {
		for(Student student : student_list)
			System.out.println(student);
	}
	public boolean deleteStudent(int delete_rollNo) {
		ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();
		while(student_iterator.hasNext()) {
			Student student = student_iterator.next();
			if(student.getRollNo() == delete_rollNo) {
				student_list.remove(student);
				return true;
				
			}
		}
		return false;
	}
	public boolean updateStudent(int update_rollNo,String name, String emailID, String phoneNumber, String address, String dob, int std,String divison) {
		ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();
		while(student_iterator.hasNext()) {
			Student student = student_iterator.next();
			if(student.getRollNo() == update_rollNo) {
				student.setName(name);
				student.setEmailID(emailID);
				student.setPhoneNumber(phoneNumber);
				student.setAddress(address);
				student.setDob(dob);
				student.setStd(std);
				student.setDivison(divison);
				return true;
				
				
			}
				
			}
		
		
		return false;
		
	}
	public void writeToFile() {
		try {
			oos_student = new ObjectOutputStream(new FileOutputStream(student_flie));
			oos_student.writeObject(student_list);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
