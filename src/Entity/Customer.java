package Entity;

import java.util.*;
/**
 * Class for containing the information of a product
 *
 * @author Blake Del Rey
 */
public class Customer
{
	/**
	* First name of customer
	*/
	private String firstName;

	/**
	* Last name of customer
	*/
	private String lastName;

	/**
	* ID number for customer
	*/
	private String ID;

	/**
	* Rate at which customer should be taxed for the sale
	* stored as decimal NOT percent
	*/
	private double salesTaxRate;

	/**
	 * Default Constructor that initializes names to empty and taxRate to .8
	 */
	public Customer()
	{
		firstName = "";
		lastName = "";
		salesTaxRate = .8;
		ID = UUID.randomUUID().toString();
	}

	/**
	* Constructor with specified values for all data members
	*
	* @param newFirstName Initial first name for customer
	* @param newLastName Initial last name for customer
	* @param newSalesTaxRate Initial sales tax rate for customer
	*/
	public Customer(String newFirstName, String newLastName, double newSalesTaxRate)
	{
		firstName = newFirstName;
		lastName = newLastName;
		salesTaxRate = newSalesTaxRate;
	}

	/**
	* Gets first name of the customer
	*
	* @return First name of the customer
	*/
	public String getFirstName()
	{
		return firstName;
	}

	/**
	* Gets last name of the customer
	*
	* @return Last name of the customer
	*/
	public String getLastName()
	{
		return lastName;
	}

	/**
	* Gets sales tax rate for the customer
	*
	* @return Sales Tax Rate for the customer
	*/
	public double getSalesTaxRate()
	{
		return salesTaxRate;
	}

	/**
	* Sets first name of customer to a new first name
	*
	* @param newFirstName New first name for customer to be set to
	*/
	public void setFirstName(String newFirstName)
	{
		firstName = newFirstName;
	}

	/**
	* Sets last name  of customer to a new last name
	*
	* @param newLastName
	*/
	public void setLastName(String newLastName)
	{
		lastName = newLastName;
	}

	/**
	* Sets the sales tax rate to a new value
	*
	* @param newRate New sales tax rate for the customer
	*/
	public void setSalesTaxRate(double newRate)
	{
		salesTaxRate = newRate;
	}

	/**
	* Gets the ID of the customer
	*
	* @return ID of customer
	*/
	public String getID()
	{
		return ID;
	}

}
