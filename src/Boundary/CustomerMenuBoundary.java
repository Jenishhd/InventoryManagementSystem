package Boundary;

import Boundary.CreateCustomerBoundary;
import Control.CustomerController;

import java.util.*;

/**
* Boundary objects that facilitates interaction between user and program functionality
* pertaining to customers
*/
public class CustomerMenuBoundary
{
     /**
     * Controller that manages interactions between database and user entered data
     */
     private CustomerController customerController;

     /**
     * Boundary that allows the user to add a customer
     */
     private CreateCustomerBoundary ccb;

     /**
     * Boundary that allows the user to remove a customer
     */
     private RemoveCustomerBoundary rcb;

     /**
     * Default constructor that creates a controller for manipulating customer data
     * in the database
     */
     public CustomerMenuBoundary()
     {
          customerController = new CustomerController();
          ccb = new CreateCustomerBoundary();
          rcb = new RemoveCustomerBoundary();
     }

     /*
	 * Method to print all menu choices and act upon the input of the user
	 */
	public void printCustomerMenuChoices()
	{
          Scanner input = new Scanner(System.in);
          String selection =  "0";
          while (!selection.equals("4"))
          {
               System.out.println("\nPlease make a selection:");
     		System.out.println("1) Add Customer\n2) Remove Customer\n3) Show all customers\n4) Exit");
               selection = input.nextLine();

     		//Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
     		switch(selection)
     		{
          		//Add customer
          		case "1":
          			///Adds a new customer to the customerMenuBoundary database
          			ccb.createCustomer();
          			break;
          		//Remove customer
          		case "2":
          			///Removes an existing customer entirely. User gets to choose from existing customers in the customerMenuBoundary database
          			rcb.removeCustomer();
          			break;
          		//Show all customers
          		case "3":
          			///Displays the information of all customers in the CustomerMenuChoices database
          			customerController.displayCustomers();
          			break;
          		//Exit
          		case "4":
          			break;
          		default:
          			System.out.println("Invalid selection. Please try again.");
          			break;
     		}

          }

	}
}
