package Control;

import DB.*;
import Entity.*;

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

		//Trys for invalid input. If input is not parsable to a Double...
		try 
		{ 
			//Takes product cost price as input
			System.out.print("Cost to produce: ");
			temp.setCostPrice(Double.parseDouble(input.nextLine())); 
			
			//Takes product sell price as input
			System.out.print("Price to sell: ");
			temp.setSellPrice(Double.parseDouble(input.nextLine()));
			}
		///...then
		catch(NumberFormatException e)
		{
			//Print error message and terminate 
			System.out.println("[ERROR] Incorrect input type. AddProduct() aborted");
			return;
		}		
		
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

		//Print the names of all products stored in the database sorted in decreasing profit percentage
		System.out.println("\nProducts");
		System.out.println("--------");
		System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n","Name","Sell Price","Cost Price", "Quantity", "Units Sold", "Total Sales", "Total Cost", "Total Profit", "Total Profit Percent");
		List<Product> products = new ArrayList<>(Database.getInstance().getAllProducts().values());
		Collections.sort(products, new productComparator().reversed());
		for (Product current: products)
		{
			double totalSales = current.getQuantitySold() * current.getSellPrice();
			double totalCost = current.getQuantitySold() * current.getCostPrice();
			double totalProfit = totalSales - totalCost;
			
			System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n", (current.getName()), ("$" + current.getCostPrice()), ("$" + current.getSellPrice()), current.getQuantity(), current.getQuantitySold(), 
					("$" + totalSales), ("$" + totalCost), ("$" + totalProfit), (totalProfit / totalCost) * 100.0);
			System.out.println("--------\n");
		}
	}
	//COMPARES PROFIT PERCENTAGE (LONG CAUSE WE DONT HAVE PROFIT PERCENTAGE VARIABLE IN PRODUCT)
	public class productComparator implements Comparator<Product> {
		@Override
		public int compare(Product p1, Product p2) {
			return Double.compare( (100*(p1.getQuantitySold()*p1.getSellPrice())/(p1.getQuantitySold() * p1.getCostPrice())),
									(100*(p2.getQuantitySold()*p2.getSellPrice())/(p2.getQuantitySold() * p2.getCostPrice())));
		}
	}

	public void updateQuantity(String productName, int newQuantity)
	{
		if (Database.getInstance().getAllProducts().containsKey(productName))
		{
			Database.getInstance().getAllProducts().get(productName).setQuantity(newQuantity);
		}
	}

	public Product getProduct(String productName)
	{
		if (Database.getInstance().getAllProducts().containsKey(productName))
		{
			return Database.getInstance().getAllProducts().get(productName);
		}
		return null;
	}
}
