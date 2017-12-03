package ie.lyit.serialize;

import ie.lyit.hotel.Customer;

public interface DAOCustomerSerializer {
	public void create(Customer newCustomer);
	public Customer view(int number);
	public String list();
	public void edit(int number, Customer editedCustomer);
	public boolean delete(int number);
	public void saveFiles();
}
