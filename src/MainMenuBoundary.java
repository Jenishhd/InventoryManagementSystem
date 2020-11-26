import java.util.Scanner;

/*
 * Class that allows interaction between the user and the entirety of the database
 */
public class MainMenuBoundary 
{
	Scanner input = new Scanner(System.in);
	
	private String username = "Admin";									//Stored username variable. For now: "Admin"
	private String password = "Admin";									//Stored password variable. For now: "Admin"
	
	ItemMenuBoundary bItem = new ItemMenuBoundary();					//ItemMenuBoundary instance to track all item/product operations
	CustomerMenuBoundary bCustomer = new CustomerMenuBoundary();		//CustomerMenuBoundary instance to track all customer operations
	InvoiceMenuBoundary bInvoice = new InvoiceMenuBoundary();			//InvoiceMenuBoundary instance to track all invoice operations
	WarehouseMenuBoundary bWarehouse = new WarehouseMenuBoundary();		//WarehouseMenuBoundary instance to track all warehouse operations
	
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
			bItem.printItemMenu();
			return true;
		//Customers
		case "2":
			return false;
		//Invoices
		case "3":
			return false;
		//Warehouses
		case "4":
			return false;
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
}
