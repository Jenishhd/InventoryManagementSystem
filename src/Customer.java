/*
 * Class for containing the information of a product
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
	* Rate at which customer should be taxed for the sale
	* stored as decimal NOT percent
	*/
	private double salesTaxRate;

	/*
	 * Constructor
	 */
	public Customer()
	{
		firstName = "";
		lastName = "";
		salesTaxRate = .8;
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

}
