package Entity;

import java.util.*;

/*
 * Class for containing the information of a salesperson
 */
public class SalesPerson 
{
	/**
	 * First name of the SalesPerson
	 */
	private String firstName;
	/**
	 * Last name of the SalesPerson
	 */
	private String lastName;
	/**
	 * Commission percentage of the SalesPerson
	 */
	private double commPercent;
	/**
	 * The commissions done of the SalesPerson that isn't paid to the Salesperson yet
	 */
	private Map<Customer, Double> commissions;
	/**
	 * The total amount of commissions done by the SalesPerson
	 */
	private Map<Customer, Double> commissionsDone;
	/*
	 * Total earned from sales by this salesperson
	 */
	private double totalSales;
	/*
	 * Total commission earned from sales
	 */
	private double totalCommission;
	/*
	 * Constructor of SalesPerson
	 */
	public SalesPerson()
	{
		//Initial Variables
		firstName ="";
		lastName = "";
		commPercent = 0.0;
		commissions = new HashMap<Customer,Double>();
		commissionsDone = new HashMap<Customer,Double>();
	}
	/**
	 * Parameterized Constructor of SalesPerson
	 * @param first First Name of SalesPerson
	 * @param last Last Name of SalesPerson
	 * @param percent Commission Percentage of SalesPerson
	 */
	public SalesPerson(String first, String last, double percent) {
		firstName = first;
		lastName = last;
		commPercent = percent;
	}
	/**
	 * Method which sets the first name of the SalesPerson
	 * @param first
	 */
	public void setFirstName(String first){
		firstName = first;
	}
	/**
	 * Method which sets the last name of the SalesPerson
	 * @param last
	 */
	public void setLastName(String last) {
		lastName = last;
	}
	/**
	 * Method that sets the Commission Percentage that the SalesPerson gets for their commission
	 * @param percent
	 */
	public void setCommissionPercentage(double percent) {
		commPercent = percent;
	}
	/**
	 * Method which returns the SalesPerson's first name
	 * @return first name of SalesPerson
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Method which returns the SalesPerson's last name
	 * @return last name of SalesPerson
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Returns the total profit from sales by this salesperson
	 * @return total sales
	 */
	public double getTotalSales()
	{
		return totalSales;
	}
	/**
	 * Updates the value of totalSales
	 * @param i new value of totalSales
	 */
	public void setTotalSales(double i)
	{
		totalSales = i;
	}
	/**
	 * returns the total commissions from sales by this salesperson
	 * @return total commissions
	 */
	public double getTotalCommissionEarned() 
	{
		return totalCommission;
	}
	/**
	 * Updates the value of totalCommissions
	 * @param i new value of totalCommissions
	 */
	public void setTotalCommissionEarned(double i)
	{
		totalCommission = i;
	}
	
	/**
	 * Method which adds a commission that a salesperson has transacted and 
	 * stores it to their individual person.
	 * @param customer input would look like Invoice.getDebtor()
	 * @param cost input would look like Invoice.getTotalCost()
	 */
	public void addCommission(Customer customer, double cost) {
		if(commissions.containsKey(customer)) {
			commissions.put(customer, commissions.get(customer)+cost);
			commissionsDone.put(customer, commissionsDone.get(customer)+cost);
		}
		else {
			commissions.put(customer, cost);
			commissionsDone.put(customer, cost);
		}
	}
	/**
	 * Method which returns the commission percentage that is applies for the SalesPerson
	 * @return commission percentage
	 */
	public double getCommissionPercentage() {
		return commPercent;
	}
	/**
	 * Method which returns the total Commissions that the SalesPerson has done
	 * @return total commissions done
	 */
	public int getTotalCommissions() {
		return commissionsDone.size();
	}
	/**
	 * Method which returns the payment to the SalesPerson of their total sales
	 * Note that this is assuming that the commPercentage would not be rounded to decimals
	 * @return payment to the SalesPerson of their commissions and the applied Commission percentage
	 */
	public double getPayment() {
		double total=0;
		for(Customer key: commissions.keySet()) {
			total+= commissions.get(key);
		}
		return total;
	}
	/**
	 * Method which clears the commissions that they did when they get paid. 
	 * Data of their total commissions and transactions are still stored within program
	 * as a safety measure
	 */
	public void salesPersonPaid() {
		commissions.clear();
	}
	
}
