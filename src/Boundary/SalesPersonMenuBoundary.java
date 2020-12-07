package Boundary;
import Control.SalesPersonController;
import java.util.*;

public class SalesPersonMenuBoundary {
	
	private SalesPersonBoundary spb;
	private SalesPersonController spc;
	public SalesPersonMenuBoundary() {
		spb = new SalesPersonBoundary();
		spc = new SalesPersonController();
	}
	public void printSalesPersonMenuChoices()
	{
		Scanner scan = new Scanner(System.in);
		String selection = "0";
		
		while(!selection.equals("5"))
		{
			System.out.println("\nPlease make a selection:");
	 		System.out.println("1) Add SalesPerson\n2) Remove SalesPerson\n3) Show all Salesmen\n4) Pay SalesPerson\n5) Exit");
	        selection = scan.nextLine();
			switch(selection) {
			case "1":
				spb.createSalesPerson();
				break;
			case "2":
				spb.removeSalesPerson();
				break;
			case "3":
				spc.displaySalesPerson();
				break;
			case "4":
				spb.paySalesPerson();
				break;
			case "5":
				break;
			default:
				System.out.println("Invalid Input. Please Try Again.");
				break;
			}
			
		}
		scan.close();
	}
}
