package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int mailboxcapacity = 500;
	private String alternateEmail;
	private int defaultpasswordlength = 10;
	private String companySuffix = "xyzcompany.com"; 
	
	// Constructor to get the first and last name
	public Email(String firstName, String lastName) {
		
		this.firstName= firstName;
		this.lastName= lastName;
     	System.out.println("Email Created:" + this.firstName + " " + this.lastName);
	
	//Ask the departmentName
    // calling method to return the department 	
	this.department = setDepartment();
	System.out.println("Department: " + this.department);
	
	// calling method to return the password
	this.password = randomPassword(defaultpasswordlength);
	System.out.println("Your password is: "+ this.password);
	
	//combining all to generate unique emailID
	
	email = firstName.toLowerCase() + "." +  lastName.toLowerCase() + "@" + department + "." + companySuffix;
	System.out.println("Your assigned Email ID is " +email);
	
	}
	private String setDepartment() {
		System.out.println("New Worker:" + lastName + "\nDepartment Codes\n1 for Sales \n2 for Development \n3 for Accounting \n0 for none\n Enter your Code Please:");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {return "Sales";}
		else if(depChoice == 2) {return "dev";}
		else if(depChoice == 3) {return "acct";}
		else {return "";}
	}
	
	//Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
		char[] password = new char[length];
		for(int i = 0; i<length; i++) {
			int rand = (int) Math.random() * passwordSet.length();
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set mailbox Capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxcapacity = capacity;
		
	}
	//Set an alternative EMAIL
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailboxCapacity() { return mailboxcapacity; } 
	public String getAlternateEmail() { return alternateEmail;}
	public String getpassword() { return password; }
	
	public String showInfo( ) {
		
		return "Display Name: " +firstName + " " + lastName + 
				"\nCompany Email:" +email+
				"\nMailbox Capacity:" + mailboxcapacity + "mb";
				
	}
}
