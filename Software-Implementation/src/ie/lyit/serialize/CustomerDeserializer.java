package ie.lyit.serialize;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ie.lyit.hotel.Customer;

public class CustomerDeserializer {
	
	public CustomerDeserializer()
	{
		
	}
	
	public ArrayList<Customer> loadFile(File path){
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			boolean readOnce = false;
			int nextNumber = 0;
			while(br.ready())
			{
				String t;
				String fn;
				String sn;
				
				String address;
				String phonenumber;
				String email;
				
				int number;
				
				if(!readOnce)
				{
					nextNumber = Integer.parseInt(br.readLine());
					readOnce = true;
				}
				
				t = br.readLine();
				fn = br.readLine();
				sn = br.readLine();
				
				address = br.readLine();
				phonenumber = br.readLine();
				email = br.readLine();
				number = Integer.parseInt(br.readLine());
				br.readLine();
				
				Customer customer = new Customer(t,fn,sn,address,phonenumber,email,number);
				customerList.add(customer);
			}
			Customer.setNextNumber(nextNumber);
		} catch (IOException e) {
			System.err.println("No Data found creating new Save File...");
		} catch(NumberFormatException e){
			System.err.println("Error while reading Data/ Data corrupted");
			System.err.println("New File will be created.");
		}
			
		
		
		
		return customerList;
	}
	
}
