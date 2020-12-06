import java.util.*;
/*
 * Class for containing the information of an invoice
 */
public class Invoice
{
	/**
	* Stores date and time invoice was created
	*/
	private Calendar dateCreated;

	/**
	* Stores whether or not the invoice is still open
	*/
	private boolean isOpen;

	/**
	* Stores whether or not item(s) on invoice were delivered
	*/
	private boolean isDelivered;

	/**
	* Total price on invoice before payment
	*/
	private double totalCost;

	/**
	* Price remaining on invoice
	*/
	private double remainingCost;

	/**
	* Customer who owes/owed money on the invoice
	*/
	private Customer debtor;

	/**
	* Flags if late charge has been applied
	*/
	private boolean hasCharged;

	/**
	* Map of products and quantities in invoice purchase
	*/
	private Map<Product, Integer> purchases;

	/*
	 * Default Constructor
	 */
	public Invoice()
	{
		//Sets date of invoice creation to current day
		dateCreated = new Calendar.Builder().setCalendarType("gregorian")
				    					 .setDate(Calendar.getInstance().get(Calendar.YEAR),
						   					Calendar.getInstance().get(Calendar.MONTH),
						   					Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
				    					 .setTimeOfDay(Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
							   					Calendar.getInstance().get(Calendar.MINUTE),
							   					Calendar.getInstance().get(Calendar.SECOND)).build();

		hasCharged = false;
		isOpen = true;
		isDelivered = false;
		totalCost = 0;
		remainingCost = 0;
		debtor = new Customer();
		purchases = new HashMap<Product, Integer>();
	}

	/**
	* Specific Constructor - Only specifies debtor and isdelivered because all
	*					other data members should have default initial values
	*/
	public Invoice(Customer newDebtor, boolean newDelivered)
	{
		//Set all specified values
		debtor = newDebtor;
		isDelivered = newDelivered;

		//Set default values for remaining members

		//Sets date of invoice creation to current day
		dateCreated = new Calendar.Builder().setCalendarType("gregorian")
							    		 .setDate(Calendar.getInstance().get(Calendar.YEAR),
							    				Calendar.getInstance().get(Calendar.MONTH),
							    				Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
									 .setTimeOfDay(Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
								    				Calendar.getInstance().get(Calendar.MINUTE),
								    				Calendar.getInstance().get(Calendar.SECOND)).build();

		isOpen = true;
		hasCharged = false;
		purchases = new HashMap<Product, Integer>();
		totalCost = 0;
		remainingCost = 0;

	}

	/**
	* Returns date/time invoice was created
	*
	* @return Object holding date and time of creation of invoice
	*/
	public Calendar getDateCreated()
	{
		return dateCreated;
	}

	/**
	* Returns whether invoice invoice is still open or not
	*
	* @return isOpen member
	*/
	public boolean isOpen()
	{
		return isOpen;
	}

	/**
	* Returns whether invoice items were delivered
	*
	* @return isDelivered member
	*/
	public boolean isDelivered()
	{
		return isDelivered;
	}

	/**
	* Returns total cost of invoice
	*
	* @return totalCost member
	*/
	public double getTotalCost()
	{
		return totalCost;
	}

	/**
	* Returns remaining Cost on invoice to be paid by debtor
	*
	* @return remainingCost member
	*/
	public double getRemainingCost()
	{
		return remainingCost;
	}

	/**
	* Customer who owes/owed money on the invoice
	*/
	public Customer getDebtor()
	{
		return debtor;
	}

	/**
	* Deduct money from remaining cost, if paid full in less than 10 days, customer gets 10% discount
	*
	* @param paymentAmount  Amount to be paid on invoice
	*/
	public void makePayment(double paymentAmount)
	{
		final int NUM_DAYS_DISCOUNT = 10;
		double lowerDiscountThresh = totalCost * .1;

		if (daysBetween(dateCreated.getTime(), Calendar.getInstance().getTime()) < NUM_DAYS_DISCOUNT)
		{
			remainingCost -= paymentAmount;
			if (remainingCost <= lowerDiscountThresh)
			{
				remainingCost = 0;
				isOpen = false;
			}
		}
		else
		{
			remainingCost -= paymentAmount;
			if (remainingCost < 0)
			{
				remainingCost = 0;
				isOpen = false;
			}
		}
	}

	/**
	* Applies late charge to remaining cost if invoice has not been paid off in 30 days
	*/
	public void applyCharge()
	{
		final int NUM_DAYS_FEE = 30;
		final double lateFee = totalCost * .02;
		if (isOpen)
		{
			if (!hasCharged)
			{
				if (daysBetween(dateCreated.getTime(), Calendar.getInstance().getTime()) > NUM_DAYS_FEE)
				{
					remainingCost += lateFee;
					hasCharged = true;
				}
			}
		}
	}

	/**
	* Add product to invoice
	*
	* @param product Product to be added to invoice
	* @param quantity Quantity of product in invoice
	*/
	public void addProduct(Product product, int quantity)
	{
		if (purchases.containsKey(product))
		{
			purchases.put(product, purchases.get(product) + quantity);
		}
		else
		{
			purchases.put(product, quantity);
		}
	}



	/**
	* Helper function that calculates days between 2 dates.
	*
	* @param d1 Earlier date
	* @param d2 Later date
	*/
	private int daysBetween(Date d1, Date d2)
	{
             return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
     }

	public void printInvoice()
	{
		for (Product current: purchases.keySet())
		{
			double itemPrice = current.getSellPrice() * purchases.get(current);
			System.out.println("Product Name                      Quantity Purchased               Price Of Items");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.print(current.getName());
			for (int spaceCounter = 0; spaceCounter <  42 - current.getName().length(); ++spaceCounter)
			{
				System.out.print(" ");
			}
			System.out.print(purchases.get(current));
			for (int spaceCounter = 0; spaceCounter <  35 - current.getName().length(); ++spaceCounter)
			{
				System.out.print(" ");
			}
			System.out.print(current.getSellPrice());
		}
	}
}
