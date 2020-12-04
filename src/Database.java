public class Database
{
     /**
     * Maps name of warehouse to a warehouse object, holds all warehouse objects
     */
     private HashMap<String, Warehouse> allWarehouses;

     /**
     * Maps name of customer to a customer object, holds all customer objects
     */
     private HashMap<String, Customer> allCustomers;

     /**
     * Maps name of debtor to one or many invoices, holds all invoice objects
     */
     private HashMap<String, Invoice> allInvoices;

     /**
     * Maps name of salesperson to salesperson object, holds all salespeople
     */
     private HashMap<String, SalesPerson> allSalesPersons;

     /**
     * Maps name of item to item object, holds all items
     */
     private HashMap<String, Product> allProducts

     /**
     * Default constructor
     */
     public Database()
     {
          allWarehouses = new HashMap<String, Warehouse>();
          allCustomers = new HashMap<String, Customer>();
          allInvoices = new HashMap<String, Invoice>();
          allSalesPersons = new HashMap<String, SalesPerson>();
          allProducts = new HashMap<String, Product>();
     }

     /**
     * Returns map of all warehouses
     *
     *  @return Map of all warehouses
     */
     public HashMap<String, Warehouse> getAllWarehouses()
     {
          return allWarehouses;
     }

     /**
     * Returns map of all customers
     *
     * @return Map of all customers
     */
     public HashMap<String, Customer> getAllCustomers()
     {
          return allCustomers;
     }

     /**
     * Returns map of all invoices
     *
     * @return Map of all invoices
     */
     public HashMap<String, Invoice> getAllInvoices()
     {
          return allInvoices;
     }

     /**
     * Reutrns  map of all salesperson
     *
     * @return Map of all salespersons
     */
     public HashMap<String, SalesPerson> getAllSalesPersons()
     {
          return allSalesPersons;
     }

     /**
     * Returns map of all products
     *
     * @return Map of all products
     */
     public HashMap<String, Product> getAllProducts()
     {
          return allProducts;
     }

}
