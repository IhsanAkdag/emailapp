package emailapp;

import java.util.Scanner;

public class Email {

private String firsName;
private	String lastName;
private	String password;
private	String departmen;
private	String email;
private	int mailBoxCapacity=500;
private	int defaultPasswordLength=10;
private	String alternateEmail;
private	String companySuffix = "eaycompany.com";

	
		// constructor to receive the firs name and last name
	public Email(String firstName, String lastName) {
		this.firsName=firstName;
		this.lastName=lastName;
		
		//Call sa method asking for the department - return the department
		this.departmen=setDepartment();
		System.out.println("department: "+this.departmen);
		
		//Call the method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password: "+this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+departmen+"."+companySuffix;
		
		
	}

    // ask for the department
	private String setDepartment() {
		System.out.print("New Worker "+firsName+"."+" Department Codes: \n1 for Sales\n2 for Development \n3 for Accointing\n0 for none\nEnter department code: ");
		
		try (Scanner in = new Scanner(System.in)) { //try is for scanner closed error
			int depChoise=in.nextInt();
			if(depChoise==1) {return "sales";}
			else if(depChoise==2 ) {return "dev";}
			else if(depChoise==3 ) {return "acct";}
			else {return "";}
		}  
		
	}
	
    // generate a random password
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPRSTUWXYZ123456789!@#$%";
		char[] password = new char[length];
		for(int i=0 ; i<length ; i++) {
			int rand= (int) (Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
    // set the mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity=capacity;		
	}
		
    // set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail=altEmail;
	}
	
	
    // change the password
	public void changePassword(String password) {
		this.password=password;
	}
	
	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return ("=========================\nDISPLAY NAME: "+firsName+" "+lastName+
				"\nCOMPANY EMAIL: " +email+
				"\nMAILBOX CAPACITY: " +mailBoxCapacity+" mb");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
