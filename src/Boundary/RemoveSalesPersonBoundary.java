package Boundary;
import Control.SalesPersonController;
import java.util.*;

public class RemoveSalesPersonBoundary {
	private SalesPersonController spController;
	
	public void removeSalesPerson()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter First Name of SalesPerson: ");
		String spFirstName = scan.nextLine();
		
		System.out.println("Enter Last Name of SalesPerson: ");
		String spLastName = scan.nextLine();
		
		spController.removeSalesPerson(spFirstName+ " "+ spLastName);
		scan.close();
	}
}
