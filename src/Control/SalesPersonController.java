package Control;
import DB.Database;
import Entity.SalesPerson;


public class SalesPersonController {
	
	/**
	 * Adds a new SalesPerson into the salesperson map in the database
	 * @param sp SalesPerson being added
	 */
	public void addSalesPerson(SalesPerson sp)
	{
		Database.getInstance().getAllSalesPersons().put(sp.getFirstName()+" "+sp.getLastName(), sp);
	}
	/**
	 * Removes a SalesPerson from the salesPerson map in the database
	 */
	public void removeSalesPerson(String sp) {
		if(Database.getInstance().getAllSalesPersons().containsKey(sp)) {
			Database.getInstance().getAllSalesPersons().remove(sp);
		}
		else {
			System.out.println("SalesPerson does not exist in the database.");
		}
	}
	public SalesPerson getSalesPerson(String sp) {
		if(Database.getInstance().getAllSalesPersons().containsKey(sp)) {
			return Database.getInstance().getAllSalesPersons().get(sp);
		}
		else {
			System.out.println("SalesPerson does not exist in the database.");
			return null;
		}
	}
	/**
	 * Displays all SalesPersons in the database
	 */
	public void displaySalesPerson() {
		System.out.println("\nSalespeople");
		System.out.println("-----------");
		System.out.printf("%-22s%-22s%-22s\n","First Name","Last Name","Commission Percentage");
		for(String name: Database.getInstance().getAllSalesPersons().keySet())
          {
               SalesPerson current = Database.getInstance().getAllSalesPersons().get(name);
			System.out.printf("%-22s%-22s%-22s\n",current.getFirstName(),current.getLastName(),String.valueOf(current.getCommissionPercentage()));
		}
		System.out.println("-----------");
	}
}
