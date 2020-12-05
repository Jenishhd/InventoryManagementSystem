import java.util.*;
public class ProductController
{

     /*
	 * Adds a new item to the itemMenuBoundary database, consisting of an item name, cost price and sale price
	 */
	public void addProduct()
	{
          Scanner input = new Scanner(System.in);
		//Creates temporary product value
		Product temp = new Product();

		//Takes product name as input
		System.out.print("Product Name: ");
		temp.setName(input.nextLine());

		//Takes product cost price as input
		System.out.print("Cost to produce: ");
		temp.setCostPrice(Double.parseDouble(input.nextLine()));

		//Takes product sale price as input
		System.out.print("Price to sell: ");
		temp.setSellPrice(Double.parseDouble(input.nextLine()));

		//Adds the completed item to the database
		Database.getInstance().getAllProducts().put(temp.getName(), temp);

		//Adds product to all warehouses
		WarehouseController wc = new WarehouseController();
		wc.addWarehouseProduct(temp);

		System.out.println(temp.getName() + " successfully added!");

	}

	/*
	 * Removes and item from the itemMenuBoundary database. Checks to make sure the item is not contained in any warehouses
	 */
	public void removeProduct() {};

	/*
	 * Displays all current items in the itemMenuBoundary database.
	 */
	public void displayProducts()
	{
		//If there are no available items to display, print error message and return
		if (Database.getInstance().getAllProducts().size() == 0)
		{
			System.out.println("There are currently no registered items. Please try again.");
			return;
		}

          int i = 0;
		//Print the names of all products stored in the database
		System.out.println("Products: ");
		for (String key: Database.getInstance().getAllProducts().keySet())
		{
			System.out.println((i + 1) + ") " + key);
               ++i;
		}
	}
}
