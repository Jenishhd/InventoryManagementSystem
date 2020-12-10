package Boundary;

import Control.ProductController;
import Control.WarehouseController;

import java.util.*;

public class WarehouseMenuBoundary
{
     /**
     * Controls database interaction for warehouses
     */
     private WarehouseController warehouseController;

     /**
      * Controls database interaction for products
      */
     private ProductController productController;

     /**
     * Constructor that intiializes the warehouseController
     */
     public WarehouseMenuBoundary()
     {
          warehouseController = new WarehouseController();
          productController = new ProductController();
     }

     /*
      * Method to print all menu choices and act upon the input of the user
      */
     public void printWarehouseMenuChoices()
     {
          Scanner input = new Scanner(System.in);
          String selection = "0";
          while (!selection.equals("7"))
          {
               System.out.println("\nPlease make a selection:");
               System.out.println("1) Add Warehouse\n2) Remove Warehouse\n" +
                                  "3) Show all warehouses\n4) Display All Products With Quantity \n" +
                                  "5) Display All Products With Quantity of 5 or Less\n" +
                                  "6) Add/Edit quantity of an item to Warehouse\n" +
                                  "7) Exit");
               System.out.print("Choice: ");
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
                    boolean found = true;
                    warehouseController.displayWarehouses();
                    System.out.print("Enter name of warehouse with the product: ");
                    String warehouseToEdit = input.nextLine();

                    warehouseLoop:
                    while (warehouseController.getWarehouse(warehouseToEdit) == null)
                    {
                         System.out.println("**WAREHOUSE NOT FOUND**");
                         selection = "0";
                         while (!selection.equals("y") && !selection.equals("n"))
                         {
                              System.out.print("Would you like to search for another warehouse (y/n): ");
                              selection =  input.nextLine();
                              if (selection.equals("y"))
                              {
                                   System.out.print("Enter name of warehouse with the product: ");
                                   warehouseToEdit = input.nextLine();
                              }
                              else if (selection.equals("n"))
                              {
                                   found = false;
                                   break warehouseLoop;
                              }
                              else
                              {
                                   System.out.println("**INVALID INPUT TRY AGAIN**");
                              }
                         }
                    }

                    String productToEdit = "NONE";
                    if (found)
                    {
                         warehouseController.getWarehouse(warehouseToEdit).displayAllProducts();
                         System.out.print("Enter name of product: ");
                         productToEdit = input.nextLine();
                         proudctLoop:
                         while (productController.getProduct(productToEdit) == null)
                         {
                              System.out.println("**PROUDCT NOT FOUND**");
                              selection = "0";
                              while (!selection.equals("y") && !selection.equals("n"))
                              {
                                   System.out.print("Would you like to search for another product (y/n): ");
                                   selection =  input.nextLine();
                                   if (selection.equals("y"))
                                   {
                                        System.out.print("Enter name of product: ");
                                        productToEdit = input.nextLine();
                                   }
                                   else if (selection.equals("n"))
                                   {
                                        found = false;
                                        break proudctLoop;
                                   }
                                   else
                                   {
                                        System.out.println("**INVALID INPUT TRY AGAIN**");
                                   }
                              }
                         }

                    }

                    if (found)
                    {
                         int newQuantity = 0;
                         try
                         {
                              System.out.print("Enter new quantity for product: ");
                              newQuantity = Integer.parseInt(input.nextLine());
//                        System.out.println("Enter the tax rate (percentage) applied to the customer: ");
//                        cTaxRate = scnr.nextDouble();
//                        scnr.nextLine();
                         }
                         catch(NumberFormatException e)
                         {
                              System.out.println("Incorrect input type! Please re-create with correct type.");
                              break;
                         }

                         warehouseController.changeWarehouseItemQuantity(warehouseToEdit, productToEdit, newQuantity);
                    }

                    break;
               case "7":
                    break;
               default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
               }
          }

     }
}
