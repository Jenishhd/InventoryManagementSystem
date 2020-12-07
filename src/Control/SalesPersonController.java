package Control;
import DB.Database;
import Entity.Customer;
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
	 * 
	 */
	public void removeSalesPerson(SalesPerson sp) {
		if(Database.getInstance().getAllSalesPersons().containsKey(sp.getFirstName()+" "+sp.getLastName())) {
			Database.getInstance().getAllSalesPersons().remove(sp.getFirstName()+" "+sp.getLastName());
		}
	}
	/**
	 * Displays all SalesPersons in the database
	 */
	public void displaySalesPerson() {
		System.out.printf("%-22s%-22s%-22s\n","First Name","Last Name","Commission Percentage");
		for(String name: Database.getInstance().getAllSalesPersons().keySet())
          {
               SalesPerson current = Database.getInstance().getAllSalesPersons().get(name);
			System.out.printf("%-22s%-22s%-22s\n",current.getFirstName(),current.getLastName(),String.valueOf(current.getCommissionPercentage()));
		}
	}
}
