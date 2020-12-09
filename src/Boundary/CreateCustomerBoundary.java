package Boundary;
import Control.CustomerController;
import Entity.Customer;


import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;

public class CreateCustomerBoundary
{
    Scanner scnr = new Scanner(System.in);

    /*
     * This method adds a customer defined by the user.
     * The user enters the first and last name and sales tax of the customer they want to add to the given database.
     * */
    public void createCustomer ()
    {
        double cTaxRate = 0;
        CustomerController cController = new CustomerController();
        System.out.println("Enter the first name of the customer: ");
        String cFirstName = scnr.nextLine();

        System.out.println("Enter the last name of the customer: ");
        String cLastName = scnr.nextLine();

        System.out.println("Enter the address of the customer: ");
        String cAddress = scnr.nextLine();

        try
        {
            System.out.println("Enter the tax rate (percentage) applied to the customer: ");
            cTaxRate = scnr.nextDouble();
            scnr.nextLine();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Incorrect input type! Please re create with correct type.");
            return;
        }

        Customer customer = new Customer(cFirstName,cLastName, cAddress, cTaxRate / 100.0);
        cController.addCustomer(customer);

        System.out.println("The customer " + cFirstName + " " + cLastName + " was added to the database.");
    }
}
