package Boundary;

import Control.WarehouseController;

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
                                  "5) Display All Products With Quantity of 5 or Less\n" +
                                  "6) Edit quantity of an item\n" +
                                  "7) Remove item supply in warehouse\n8) Exit");
               selection = input.nextLine();
               //Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
               switch(selection)
               {
               //Add Warehouse
               case "1":
                    warehouseController.addWarehouse();
                    break;
               //Remove Warehouse
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

               case "5":
                    warehouseController.displayProductsLimitedQuantity();
                    break;
               //Allows user to edit quantity of an item in a warehouse
               case "6":
                    ///Asks user to select an item in the warehouse to remove
                    System.out.print("Enter name of warehouse with the product: ");
                    String warehouseToEdit = input.nextLine();
                    System.out.print("Enter name of product: ");
                    String productToEdit = input.nextLine();
                    System.out.print("Enter new quantity for product: ");
                    int newQuantity = Integer.parseInt(input.nextLine());
                    warehouseController.changeWarehouseItemQuantity(warehouseToEdit, productToEdit, newQuantity);
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
