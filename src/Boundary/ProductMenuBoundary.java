package Boundary;

import Control.ProductController;

import java.util.*;
public class ProductMenuBoundary
{
     private ProductController productController;

     public ProductMenuBoundary()
     {
          productController = new ProductController();
     }
     /*
	 * Method to print all menu choices and act upon the input of the user
	 */
	public void printItemMenuChoices()
	{
          Scanner input = new Scanner(System.in);
          int selection = 0;
          while (selection != 4)
          {
               System.out.println("\nPlease make a selection:");
     		System.out.println("1) Add Item\n2) Remove Item\n3) Show all items\n4) Exit");
               selection = input.nextInt();
     		//Switch for menu selection. All cases that return true will reprint the menu choices. All cases that return false will not
     		switch(selection)
     		{
     		//Add item
     		case 1:
     			productController.addProduct();
     			break;
     		//Remove item
     		case 2:
     			productController.removeProduct();
     			break;
     		//Show all items
     		case 3:
     			productController.displayProducts();
                    break;
     		//Exit
     		case 4:
     			break;
     		default:
     			System.out.println("Invalid selection. Please try again.");
     		}
          }
          
	}
}
