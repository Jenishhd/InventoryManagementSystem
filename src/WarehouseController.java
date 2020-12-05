import java.util.*;
public class WarehouseController
{


     /*
      * Adds a new customer to the CustomerMenuBoundary database
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
      * Removes an existing customer from the CustomerMenuBoundary database. Checks if the customer exists
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
      * Displays all current customers in the CustomerMenuBoundary database
      */
     public void displayWarehouses()
     {
          System.out.println("Warehouses");
          System.out.println("----------");
          for (String name: Database.getInstance().getAllWarehouses().keySet())
          {
               System.out.println(name);
          }
     }

     public void displayAllWarehousesWithProducts()
     {
          for (String name: Database.getInstance().getAllWarehouses().keySet())
          {
               Warehouse current = Database.getInstance().getAllWarehouses().get(name);
               current.displayAllProducts();
          }
     }

     public void displayProductsLimitedQuantity()
     {
          for (String name: Database.getInstance().getAllWarehouses().keySet())
          {
               Warehouse current = Database.getInstance().getAllWarehouses().get(name);
               current.displayLimitedQuantity();
          }
     }

     public void addWarehouseProduct(Product p)
     {
          for (String warehouseName: Database.getInstance().getAllWarehouses().keySet())
          {
               Warehouse current = Database.getInstance().getAllWarehouses().get(warehouseName);
               current.addProduct(p);
          }
     }
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

     };



}
