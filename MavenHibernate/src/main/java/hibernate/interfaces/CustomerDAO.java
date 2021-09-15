package hibernate.interfaces;

import java.util.List;

import hibernate.model.Customer;

public interface CustomerDAO {
	
	public void saveCustomer(Customer cust);
	
    public void insertCustomer();
	
    public List<Customer> getCustomers();

	public void updateCustomer(Customer cust);
	
	public void deleteCustomer(int id);
	
	public Customer getCustomer(int id) ;
	
	//public Customer findCustomer(int id);
}
