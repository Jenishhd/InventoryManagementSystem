import java.util.*;

/*
 * Class for containing the information of a salesperson
 */
public class SalesPerson 
{
	private String firstName;
	private String lastName;
	private double commPercent;
	private Map<Customer, Double> commissions;
	private Map<Customer, Double> commissionsDone;
	private double payment;
	/*
	 * Constructor
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
	public void salesPersonPaid() {
		commissions.clear();
	}
	
}
