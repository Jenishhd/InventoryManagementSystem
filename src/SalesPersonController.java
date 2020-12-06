import java.util.List;
import java.util.Scanner;

public class SalesPersonController {
	
	/**
	 * Adds salesperson into the database
	 * @param sp
	 */
	public void addSalesPerson(SalesPerson sp)
	{
		Database.getInstance().getAllSalesPersons().put(sp.getFirstName()+ " "+ sp.getLastName(), sp);
	}
	public void removeSalesPerson(SalesPerson sp)
	{
		
	}

}
