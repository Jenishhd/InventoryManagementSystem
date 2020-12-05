import java.util.*;

/*
 * Class for containing the information of a warehouse and the objects it contains
 */
public class Warehouse
{
	/*
	 * ProductStore Class to store products stored in the warehouse, as well as the quantity the warehouse contains
	 */
	private class ProductStore implements Comparable<ProductStore>
	{
		int quantity;
		Product product;
		public ProductStore(Product i)
		{
			product = i;
			quantity = 0;
		}

		@Override
		public boolean equals(Object o)
		{
			if (o instanceof ProductStore)
			{
				ProductStore productStoreCast = (ProductStore) o;
				if (productStoreCast.getProduct().getName().equals(product.getName()))
				{
					return true;
				}
			}
			if (o instanceof String)
			{
				String stringCast = (String) o;
				if (stringCast.equals(product.getName()))
				{
					return true;
				}
			}
			return false;
		}

		@Override
		public int compareTo(ProductStore otherProduct)
		{
			return quantity - otherProduct.quantity;
		}



		public Product getProduct()
		{
			return product;
		}

		public int getQuantity()
		{
			return quantity;
		}

	}

	private String warehouseName;
	private ArrayList<ProductStore> warehouseProducts;

	/*
	 * Constructor
	 */
	public Warehouse()
	{
		warehouseName = "";
		warehouseProducts = new ArrayList<ProductStore>();
	}

	public Warehouse(String name)
	{
		warehouseName = name;
		warehouseProducts = new ArrayList<ProductStore>();
	}

	/*
	 * warehouseName getter
	 * @return the name of the warehouse as a String variable
	 */
	public String getWarehouseName()
	{
		return warehouseName;
	}

	/*
	 * warehouseName setter
	 */
	public void SetWarehouseName(String i)
	{
		warehouseName = i;
	}

	public ArrayList<ProductStore> getWarehouseProducts()
	{
		return warehouseProducts;
	}

	/*
	 * Adds integer j of a certain Product contained in the warehouse
	 * @Return True if the addition was successful and False if it was not
	 */
	public boolean addProduct(Product newProduct)
	{
		// ///Finds Product i in the warehouseProducts list
		// for (int x = 0; x < warehouseProducts.size(); x++)
		// {
		// 	if (warehouseProducts.get(x).product.equals(i))
		// 	{
		// 		warehouseProducts.get(x).quantity += j;
		// 		System.out.println("Add Product: Product added successfully");
		// 		return true;
		// 	}
		// }
		// //If the object is not found in the warehouse storage, print an error message and return false
		// System.out.println("[ERROR] Add Product: Product not found");
		// return false;
		ProductStore newProductStore = new ProductStore(newProduct);
		if (!warehouseProducts.contains(newProductStore))
		{
			warehouseProducts.add(newProductStore);
			return true;
		}
		return false;
	}

	public void displayAllProducts()
	{
		Collections.sort(warehouseProducts);
		System.out.println(warehouseName);
		for (int productIt = 0; productIt < warehouseProducts.size(); ++productIt)
		{
			System.out.println(warehouseProducts.get(productIt).getProduct().getName() + " "
						    + warehouseProducts.get(productIt).getQuantity());
		}
	}

	// public void sortItems()
	// {
	// 	for (int productIt = 0; productIt < warehouseProducts.size() - 1; ++productIt)
	// 	{
	// 		for (int compareIt = 0; compareIt < warehouseProducts.size() - productIt - 1; ++compareIt)
	// 		{
	//
	// 		}
	// 	}
	// }

	/*
	 * Removes integer j of a certain Product contained in the warehouse
	 * @Return True if the removal was successful and False if it was not
	 */
	public boolean removeProduct(Product i, int j)
	{
		///Finds Product i in the warehouseProducts list
		for (int x = 0; x < warehouseProducts.size(); x++)
		{
			if (warehouseProducts.get(x).product.equals(i))
			{
				//Makes sure the quantity of the Product in the warehouse is less-than or equal-to the amount being removed
				//...if it is not
				if (warehouseProducts.get(x).quantity < j)
				{
					System.out.println("[ERROR] Remove Product: Attempted to remove too many items");
					return false;
				}
				///...if it is
				else
				{
					System.out.println("Remove Product: Items removed successfully");
					warehouseProducts.get(x).quantity -= j;
					return true;
				}
			}
		}
		//If the object is not found in the warehouse storage, print an error message and return false
		System.out.println("[ERROR] Remove Product: Item to remove could not be found");
		return false;
	}

	/*
	 * Adds a new product to the warehouse storage
	 * @Return True if the product is added successfully amd false if it is not
	 */
	public boolean addNewProduct(Product i)
	{
		///Checks if Product already exists in the warehouseProducts list...
		for (int x = 0; x < warehouseProducts.size(); x++)
		{
			///...if it does
			if (warehouseProducts.get(x).product.equals(i))
			{
				System.out.println("[ERROR] Add New Product: Product already stored in warehouse");
				return false;
			}
		}
		//If it does not...
		ProductStore temp = new ProductStore(i);
		warehouseProducts.add(temp);
		System.out.println("Add New Product: New Product added successfully");
		return true;
	}

	/*
	 * Removes an existing product from the warehouse entirely
	 * @Return True if the product is removed successfully and false if it is not
	 */
	public boolean removeEntireProduct(Product i)
	{
		///Finds the Product i in the warehouseProducts list...
		for (int x = 0; x < warehouseProducts.size(); x++)
		{
			///...if it is found
			if (warehouseProducts.get(x).product.equals(i))
			{
				warehouseProducts.remove(warehouseProducts.get(x));
				System.out.println("Remove Entire Product: Product removed successfully");
				return true;
			}
		}
		///...if it is not
		System.out.println("[ERROR] Remove Entire Product: Product not found in warehouse");
		return false;
	}
}
