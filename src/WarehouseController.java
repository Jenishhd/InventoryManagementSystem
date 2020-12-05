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
          Database.getInstance().getAllWarehouses().put(name, new Warehouse(name));
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

     public void addWarehouseItem()
     {

     };
     public void removeWarehouseItem() {};
     public void changeWarehouseItemQuantity(/* int i*/) {};



}
