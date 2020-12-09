package Control;
import DB.*;
import Entity.*;


public class CustomerController
{
     /*
	 * Adds a new customer to the customer map in database
	 */
     public void addCustomer(Customer c)
     {
		Database.getInstance().getAllCustomers().put(c.getFirstName() + " " + c.getLastName(), c);
	}

	/*
	 * Removes an existing customer from the Boundary.CustomerMenuBoundary database. Checks if the customer exists
	 */
	public void removeCustomer()
     {
		//rcb.removeCustomer(customers);
	}
	/*
	 * Displays all current customers in the Boundary.CustomerMenuBoundary database
	 */
	public void displayCustomers()
     {
		System.out.println("\nCustomers");
		System.out.println("---------");
		System.out.printf("%-22s%-22s%-22s\n","First Name","Last Name","SalesTax");
		for(String name: Database.getInstance().getAllCustomers().keySet())
          {
               Customer current = Database.getInstance().getAllCustomers().get(name);
               System.out.printf("%-22s%-22s%%%-22.2f\n",current.getFirstName(),current.getLastName(), current.getSalesTaxRate() * 100);
		}
		System.out.println("---------");
	}
}
