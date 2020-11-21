/*
 * class for containing the information of a product
 */
public class Product
{
	/**
	* Name of the item
	*/
	private String name;

	/**
	* Price that the item sells for
	*/
	private double sellPrice;

	/**
	* Cost to attain 1 unit of this item before retail sale
	*/
	private double costPrice;


	/*
	 * Default Constructor
	 */
	public Product()
	{
		name = "";
		sellPrice = 0;
		costPrice = 0;
	}

	/**
	* Specific Constructor with values for all data members
	*
	* @param newName Initail name of item
	* @param newSell Initial sell  price of item
	* @param newCost Initial costprice of item
	*/
	public Product(String newName, double newSell, double newCost)
	{
		name = newName;
		sellPrice = newSell;
		costPrice = newCost;
	}

	/**
	* Returns name of item
	*
	* @return Name of the item
	*/
	public String getName()
	{
		return name;
	}

	/**
	* Returns sell  price of item
	*
	* @return Sell price of the item
	*/
	public double getSellPrice()
	{
		return sellPrice;
	}


}
