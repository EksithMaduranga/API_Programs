package payment;

import java.util.Scanner;

public class PaymentImpl implements IPayment {
	String Payment_ID="";
	String Patient_ID="";
	String Contact_No="";
	String Address="";
	String Email="";
	String Amount="";
	@Override
	public String payment() {
		System.out.println("___________Welcome to Payment management Sytetm For Hospital____________");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Payment ID: ");
		Payment_ID = sc.nextLine();
		
		System.out.println("Enter Patient ID: ");
		Patient_ID = sc.nextLine();
		
		System.out.println("Enter Your Contact Number: ");
		Contact_No = sc.nextLine();
		
		System.out.println("Enter Your Address: ");
		Address = sc.nextLine();
		
		System.out.println("Enter Your Email: ");
		Email = sc.nextLine();
		
		System.out.println("Enter The Amount: ");
		Amount = sc.nextLine();
		
		System.out.println("********   Your Registration have been Succesfully Completed   ********");
		
		System.out.println("Name: "+"      "+ Payment_ID );
		System.out.println("ID: "+"      "+ Patient_ID);
		System.out.println("Contact Number: "+"      "+ Contact_No);
		System.out.println("Address : "+"      "+ Address );
		System.out.println("Email : "+"      "+ Email );
		System.out.println("Spcl : "+"      "+ Amount );
		System.out.println("==================================");
		
		System.out.println("***********************************");
		
		return "Resigter Publisher Started & Thank You";
	}
	@Override
	public String detailsPayment() {
if(!Payment_ID.equals("") && !Patient_ID.equals("") && !Contact_No.equals("") && !Address.equals("") && !Email.equals("") && !Amount.equals("")) {
			
			return "1";
		} 
		else {
			return "0";
		}
		
	}
	
}
