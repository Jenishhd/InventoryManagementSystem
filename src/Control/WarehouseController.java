package Control;

import DB.*;
import Entity.*;
import Entity.*;

import java.util.*;
public class WarehouseController
{


     /*
      * Adds a new customer to the Boundary.CustomerMenuBoundary database
      */
     public void addWarehouse()
     {
          Scanner input = new Scanner(System.in);
          System.out.print("Enter name of the warehouse: ");
          String name = input.nextLine();
          Warehouse newWarehouse = new Warehouse(name);
          for (String productName: Database.getInstance().getAllProducts().keySet())
          {
               Product current = Database.getInstance().getAllProducts().get(productName);
               newWarehouse.addProduct(current);
          }
          Database.getInstance().getAllWarehouses().put(name, newWarehouse);
     }
     /*
      * Removes an existing customer from the Boundary.CustomerMenuBoundary database. Checks if the customer exists
      */
     public void removeWarehouse()
     {
          Scanner input = new Scanner(System.in);
          System.out.print("Enter name of the warehouse you'd like to delete: ");
          String name = input.nextLine();
          if (Database.getInstance().getAllWarehouses().containsKey(name))
          {
               Database.getInstance().getAllWarehouses().remove(name);
          }
          else
          {
               System.out.println("**WAREHOUSE COULD NOT BE FOUND IN DATABASE**");
          }
     };

     /*
      * Displays all current warehouses in the Boundary.WareHouseMenuBoundary database
      */
     public void displayWarehouses()
     {
    	 System.out.println("\nWarehouses");
    	 System.out.println("----------");
    	 System.out.printf("%-22s%-22s\n","Name","Total Item Quantity");
          for (String name: Database.getInstance().getAllWarehouses().keySet())
          {
        	  Warehouse current = Database.getInstance().getAllWarehouses().get(name);
        	  int temp = 0;
        	  for (int i = 0; i < current.getWarehouseProducts().size(); i++)
        	  {
        		  temp += current.getQuantityIndex(i);
        	  }
        	  
        	  System.out.printf("%-22s%-22s\n", name, temp);
          }
          System.out.println("----------");
     }
/**
 * Displays all warehouses with products
 */
     public void displayAllWarehousesWithProducts()
     {
          for (String name: Database.getInstance().getAllWarehouses().keySet())
          {
               Warehouse current = Database.getInstance().getAllWarehouses().get(name);
               current.displayAllProducts();
          }
     }
/**
 * Displays products in warehouse that has 5 or fewer items in stock
 */
     public void displayProductsLimitedQuantity()
     {
          for (String name: Database.getInstance().getAllWarehouses().keySet())
          {
               Warehouse current = Database.getInstance().getAllWarehouses().get(name);
               current.displayLimitedQuantity();
          }
     }
/**
 * Note: this code seems obsolete
 * @param p
 */
     public void addWarehouseProduct(Product p)
     {
          for (String warehouseName: Database.getInstance().getAllWarehouses().keySet())
          {
               Warehouse current = Database.getInstance().getAllWarehouses().get(warehouseName);
               current.addProduct(p);
          }
     }
     /**
      * Note: this code seems obsolete
      */
     public void removeWarehouseItem() {};
     public void changeWarehouseItemQuantity(String warehouseName, String productName, int newQuantity)
     {
          if (Database.getInstance().getAllWarehouses().containsKey(warehouseName))
          {
               Warehouse current = Database.getInstance().getAllWarehouses().get(warehouseName);
               current.updateQuantity(productName, newQuantity);
          }
          else
          {
               System.out.println("**WAREHOUSE COULD NOT BE FOUND**");
          }

     }
     /**
      * note: this function seems obsolete
      * @param warehouseName
      * @param productName
      * @param shiftInQuantity
      */
     public void changeQuantityByAmount(String warehouseName, String productName, int shiftInQuantity)
     {
          if (Database.getInstance().getAllWarehouses().containsKey(warehouseName))
          {
               Warehouse current = Database.getInstance().getAllWarehouses().get(warehouseName);
               current.changeQuantityByAmount(productName, shiftInQuantity);
          }
          else
          {
               System.out.println("**WAREHOUSE COULD NOT BE FOUND**");
          }
     }



}
