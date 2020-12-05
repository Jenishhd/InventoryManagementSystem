import java.util.*;

public class WarehouseMenuBoundary
{
     /**
     * Controls database interaction for warehouses
     */
     private WarehouseController warehouseController;

     /**
     * Constructor that intiializes the warehouseController
     */
     public WarehouseMenuBoundary()
     {
          warehouseController = new WarehouseController();
     }

     /*
      * Method to print all menu choices and act upon the input of the user
      */
     public void printWarehouseMenuChoices()
     {
          Scanner input = new Scanner(System.in);
          String selection = "0";
          while (!selection.equals("8"))
          {
               System.out.println("\nPlease make a selection:");
               System.out.println("1) Add Warehouse\n2) Remove Warehouse\n" +
                                  "3) Show all warehouses\n4) Display All Products With Quantity \n" +
                                  "5) Edit quantity of an item\n6) Supply item in warehouse\n" +
                                  "7) Remove item supply in warehouse\n8) Exit");
               selection = input.nextLine();
               //Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
               switch(selection)
               {
               //Add customer
               case "1":
                    warehouseController.addWarehouse();
                    break;
               //Remove customer
               case "2":
                    warehouseController.removeWarehouse();
                    break;
               //Show all customers
               case "3":
                    warehouseController.displayWarehouses();
                    break;
               //Adds a new item to the warehouse. Item must already exist in ItemMenuBoundary
               case "4":
                    ///Asks user to select an item in the itemMenuBoundary to add, and the quantity
                    warehouseController.displayAllWarehousesWithProducts();
                    break;
               //Allows user to edit quantity of an item in a warehouse
               case "5":
                    ///Asks user to select an item in the warehouse to remove
                    System.out.print("Enter name of warehouse you'd like to edit product quantity: ");
                    String warehouseToEdit = input.nextLine();
                    System.out.print("Enter name of product you'd like to edit quantity of: ");
                    String productToEdit = input.nextLine();
                    System.out.print("Enter new quantity for product: ");
                    int newQuantity = input.nextInt();
                    warehouseController.changeWarehouseItemQuantity(warehouseToEdit, productToEdit, newQuantity);
                    break;
               //Adds a certain amount to an item in the warehouse. Item must exist in the warehouse already
               case "6":
                    break;
               //Removes a certain amount of an item form the warehouse. Item must exist in the warehouse already, and resulting item quantity cannot be <0
               case "7":
                    ///Asks user for number to remove
                    //warehouseController.changeWarehouseItemQuantity(/*negative int*/);
                    break;
               //Exit
               case "8":
                    break;
               default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
               }
          }

     }
}
