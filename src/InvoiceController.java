import java.util.*;

public class InvoiceController
{
     /*
	 * Adds a new customer to the CustomerMenuBoundary database
	 */
	public void addInvoice()
     {
          Scanner input = new Scanner(System.in);

          Invoice newInvoice = new Invoice();

          HashMap<String, Product> products = Database.getInstance().getAllProducts();
          HashMap<String, Customer> customers = Database.getInstance().getAllCustomers();
          boolean buyMore = true;
          String selection = "0";
          boolean validInvoice = true;

          outerLoop:
          while (buyMore)
          {
               System.out.print("Enter full name of customer: ");
               String customerName = input.nextLine();
               if (!customers.containsKey(customerName))
               {
                    System.out.println("**CUSTOMER NOT FOUND**");
                    selection = "0";
                    while (!selection.equals("y") && !selection.equals("n"))
                    {
                         System.out.print("Would you like to search for another customer (y/n): ");
                         selection =  input.nextLine();
                         if (selection.equals("y"))
                         {
                              continue outerLoop;
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
               Customer purchaseMaker = customers.get(customerName);

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
	public void addSalesPerson() {};
	/*
	 * Removes an existing salesperson from the customerMenuBoundary database
	 */
	public void removeSalesPerson() {};
	/*
	 * displays the information of all salespeople in the customerMenuBoundary database
	 */
	public void displaySalesPeople() {};
}
