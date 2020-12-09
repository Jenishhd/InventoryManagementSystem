package Boundary;

import Control.InvoiceController;

import java.util.*;

public class InvoiceMenuBoundary
{
     /**
     * Controls database interaction for warehouses
     */
     private InvoiceController invoiceController;

     /**
     * Constructor that intiializes the warehouseController
     */
     public InvoiceMenuBoundary()
     {
          invoiceController = new InvoiceController();
     }

     /*
      * Method to print all menu choices and act upon the input of the user
      */
     public void printInvoiceMenuChoices()
	{
          Scanner input = new Scanner(System.in);
          String selection = "0";
          while (!selection.equals("6"))
          {
        	  	System.out.println("\nPlease make a selection:");
          		System.out.println("1) Add Invoice\n2) Make payment\n3) Show all invoices\n4) Show closed invoices\n5) Show Open Invoices\n6) Exit");

          		selection = input.nextLine();
          		//Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
          		switch(selection)
          		{
          		//Add customer
          		case "1":
          			//Adds a new invoice to the invoiceMenuChoices database. Takes an existing product, customer and salesperson
          			invoiceController.addInvoice();
          			break;
          			//Show all customers
          		case "2":
          			invoiceController.makePayment();
          			break;
          			//display all invoices
          		case "3":
          			invoiceController.displayInvoices();
          			break;
          			//Display close invoices formatted in totalAmount decreasing
          		case "4":
					invoiceController.displayClosedInvoices();
          			break;
				case "5":
					invoiceController.displayOpenInvoices();
					break;
          			//Exit
          		case "6":
          			break;


          		default:
          			System.out.println("Invalid selection. Please try again.");
          			break;
          		} //End switch
          } //End while loop
	} //End of menu functiomn


} //End of class
