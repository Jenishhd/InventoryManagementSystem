/*
 * Class for containing the information of a salesperson
 */
public class SalesPerson 
{
	private String firstName;
	private String lastName;
	private double commPercent;
	/*
	 * Constructor
	 */
	public SalesPerson()
	{
		//Initial Variables
		firstName ="";
		lastName = "";
		commPercent = 0.0;
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
	 * Method which returns the commission percentage that is applies for the SalesPerson
	 * @return commission percentage
	 */
	public double getCommissionPercentage() {
		return commPercent;
	}
	/**
	 * Method which returns the total Commissions that the SalesPerson has done
	 * @return total commissions done
	 * note: may be obselete
	 */
	public int getTotalCommissions() {
		return 0;
	}
	/**
	 * Method which returns the payment to the SalesPerson of their total sales
	 * @return payment to the SalesPerson of their commissions and the applied Commission percentage
	 */
	public double getPayment() {
		return 0.0;
	}
	
}
