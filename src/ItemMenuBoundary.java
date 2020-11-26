import java.util.*;
/*
 * Class for allowing interaction between the user and the Item database
 */
public class ItemMenuBoundary 
{
	Scanner input = new Scanner(System.in);								//Scanner variable for inputs
	public List<Product> items = new ArrayList<Product>();				//List for containing existing items/products in the database
	
	/*
	 * Method to print the main item selection menu
	 */
	public void printItemMenu()
	{
		///Repeats if printMenuChoices() returns a false value
		while(printMenuChoices()) {};
	}
	
	/*
	 * Method to print all menu choices and act upon the input of the user
	 */
	private boolean printMenuChoices()
	{
		System.out.println("\nPlease make a selection:");
		System.out.println("1) Add Item\n2) Remove Item\n3) Show all items\n4) Exit");
		//Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
		switch(input.nextLine())
		{
		//Add item
		case "1":
			addItem();
			return true;
		//Remove item
		case "2":
			return false;
		//Show all items
		case "3":
			displayItems();
			return true;
		//Exit
		case "4":
			return false;
		default:
			System.out.println("Invalid selection. Please try again.");
			return true;
		}
	}
	
	/*
	 * Adds a new item to the itemMenuBoundary database, consisting of an item name, cost price and sale price
	 */
	private void addItem()
	{
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
		items.add(temp);
		System.out.println(temp.getName() + " successfully added!");
	}
	
	/*
	 * Removes and item from the itemMenuBoundary database. Checks to make sure the item is not contained in any warehouses
	 */
	private void removeItem() 
	{
		
	}
	
	/*
	 * Displays all current items in the itemMenuBoundary database. 
	 */
	private void displayItems()
	{
		//If there are no available items to display, print error message and return
		if (items.size() == 0) 
		{
			System.out.println("There are currently no registered items. Please try again.");
			return;
		}
		
		//Print the names of all products stored in the database
		System.out.println("Products: ");
		for (int i = 0; i < items.size(); i++)
		{
			System.out.println((i + 1) + ") " + items.get(i).getName());
		}
	}
}
