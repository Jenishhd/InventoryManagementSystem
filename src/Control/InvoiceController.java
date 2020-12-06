package Control;

import DB.Database;
import Entity.Customer;
import Entity.Invoice;
import Entity.Product;
import Entity.SalesPerson;
import Entity.Warehouse;

import java.util.*;

public class InvoiceController
{
     /*
	 * Adds a new customer to the Boundary.CustomerMenuBoundary database
	 */
	public void addInvoice()
     {
          Scanner input = new Scanner(System.in);



          HashMap<String, Product> products = Database.getInstance().getAllProducts();
          HashMap<String, Customer> customers = Database.getInstance().getAllCustomers();
          HashMap<String, Warehouse> warehouses = Database.getInstance().getAllWarehouses();
          boolean buyMore = true;
          String selection = "0";
          boolean validInvoice = true;

          System.out.print("Enter full name of customer: ");
          String customerName = input.nextLine();
          while (!customers.containsKey(customerName))
          {
               System.out.println("**CUSTOMER NOT FOUND**");
               selection = "0";
               while (!selection.equals("y") && !selection.equals("n"))
               {
                    System.out.print("Would you like to search for another customer (y/n): ");
                    selection =  input.nextLine();
                    if (selection.equals("y"))
                    {
                         System.out.print("Enter full name of customer: ");
                         customerName = input.nextLine();
                    }
                    else if (selection.equals("n"))
                    {
                         validInvoice = false;
                         buyMore = false;
                    }
                    else
                    {
                         System.out.println("**INVALID INPUT TRY AGAIN**");
                    }
               }
          }
          Customer purchaseMaker = customers.get(customerName);

          selection = "0";
          boolean isDelivered = true;
          while (!selection.equals("y") && !selection.equals("n"))
          {
               System.out.print("Is this purchase to be delivered?(y/n): ");
               selection =  input.nextLine();
               if (selection.equals("y"))
               {
                    isDelivered = true;
               }
               else if (selection.equals("n"))
               {
                    isDelivered = false;
               }
               else
               {
                    System.out.println("**INVALID INPUT TRY AGAIN**");
               }
          }
          Invoice newInvoice = new Invoice(purchaseMaker, isDelivered);


          outerLoop:
          while (buyMore)
          {


               //Search for product
               System.out.print("Enter product in purchase: ");
               String productName = input.nextLine();
               while (!products.containsKey(productName))
               {
                    System.out.println("**PRODUCT NOT FOUND**");
                    selection = "0";
                    while (!selection.equals("y") && !selection.equals("n"))
                    {
                         System.out.print("Would you like to search for another item (y/n): ");
                         selection =  input.nextLine();
                         if (selection.equals("y"))
                         {
                              System.out.print("Enter product in purchase: ");
                              productName = input.nextLine();
                         }
                         else if (selection.equals("n"))
                         {
                              validInvoice = false;
                              break outerLoop;
                         }
                         else
                         {
                              System.out.println("**INVALID INPUT TRY AGAIN**");
                         }
                    }
               }
               Product productToAdd = products.get(productName);

               //Select quantity for invoice
               System.out.print("How many would you like to add to invoice: ");
               int quantity = Integer.parseInt(input.nextLine());
               while (quantity > products.get(productName).getQuantity())
               {
                    System.out.println("**SELECTED QUANTITY EXCEEDS QUANTITY AVAILABLE**");
                    selection = "0";
                    while (!selection.equals("y") && !selection.equals("n"))
                    {
                         System.out.print("Would you like to enter a new quantity (y/n): ");
                         selection =  input.nextLine();
                         if (selection.equals("y"))
                         {
                              System.out.print("How many would you like to add to invoice: ");
                              quantity = Integer.parseInt(input.nextLine());
                         }
                         else if (selection.equals("n"))
                         {
                              validInvoice = false;
                              break outerLoop;
                         }
                         else
                         {
                              System.out.println("**INVALID INPUT TRY AGAIN**");
                         }
                    }
               }

               if (!validInvoice)
               {
                    return;
               }
               newInvoice.addProduct(productToAdd, quantity);
               int quantityToRemove = quantity;
               productToAdd.setQuantity(productToAdd.getQuantity() - quantity);
               for (String warehouseName: Database.getInstance().getAllWarehouses().keySet())
               {

                    if (quantityToRemove > warehouses.get(warehouseName).getQuantity(productToAdd.getName()))
                    {
                         quantityToRemove -= warehouses.get(warehouseName).getQuantity(productToAdd.getName());
                         warehouses.get(warehouseName).updateQuantity(productToAdd.getName(), 0);
                    }
                    else
                    {
                         warehouses.get(warehouseName).changeQuantityByAmount(productToAdd.getName(), -1 * quantityToRemove);
                    }
               }

               selection = "0";
               while (!selection.equals("y") && !selection.equals("n"))
               {
                    System.out.print("Would you like to add another product to this invoice? (y/n): ");
                    selection =  input.nextLine();
                    if (selection.equals("y"))
                    {
                         continue outerLoop;
                    }
                    else if (selection.equals("n"))
                    {
                         buyMore  = false;
                    }
                    else
                    {
                         System.out.println("**INVALID INPUT TRY AGAIN**");
                    }
               }
          }
          System.out.println("");
          newInvoice.printInvoice();
          Database.getInstance().getAllInvoices().add(newInvoice);



     }
	/*
	 * Displays the information of all invoices in the customerMenuBoundary
	 */
	public void displayInvoices() {};
	/*
	 * Adds a new salesperson to the customerMenuBoundary database
	 */
	public void addSalesPerson(SalesPerson sp) {
		Database.getInstance().getAllSalesPersons().put(sp.getFirstName()+ " "+sp.getLastName(),sp);
	};
	/*
	 * Removes an existing salesperson from the customerMenuBoundary database
	 */
	public void removeSalesPerson() {};
	/*
	 * displays the information of all salespeople in the customerMenuBoundary database
	 */
	public void displaySalesPeople() {};
}
