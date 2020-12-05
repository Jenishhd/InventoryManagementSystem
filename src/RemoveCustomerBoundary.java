import java.util.List;
import java.util.Scanner;

public class RemoveCustomerBoundary {
    Scanner scnr = new Scanner(System.in);

    /*
    * This method removes a customer defined by the user.
    * The user enters the first and last name of the customer they want to remove from the given database.
    * */
    public void removeCustomer()
    {

        System.out.println("Enter the first name of the customer you want to remove: ");
        String cFirstName = scnr.nextLine();

        System.out.println("Enter the last name of the customer you want to remove: ");
        String cLastName = scnr.nextLine();

        if (Database.getInstance().getAllCustomers().containsKey(cFirstName + " " + cLastName))
        {
             Database.getInstance().getAllCustomers().remove(cFirstName + " " + cLastName);
             return;
        }
        System.out.println("This customer was not found in the database.");


    }
}
