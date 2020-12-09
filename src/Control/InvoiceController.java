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
          HashMap<String, SalesPerson> salespersons = Database.getInstance().getAllSalesPersons();
          boolean buyMore = true;
          String selection = "0";
          boolean validInvoice = true;

          System.out.print("Enter full name of sales person: ");
          String salesPersonName = input.nextLine();

          salesLoop:
          while (!salespersons.containsKey(salesPersonName))
          {
               System.out.println("**SALESPERSON NOT FOUND**");
               selection = "0";
               while (!selection.equals("y") && !selection.equals("n"))
               {
                    System.out.print("Would you like to search for another sales person (y/n): ");
                    selection =  input.nextLine();
                    if (selection.equals("y"))
                    {
                         System.out.print("Enter full name of sales person: ");
                         salesPersonName = input.nextLine();
                    }
                    else if (selection.equals("n"))
                    {
                         validInvoice = false;
                         buyMore = false;
                         break salesLoop;
                    }
                    else
                    {
                         System.out.println("**INVALID INPUT TRY AGAIN**");
                    }
               }
          }
          if (!salespersons.containsKey(salesPersonName))
          {
               return;
          }
          SalesPerson salesPerson = salespersons.get(salesPersonName);



          System.out.print("Enter full name of customer: ");
          String customerName = input.nextLine();

          customerLoop:
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
                         break customerLoop;
                    }
                    else
                    {
                         System.out.println("**INVALID INPUT TRY AGAIN**");
                    }
               }
          }
          if (!customers.containsKey(customerName))
          {
               return;
          }
          Customer purchaseMaker = customers.get(customerName);

          selection = "0";
          boolean isDelivered = true;
          double deliveryFee = 0;
          String address = "Not Applicable";
          while (!selection.equals("y") && !selection.equals("n"))
          {
               System.out.print("Is this purchase to be delivered?(y/n): ");
               selection =  input.nextLine();
               if (selection.equals("y"))
               {
                    isDelivered = true;
                    System.out.print("Enter the address of the customer: ");
                    address = input.nextLine();
                    System.out.print("Enter delivery fee: $");
                    deliveryFee = Double.parseDouble(input.nextLine());

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
          Invoice newInvoice = new Invoice(purchaseMaker, isDelivered, deliveryFee, address);


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
               //productToAdd.setQuantity(productToAdd.getQuantity() - quantity);
               productToAdd.increaseQuantitySold(quantity);
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
          salesPerson.addCommission(purchaseMaker, newInvoice.getTotalCost() - deliveryFee);



     }
	/*
	 * Displays the information of all invoices in the customerMenuBoundary
	 */
	public void displayInvoices()
    {
		System.out.println("\nInvoices");
		System.out.println("--------");
		System.out.printf("%-40s%-50s%-40s\n", "Debtor Name","Address", "Date Created");
		for(Invoice current: Database.getInstance().getAllInvoices())
        {
             String fullName = current.getDebtor().getFirstName() + " " + current.getDebtor().getLastName();
             System.out.printf("%-40s%-50s%-40s\n", fullName, current.getAddress(),current.getDateCreated().getTime().toString());
        }
		System.out.println("--------\n");
    }


	public void makePayment()
    {
         Scanner input = new Scanner(System.in);
         ArrayList<Invoice> invoices = Database.getInstance().getAllInvoices();
         System.out.print("Enter full name of debtor: ");
         String debtorName = input.nextLine();

         String selection = "0";
         outerLoop:
         for (Invoice current: invoices)
         {
              String fullName = current.getDebtor().getFirstName() + " " + current.getDebtor().getLastName();
              if (fullName.equals(debtorName))
              {
                   current.printInvoice();
                   selection = "0";
                   while (!selection.equals("y") && !selection.equals("n"))
                   {
                        System.out.println("Is this the invoice?(y/n)");
                        selection = input.nextLine();
                        switch (selection)
                        {
                             case "y":
                                  System.out.print("Enter payment amount: ");
                                  double payment = Double.parseDouble(input.nextLine());
                                  current.makePayment(payment);
                                  System.out.printf("Remaining Invoice Balance: $%.2f", current.getRemainingCost());
                                  break outerLoop;

                             case "n":
                                  continue outerLoop;
                             default:
                                  System.out.println("**INVALID INPUT**");
                        }
                   }
              }
         }

    }
    
     //RFP DISPLAY METHOD FOR CLOSED INVOICES SORTED BY TOTAL AMOUNT
     public void displayClosedInvoices()
     {
          List<Invoice> invoices = new ArrayList(Database.getInstance().getAllInvoices());
          Collections.sort(invoices, new UserComparator().reversed());

          System.out.println("\nClosed Invoices");
          System.out.println("--------------------");
          System.out.printf("%-40s%-50s%-40s%-40s\n", "Debtor Name","Address", "Date Created", "Invoice Amount");
          for(Invoice current: invoices)
          {
               if(current.isOpen() == false) {
                    String fullName = current.getDebtor().getFirstName() + " " + current.getDebtor().getLastName();
                    System.out.printf("%-40s%-50s%-40s$%-40.2f\n", fullName, current.getAddress(), current.getDateCreated().getTime().toString(), current.getTotalCost() );
               }
          }
          System.out.println("--------\n");
     }

     public class UserComparator implements Comparator<Invoice> {
          @Override
          public int compare(Invoice i1, Invoice i2) {
               return Double.compare(i1.getTotalCost(),i2.getTotalCost());
          }
     }

     //OPEN INVOICES SORTED BY DATE
     public void displayOpenInvoices()
     {
          List<Invoice> invoices = new ArrayList(Database.getInstance().getAllInvoices());
          Collections.sort(invoices, new oComparator());

          System.out.println("\nOpen Invoices");
          System.out.println("--------------------");
          System.out.printf("%-40s%-50s%-40s%-40s\n", "Debtor Name","Address", "Date Created", "Invoice Amount");
          for(Invoice current: invoices)
          {
               if(current.isOpen() == true) {
                    String fullName = current.getDebtor().getFirstName() + " " + current.getDebtor().getLastName();
                    System.out.printf("%-40s%-50s%-40s$%-40.2f\n", fullName, current.getAddress(), current.getDateCreated().getTime().toString(), current.getTotalCost() );
               }
          }
          System.out.println("--------\n");
     }

     public class oComparator implements Comparator<Invoice> {
          @Override
          public int compare(Invoice i1, Invoice i2) {
               return i1.getDateCreated().compareTo(i2.getDateCreated());
          }
     }


}
