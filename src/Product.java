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

	/**
	 * Number of unsold units currently in existance
	 */
	private int quantity;

	/**
	 * Number of sold units
	 */
	private int quantitySold;

	/**
	 * The current earnings from sales compared to the total cost of production
	 */
	private double totalProfit;

	/**
	 * The current profits compared to the total cost of production as a percentile-value
	 */
	private double totalProfitPercent;


	/*
	 * Default Constructor
	 */
	public Product()
	{
		name = "";
		sellPrice = 0;
		costPrice = 0;
	}

	public Product(String productName)
	{
		name = productName;
		sellPrice = 0;
		costPrice = 0;
	}

	/**
	* Specific Constructor with values for all data members
	*
	* @param newName Initial name of item
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
	 * Changes the name of item
	 * @param i new name of item
	 */
	public void setName(String i)
	{
		name = i;
	}

	public void setQuantity(int newQuantity)
	{
		quantity = newQuantity;
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


	/**
	 * changes the sell price of item
	 * @param d new sell price
	 */
	public void setSellPrice(double d)
	{
		sellPrice = d;
	}

	/**
	 * Returns the total cost of production for the product
	 * @return total cost of production
	 */
	public double getCostPrice()
	{
		return costPrice;
	}

	public void setCostPrice(double d)
	{
		costPrice = d;
	}

	/**
	 * Returns the current quantity of the product available for sale
	 * @return quantity of the product
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * Returns the total number of units sold of this product
	 * @return number of units sold
	 */
	public int getQuantitySold()
	{
		return quantitySold;
	}

	/**
	 * Returns the total money earned from sale of this product
	 * @return total money earned from sales
	 */
	public double getTotalSales()
	{
		return (quantitySold * sellPrice);
	}

	/**
	 * returns the total money that was spent producing this product
	 * @return money spent in production
	 */
	public double getTotalCost()
	{
		return (quantity * costPrice);
	}

	/**
	 * Calculates the total profit from this product's production and sale, and assigns it to the totalProfit variable
	 */
	public void getTotalProfit()
	{
		totalProfit = (getTotalSales() - getTotalCost());
	}

	/**
	 * Calculates how the profit of the product has surpassed the total production cost as a percent-value. This value is assigned to the totalProfitPercent variable
	 */
	public void calcTotalProfitPercent()
	{
		totalProfitPercent = (totalProfit / getTotalCost());
	}


}
