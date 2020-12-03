import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Class that allows interaction between the user and the entirety of the database
 */
public class MainMenuBoundary 
{
	// Main Menu Boundary
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	Scanner input = new Scanner(System.in);
	
	private String username = "Admin";									//Stored username variable. For now: "Admin"
	private String password = "Admin";									//Stored password variable. For now: "Admin"
	
	
	/*
	 * Method to print the main selection menu
	 */
	public void printMainMenu()
	{
		System.out.println("Welcome to the databse! Please log in to continue");
		//Repeats the login process if a valid login attempt is not made
		while (getLogin()) {};
		while (printMenuChoices()) {}
	}
	
	/*
	 * Method to print all menu choices and act upon the input of the user
	 */
	public boolean printMenuChoices()
	{
		System.out.println("\nPlease make a selection:");
		System.out.println("1) Items and Products\n2) Customers\n3) Invoices\n4) Warehouses\n5) Exit");
		
		//Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
		switch(input.nextLine())
		{
		//Items and Products
		case "1":
			printItemMenu();
			return true;
		//Customers
		case "2":
			printCustomerMenu();
			return true;
		//Invoices
		case "3":
			printInvoiceMenu();
			return true;
		//Warehouses
		case "4":
			return true;
		//Exit
		case "5":
			return false;
		default:
			System.out.println("Selection invalid. Please try again.");
			return true;
		}
	}
	
	/*
	 * Method to perform a login attempt
	 */
	public boolean getLogin()
	{
		//Takes input for the attempted username
		System.out.print("Username: ");
		String tempUsername = input.nextLine();
		
		//Takes input for the attempted password
		System.out.print("Password: ");
		String tempPassword = input.nextLine();
		
		//Checks if both the username and password match those stored in the database
		if (!(tempUsername.equals(username) && tempPassword.equals(password)))
		{
			System.out.println("\nUsername or password incorrect. Please try again.");
			return true;
		}
		return false;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// ItemMenuBoundary
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Product> items = new ArrayList<Product>();	
	
	public void printItemMenu()
	{
		///Repeats if printMenuChoices() returns a false value
		while(printItemMenuChoices()) {};
	}
	
	/*
	 * Method to print all menu choices and act upon the input of the user
	 */
	private boolean printItemMenuChoices()
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
			removeItem();
			return true;
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
	private void removeItem() {};
	
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
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Customer Menu Boundary
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Customer> customers = new ArrayList<Customer>();	
	
	public void printCustomerMenu()
	{
		while (printCustomerMenuChoices()) {};
	}
	
	/*
	 * Method to print all menu choices and act upon the input of the user
	 */
	private boolean printCustomerMenuChoices()
	{
		System.out.println("\nPlease make a selection:");
		System.out.println("1) Add Customer\n2) Remove Customer\n3) Show all customers\n4) Exit");
		//Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
		switch(input.nextLine())
		{
		//Add customer
		case "1":
			addCustomer();
			return true;
		//Remove customer
		case "2":
			removeCustomer();
			return true;
		//Show all customers
		case "3":
			displayCustomers();
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
	 * Adds a new customer to the CustomerMenuBoundary database
	 */
	private void addCustomer() {};
	/*
	 * Removes an existing customer from the CustomerMenuBoundary database. Checks if the customer exists
	 */
	private void removeCustomer() {};
	/*
	 * Displays all current customers in the CustomerMenuBoundary database
	 */
	private void displayCustomers() {};
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Invoice Menu Boundary
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Invoice> invoices = new ArrayList<Invoice>();	
	
	public void printInvoiceMenu()
	{
		while (printInvoiceMenuChoices()) {};
	}
	
	/*
	 * Method to print all menu choices and act upon the input of the user
	 */
	private boolean printInvoiceMenuChoices()
	{
		System.out.println("\nPlease make a selection:");
		System.out.println("1) Add Invoice\n2) Show all invoices\n3) Exit");
		//Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
		switch(input.nextLine())
		{
		//Add customer
		case "1":
			addInvoice();
			return true;
		//Show all customers
		case "2":
			displayInvoices();
			return true;
		//Exit
		case "3":
			return false;
		default:
			System.out.println("Invalid selection. Please try again.");
			return true;
		}
	}
	
	/*
	 * Adds a new customer to the CustomerMenuBoundary database
	 */
	private void addInvoice() {};
	/*
	 * Removes an existing customer from the CustomerMenuBoundary database. Checks if the customer exists
	 */
	private void displayInvoices() {};
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
