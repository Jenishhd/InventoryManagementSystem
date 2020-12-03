import java.util.List;
import java.util.Scanner;

public class RemoveCustomerBoundary {
    Scanner scnr = new Scanner(System.in);

    /*
    * This method removes a customer defined by the user.
    * The user enters the first and last name of the customer they want to remove from the given database.
    * */
    public void removeCustomer(List<Customer> customers) {

        System.out.println("Enter the first name of the customer you want to remove: ");
        String cFirstName = scnr.nextLine();

        System.out.println("Enter the last name of the customer you want to remove: ");
        String cLastName = scnr.nextLine();

        for(int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getFirstName().equals(cFirstName) && customers.get(i).getLastName().equals(cLastName)) {
                customers.remove(customers.get(i));
                System.out.println("The customer " + cFirstName +" " + cLastName + " was removed from the database.");
                break;
            }
        }
        System.out.println("This customer was not found in the database.");

    }
}
