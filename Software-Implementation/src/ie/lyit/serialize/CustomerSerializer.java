package ie.lyit.serialize;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Name;

public class CustomerSerializer implements DAOCustomerSerializer{
	private static CustomerSerializer serializer;
	ArrayList<Customer> customerList;
	File path = new File("CustomerData.txt");
	BufferedWriter bw; // 
	
	private CustomerSerializer()
	{
		CustomerDeserializer deserializer = new CustomerDeserializer();
		customerList = deserializer.loadFile(path); 
	}
	
	public static CustomerSerializer getSerializer()
	{
		if(serializer == null)
		{
			serializer = new CustomerSerializer();
		}
		return serializer;
	}
	
	public void create(Customer newCustomer)
	{
		if(!customerList.contains(newCustomer))
			customerList.add(newCustomer);
	}
	
	public Customer view(int number)
	{
		for(Customer customer : customerList)
		{
			if(customer.getNumber() == number)
			{
				return customer;
			}
		}
		return null;
	}
	
	public String list()
	{
		String str = "";
		for(Customer customer : customerList)
		{
			str = str + "Number " + customer.getNumber() + " : " + customer.getName() +"\n";
		}
		return str;
	}
	
	public void edit(int number, Customer editedCustomer)
	{
		for(Customer customer : customerList)
		{
			if(customer.getNumber() == number)
			{
				customerList.set(customerList.indexOf(customer),editedCustomer);
			}
		}
	}
	
	public boolean delete(int number)
	{
		for(Customer customer : customerList)
		{
			if(customer.getNumber() == number)
			{
				customerList.remove(customer);
				return true;
			}
		}
		return false;
	}
	
	public void saveFiles()
	{
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path,false));
			bw.write("" + Customer.getNextNumber());
			bw.newLine();
			for(Customer customer : customerList)
			{
				Name name = customer.getName();
				bw.write(name.getTitle());
				bw.newLine();
				bw.write(name.getFirstName());
				bw.newLine();
				bw.write(name.getSurname());
				bw.newLine();
				bw.write(customer.getAddress());
				bw.newLine();
				bw.write(customer.getPhoneNumber());
				bw.newLine();
				bw.write(customer.getEmailAddress());
				bw.newLine();
				bw.write("" + customer.getNumber());
				bw.newLine();
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
