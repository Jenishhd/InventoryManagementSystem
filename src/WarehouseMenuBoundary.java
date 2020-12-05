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
     public boolean printWarehouseMenuChoices()
     {
          Scanner input = new Scanner(System.in);
          System.out.println("\nPlease make a selection:");
          System.out.println("1) Add Warehouse\n2) Remove Warehouse\n3) Show all warehouses\n4) Display All Products With Quantity \n5) Remove item from warehouse\n6) Supply item in warehouse\n7) Remove item supply in warehouse\n8) Exit");
          //Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
          switch(input.nextLine())
          {
          //Add customer
          case "1":
               warehouseController.addWarehouse();
               return true;
          //Remove customer
          case "2":
               warehouseController.removeWarehouse();
               return true;
          //Show all customers
          case "3":
               warehouseController.displayWarehouses();
               return true;
          //Adds a new item to the warehouse. Item must already exist in ItemMenuBoundary
          case "4":
               ///Asks user to select an item in the itemMenuBoundary to add, and the quantity
               warehouseController.displayAllWarehousesWithProducts();
               return true;
          //Removes item entirely from warehouse. Item must already be contained in warehouse
          case "5":
               ///Asks user to select an item in the warehouse to remove
               warehouseController.removeWarehouseItem();
               return true;
          //Adds a certain amount to an item in the warehouse. Item must exist in the warehouse already
          case "6":
               System.out.print("Enter name of warehouse you'd like to edit product quantity: ");
               String warehouseToEdit = input.nextLine();
               System.out.print("Enter name of product you'd like to edit quantity of: ");
               String productToEdit = input.nextLine();
               System.out.print("Enter new quantity for product: ");
               int newQuantity = input.nextInt();
               warehouseController.changeWarehouseItemQuantity(warehouseToEdit, productToEdit, newQuantity);
               return true;
          //Removes a certain amount of an item form the warehouse. Item must exist in the warehouse already, and resulting item quantity cannot be <0
          case "7":
               ///Asks user for number to remove
               //warehouseController.changeWarehouseItemQuantity(/*negative int*/);
               return true;
          //Exit
          case "8":
               return false;
          default:
               System.out.println("Invalid selection. Please try again.");
               return true;
          }
     }
}
