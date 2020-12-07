package Boundary;

import Control.*;
import Entity.*;
import java.util.Scanner;
import java.lang.Character;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateSalesPersonBoundary {
	
	private SalesPersonController spController;
	/**
	 * Method which creates a SalesPerson defined by user.
	 * User will add the SalesPerson's first name, last name, and commission percentage here.
	 */
	public void createSalesPerson()
	{
		boolean isNum=false;
		Scanner scan = new Scanner(System.in);
		InvoiceController IController = new InvoiceController();
		System.out.println("Enter First Name of SalesPerson: ");
		String spFirstName = scan.nextLine();
		
		System.out.println("Enter Last Name of SalesPerson: ");
		String spLastName = scan.nextLine();
		
		System.out.println("Enter SalesPerson's commission percentage\nPlease use numbers and decimals.\nDo not add % sign");
		String percentage = scan.nextLine();
		while(!isNum) {
			//pattern and Matcher used here to detect special symbol inputs that are invalid
			Pattern patt = Pattern.compile("[^a-zA-Z]", Pattern.CASE_INSENSITIVE);
			Matcher mat = patt.matcher(percentage);
			boolean check = mat.find();
			if(percentage!=null)
			{
				 for (int i = 0; i < percentage.length(); i++) {
			         // checks whether the character is not a letter
			         // if it is not a letter ,it will return false
			         if ((Character.isLetter(percentage.charAt(i)) == true)) {
			        	 System.out.println("Invalid Input(letter), please try again.");
			        	 percentage = scan.nextLine();
			        	 continue;
			         }
			         
			     }
				 if(check) {
					 System.out.println("Invalid Input(special Symbol), please try again.");
					 percentage = scan.nextLine();
					 continue;
				 }
				 isNum=true;
			}
			
			
		}
		SalesPerson sp = new SalesPerson(spFirstName,spLastName,Integer.parseInt(percentage));
		spController.addSalesPerson(sp);
		System.out.println("The customer " + spFirstName + " " + spLastName + " was added to the database.");
		
		
	}

}
