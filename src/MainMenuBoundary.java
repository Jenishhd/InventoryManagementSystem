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

	private String username;								//Stored username variable. For now: "Admin"
	private String password;								//Stored password variable. For now: "Admin"

	ProductMenuBoundary productBoundary;

	public MainMenuBoundary()
	{
		username = "Admin";
		password = "Admin";
		productBoundary = new ProductMenuBoundary();
	}
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
			productBoundary.printItemMenuChoices();
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
			printWarehouseMenu();
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
	// public List<Product> items = new ArrayList<Product>();
	//
	// public void printItemMenu()
	// {
	// 	///Repeats if printMenuChoices() returns a false value
	// 	while(printItemMenuChoices()) {};
	// }




	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Customer Menu Boundary
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Customer> customers = new ArrayList<Customer>();
	CreateCustomerBoundary ccb = new CreateCustomerBoundary();
	RemoveCustomerBoundary rcb = new RemoveCustomerBoundary();

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
			///Adds a new customer to the customerMenuBoundary database
			addCustomer();
			return true;
		//Remove customer
		case "2":
			///Removes an existing customer entirely. User gets to choose from existing customers in the customerMenuBoundary database
			removeCustomer();
			return true;
		//Show all customers
		case "3":
			///Displays the information of all customers in the CustomerMenuChoices database
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
	public void addCustomer() {
		ccb.createCustomer(customers);
	};
	/*
	 * Removes an existing customer from the CustomerMenuBoundary database. Checks if the customer exists
	 */
	public void removeCustomer() {
		rcb.removeCustomer(customers);
	};
	/*
	 * Displays all current customers in the CustomerMenuBoundary database
	 */
	public void displayCustomers() {
		System.out.printf("%-22s%-22s%-22s\n","First Name","Last Name","SalesTax");
		for(int i = 0; i < customers.size(); i++) {
			System.out.printf("%-22s%-22s%-22s\n",customers.get(i).getFirstName(),customers.get(i).getLastName(),String.valueOf(customers.get(i).getSalesTaxRate()));
		}
	};
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Invoice Menu Boundary
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Invoice> invoices = new ArrayList<Invoice>();
	public List<SalesPerson> salesPeople = new ArrayList<SalesPerson>();

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
		System.out.println("1) Add Invoice\n2) Show all invoices\n3) Add new salesperson\n4) Remove salesperson\n5) Show salespeople\n6) Exit");
		//Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
		switch(input.nextLine())
		{
		//Add customer
		case "1":
			//Adds a new invoice to the invoiceMenuChoices database. Takes an existing product, customer and salesperson
			addInvoice();
			return true;
		//Show all customers
		case "2":
			displayInvoices();
			return true;
		//Add new Salesperson
		case "3":
			addSalesPerson();
			return true;
		//Remove existing Salesperson
		case "4":
			removeSalesPerson();
			return true;
		//Displays all salespeople
		case "5":
			displaySalesPeople();
			return true;
		//Exit
		case "6":
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
	 * Displays the information of all invoices in the customerMenuBoundary
	 */
	private void displayInvoices() {};
	/*
	 * Adds a new salesperson to the customerMenuBoundary database
	 */
	private void addSalesPerson() {};
	/*
	 * Removes an existing salesperson from the customerMenuBoundary database
	 */
	private void removeSalesPerson() {};
	/*
	 * displays the information of all salespeople in the customerMenuBoundary database
	 */
	private void displaySalesPeople() {};
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Customer Menu Boundary
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public List<Warehouse> warehouses = new ArrayList<Warehouse>();

		public void printWarehouseMenu()
		{
			while (printWarehouseMenuChoices()) {};
		}

		/*
		 * Method to print all menu choices and act upon the input of the user
		 */
		private boolean printWarehouseMenuChoices()
		{
			System.out.println("\nPlease make a selection:");
			System.out.println("1) Add Warehouse\n2) Remove Warehouse\n3) Show all warehouses\n4) Add new item to warehouse\n5) Remove item from warehouse\n6) Supply item in warehouse\n7) Remove item supply in warehouse\n8) Exit");
			//Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
			switch(input.nextLine())
			{
			//Add customer
			case "1":
				addWarehouse();
				return true;
			//Remove customer
			case "2":
				removeWarehouse();
				return true;
			//Show all customers
			case "3":
				displayWarehouses();
				return true;
			//Adds a new item to the warehouse. Item must already exist in ItemMenuBoundary
			case "4":
				///Asks user to select an item in the itemMenuBoundary to add, and the quantity
				addWarehouseItem();
				return true;
			//Removes item entirely from warehouse. Item must already be contained in warehouse
			case "5":
				///Asks user to select an item in the warehouse to remove
				removeWarehouseItem();
				return true;
			//Adds a certain amount to an item in the warehouse. Item must exist in the warehouse already
			case "6":
				///Asks user for number to add
				changeWarehouseItemQuantity(/*positive int*/);
				return true;
			//Removes a certain amount of an item form the warehouse. Item must exist in the warehouse already, and resulting item quantity cannot be <0
			case "7":
				///Asks user for number to remove
				changeWarehouseItemQuantity(/*negative int*/);
				return true;
			//Exit
			case "8":
				return false;
			default:
				System.out.println("Invalid selection. Please try again.");
				return true;
			}
		}

		/*
		 * Adds a new customer to the CustomerMenuBoundary database
		 */
		private void addWarehouse() {};
		/*
		 * Removes an existing customer from the CustomerMenuBoundary database. Checks if the customer exists
		 */
		private void removeWarehouse() {};
		/*
		 * Displays all current customers in the CustomerMenuBoundary database
		 */
		private void displayWarehouses() {};
		private void addWarehouseItem() {};
		private void removeWarehouseItem() {};
		private void changeWarehouseItemQuantity(/* int i*/) {};
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
