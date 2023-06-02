package pkg_main;



import java.util.Scanner;

import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_book.Book;
import pkg_book.BookManager;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;
import pkg_transaction.BookTransactionManager;


public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		int choice;
		
		Scanner sc = new Scanner(System.in);
		
		BookManager bm = new BookManager();
		StudentManager sm = new StudentManager();
		
		BookTransactionManager btm = new BookTransactionManager();
		
		do {
			System.out.println("Enter 1 if Student\n  Enter 2 if Librarin\n Enter 3 if want to exit\n");
			choice = sc.nextInt();
			
			if(choice == 1){
				System.out.println("Enter your Number");
				int rollNo = sc.nextInt();
				try{
					Student s = sm.get(rollNo);
					if(s == null)
						throw new StudentNotFoundException();
					int stud_choice;
					do{
						System.out.println("Enter 1 to view all books\nEnter 2 to Search books by ISBN\nEnter 3 to Search books by Subject\nEnter 4 to issue a book\n Enter 5 to Return a book\nEnter 99 to exit");
						stud_choice = sc.nextInt();
						switch(stud_choice){
							case 1:
							System.out.println("View all Books Records");
							bm.viewAllBooks();
								break;
							case 2:
							System.out.println("Please Enter Isbn to Search the book");
								
								int search_isbn = sc.nextInt();
								Book book = bm.searchBookByIsbn(search_isbn);
								if(book == null)
									System.out.println("No Book with this ISBN exists in our Library");
								else
									System.out.println(book);
							
							
								break;
							case 3:
							System.out.println("Enter the subject to Sarch by Subject ");
							sc.nextLine();
							String search_subject = sc.nextLine();
							bm.listBooksBySubject(search_subject);
								break;
							case 4:
							System.out.println("Enter the isbn to issue  a ISBN of book");
							sc.nextInt();
							int issue_isbn = sc.nextInt();
							book = bm.searchBookByIsbn(issue_isbn);
							try{
									if(book != null){
										throw new BookNotFoundException();
										
									}
									if(book.getAvailable_quantity() > 0){
										if(btm.issueBook(rollNo,issue_isbn)){
											book.setAvailable_quantity(book.getAvailable_quantity() -1);
											System.out.println("Book has been Issued");
										}
									}
									else{
										System.out.println("The Book Quantity is not available");
									}
							}catch(BookNotFoundException bnfe){
								System.out.println(bnfe);
							}
								break;
							case 5:
							System.out.println("Please enter the ISBN to Return a book");
							
							int return_isbn = sc.nextInt();
							book = bm.searchBookByIsbn(return_isbn);
							if(book != null){
								if(btm.returnBook(rollNo,return_isbn)){
									book.setAvailable_quantity(book.getAvailable_quantity() + 1);
									System.out.println("Book has been Returned Successfully");
								}
								else
									System.out.println("Could not Return Book");
									
							}
							else
								System.out.println("Book with this ISBN does not exist");
									
								break;
							case 99:
							System.out.println("Thank You for using Library");
								break;
							default :
							System.out.println("Invalid Choice");
						}
					}while(stud_choice != 99);
				}
				catch(StudentNotFoundException snfe){
					System.out.println(snfe);
				}
			}
			else if(choice == 2){
				int lib_choice;
				do{
				
				System.out.println("Enter 11 to view all Students\nEnter 12 to print Student by Roll Number\nEnter 13 to register a student\nEnter 14 to update a student\n Enter 15 to Delete a student");
				System.out.println("Enter 21 to view all books\nEnter 22 to print a book by ISBN\nEnter 23 to add a new book\nEnter 24 to update a book\n Enter 25 to delete a book");
				System.out.println("Enter 31 to view Transactions");
				System.out.println("Enter 99 to exit ");
				lib_choice = sc.nextInt();
			switch(lib_choice){
							case 11:
							System.out.println("View all Student Records");
							sm.viewAllStudents();
								break;
							case 12:
							System.out.println("print Student by Roll Number");
							int get_rollNo = sc.nextInt();
							Student student = sm.get(get_rollNo);
							if(student == null){
								System.out.println("No records matches this Roll Number");
							}
							else
								System.out.println(student);
								break;
							case 13:
							System.out.println("Enter all details to add a student");
							String name;
							String emailID;
							String phoneNumber;
							String address;
							String dob;
							int rollNo;
							int std;
							String divison;
							
							
							sc.nextLine();
							
							System.out.println("Name");
							name = sc.nextLine();
							
							
							System.out.println("Email ID");
							emailID = sc.nextLine();
							
							System.out.println("PhoneNumber");
							phoneNumber = sc.nextLine();
							
							System.out.println("address");
							address = sc.nextLine();
							
							System.out.println("dob");
							dob = sc.nextLine();
							
							System.out.println("Roll Number as integer");
							rollNo = sc.nextInt();
							
							System.out.println("Standard as integer");
							std = sc.nextInt();
							sc.nextLine();
							
							System.out.println("Division");
							divison = sc.nextLine();
							
							student = new Student(name,emailID,phoneNumber,address,dob,rollNo,std,divison);
							sm.addAStudent(student);
							System.out.println("Student is Added");
							
			
								break;
							case 14:
							System.out.println("Enter the roll number to modify the records");
							int modify_rollNo;
							modify_rollNo = sc.nextInt();
							student = sm.get(modify_rollNo);
							
						try{
							if(student == null)
								throw new StudentNotFoundException();
							
							sc.nextLine();
							
							System.out.println("Name");
							name = sc.nextLine();
							
							
							System.out.println("Email ID");
							emailID = sc.nextLine();
							
							System.out.println("PhoneNumber");
							phoneNumber = sc.nextLine();
							
							System.out.println("address");
							address = sc.nextLine();
							
							System.out.println("dob");
							dob = sc.nextLine();
							
							
							
							System.out.println("Standard as integer");
							std = sc.nextInt();
							sc.nextLine();
							
							System.out.println("Division");
							divison = sc.nextLine();
							
							sm.updateStudent(modify_rollNo,name,emailID,phoneNumber,address,dob,std,divison);
							System.out.println("Student Record Updated Successfully");
							}	
							catch(StudentNotFoundException snfe){
								System.out.println(snfe);
							}
							
							
								break;
							case 15:
							System.out.println("To delete a student");
							int delete_rollNo;
							delete_rollNo = sc.nextInt();
							if(sm.deleteStudent(delete_rollNo))
								System.out.println("Student Record is Removed Successfully");
							else
								System.out.println("No Records Exist with this roll number");
							
								break;
								
								
								
							case 21:
							System.out.println("To view All Books ");
							bm.viewAllBooks();							
								break;
								
								
							case 22:
							System.out.println("Search Books BY ISBN");
							int search_isbn;
								System.out.println("Enter the ISBN of the to search");
								search_isbn = sc.nextInt();
								Book book = bm.searchBookByIsbn(search_isbn);
								if(book == null)
									System.out.println("No Book with this ISBN exists in our Library");
								else
									System.out.println(book);
								break;
								
							
							
							case 23:
							System.out.println("Pleas enter All details to Add a book ");
								 int isbn;
								 String title;
								 String author;
								 String publisher;
								 int edition;
								 String subject;
								 int available_quantity;
								 
								 System.out.println("ISBN");
								 isbn = sc.nextInt();
								 
								 sc.nextLine();
								 
								 System.out.println("Title");
								 title = sc.nextLine();
								 
								 System.out.println("Author");
								 author = sc.nextLine();
								 
								 System.out.println("Publisher");
								 publisher = sc.nextLine();
								 
								 sc.nextInt();
								 
								 System.out.println("Edition");
								 edition = sc.nextInt();
								 
								 sc.nextLine();
								 
								  System.out.println("Subject");
								 subject = sc.nextLine();
								 
								 sc.nextInt();
								 
								 
								 System.out.println("Available Quantity");
								 available_quantity = sc.nextInt();
								 
								 
								 book = new Book(isbn,title,author,publisher,edition,subject,available_quantity);
								 bm.addABook(book);
								 System.out.println("Book Added Successfully");
								 
													
								break;
								
								
								
								case 24:
							System.out.println("To Update the Book record By using ISBN ");
							
							int update_isbn;
							update_isbn = sc.nextInt();
							try{
								book = bm.searchBookByIsbn(update_isbn);
								if(book == null)
									throw new BookNotFoundException();
								
								
								
								System.out.println("Enter Book Details to Modify Book Details");
								 
								 
								 sc.nextLine();
								 
								 System.out.println("Title");
								 title = sc.nextLine();
								 
								 System.out.println("Author");
								 author = sc.nextLine();
								 
								 System.out.println("Publisher");
								 publisher = sc.nextLine();
								 
								 sc.nextInt();
								 
								 System.out.println("Edition");
								 edition = sc.nextInt();
								 
								 sc.nextLine();
								 
								  System.out.println("Subject");
								 subject = sc.nextLine();
								 
								 sc.nextInt();
								 
								 
								 System.out.println("Available Quantity");
								 available_quantity = sc.nextInt();
								 
								 
								 
								bm.updateBook(update_isbn,title,author,publisher,edition,subject,available_quantity);
								 
								
								 System.out.println("Book Updated Successfully");
								 
								
								
							}catch(BookNotFoundException bnfe){
								System.out.println(bnfe);
							}
								break;
								
								
								
								
								case 25:
							System.out.println("To delete a book record");
							int delete_isbn;
							delete_isbn = sc.nextInt();
							try{
								book = bm.searchBookByIsbn(delete_isbn);
								if(book == null)
									throw new BookNotFoundException();
								bm.deleteBook(delete_isbn);
								System.out.println("Book Record is deleted successfully");
							}catch(BookNotFoundException bnfe){
								System.out.println(bnfe);
							}
							
								break;
								
								
							case 31:
							System.out.println("To view All transaction of Books");
							btm.showAll();
							
							break;
								
								
							case 99:
							System.out.println("Thank You for using Library");
								break;
							default :
							System.out.println("Invalid Choice");
						}
				}while(lib_choice != 99);
			}
			
		}while(choice != 3);
		sm.writeToFile();
		bm.writeToFile();
		btm.writeToFile();
		sc.close();
	}

}