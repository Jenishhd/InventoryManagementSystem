package Boundary;
import Control.SalesPersonController;
import java.util.*;

public class SalesPersonMenuBoundary {
	
	private CreateSalesPersonBoundary csp;
	private RemoveSalesPersonBoundary rsp;
	private SalesPersonController spc;
	public SalesPersonMenuBoundary() {
		csp = new CreateSalesPersonBoundary();
		spc = new SalesPersonController();
	}
	public void printSalesPersonMenu()
	{
		Scanner scan = new Scanner(System.in);
		String selection = "0";
		
		while(!selection.equals("4"))
		{
			System.out.println("\nPlease make a selection:");
	 		System.out.println("1) Add SalesPerson\n2) Remove SalesPerson\n3) Show all Salesmen\n4) Exit");
	        selection = scan.nextLine();
			switch(selection) {
			case "1":
				csp.createSalesPerson();
				break;
			case "2":
				rsp.removeSalesPerson();
				break;
			case "3":
				spc.displaySalesPerson();
				break;
			case "4":
				break;
			}
		}
		scan.close();
	}
}
