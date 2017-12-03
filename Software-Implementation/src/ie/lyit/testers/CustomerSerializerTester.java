package ie.lyit.testers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Name;
import ie.lyit.serialize.CustomerSerializer;
import ie.lyit.serialize.DAOCustomerSerializer;

public class CustomerSerializerTester {
	public static void main(String argv[])
	{
		DAOCustomerSerializer serializer = CustomerSerializer.getSerializer();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputString;
		boolean menue = true;
		
		while(menue)
		{
			System.out.println("Choose a Option.");
			System.out.println("1. Create");
			System.out.println("2. View");
			System.out.println("3. List");
			System.out.println("4. Edit");
			System.out.println("5. Delete");
			System.out.println("6. Close & Save");
			int option = 0;
			while(option == 0)
			{
				try {
					inputString = input.readLine();
					option = Integer.parseInt(inputString);
					if(option <= 0 || option > 6)
					{
						option = 0;
					}
				} catch (IOException e) {
					option = 0;
				}
			}
			
			switch(option)
			{
			
				case 1 :
				{
					String t = "",fn = "",sn = "",address = "",pNo = "",email = "";
					System.out.println("Type the titel :");
					while (t.equals(""))
					{
						try {
							t = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the forename :");
					while (fn.equals(""))
					{
						try {
							fn = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the surname :");
					while (sn.equals(""))
					{
						try {
							sn = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the address :");
					while (address.equals(""))
					{
						try {
							address = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the phone number :");
					while (pNo.equals(""))
					{
						try {
							pNo = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the e-mail address :");
					while (email.equals(""))
					{
						try {
							email = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					Customer customer = new Customer(t,fn,sn,address,pNo,email);
					serializer.create(customer);
					System.out.println("Customer created succesfully");
					break;
				}				
				case 2 : 
				{
					int number;
					System.out.println("Type in the customer number of the customer you want to view.");
					System.out.println("Enter \"e\" to get back to menue.");
					number = 0;
					while (number == 0)
					{
						try{
							String str = input.readLine();
							if(str.equals("e"))
								break;
							number = Integer.parseInt(str);
						}
						catch(NumberFormatException e)
						{
							System.out.println("Invalid Number.");
							number = 0;
						} 
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							number = 0;
						}
					}
					if(number == 0)
						break;
					Customer customer = serializer.view(number);
					
					if(customer != null)
					{
						System.out.println(customer);
					}else
					{
						System.out.println("Customer not found.");
					}
					
					break;
				}
				case 3 : 
				{
					System.out.println("Here is the List of Customers.");
					
					System.out.println(serializer.list());
					
					break;
				}
				case 4 : 
				{
					int number;
					System.out.println("Type in the customer number of the customer you want to edit.");
					System.out.println("Enter \"e\" to get back to menue.");
					number = 0;
					while (number == 0)
					{
						try{
							String str = input.readLine();
							if(str.equals("e"))
								break;
							number = Integer.parseInt(str);
						}
						catch(NumberFormatException e)
						{
							System.out.println("Invalid Number.");
							number = 0;
						} 
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							number = 0;
						}
					}
					
					if(number == 0)
						break;
					
					Customer customer = serializer.view(number);
					
					if(customer != null)
					{
						System.out.println(customer);
					}else
					{
						System.out.println("Customer not found.");
						break;
					}
					
					String t = "",fn = "",sn = "",address = "",pNo = "",email = "";
					System.out.println("Type the titel :");
					while (t.equals(""))
					{
						try {
							t = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the forename :");
					while (fn.equals(""))
					{
						try {
							fn = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the surname :");
					while (sn.equals(""))
					{
						try {
							sn = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the address :");
					while (address.equals(""))
					{
						try {
							address = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the phone number :");
					while (pNo.equals(""))
					{
						try {
							pNo = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Type the e-mail address :");
					while (email.equals(""))
					{
						try {
							email = input.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Name newName = new Name(t,fn,sn);
					customer.setName(newName);
					customer.setAddress(address);
					customer.setPhoneNumber(pNo);
					customer.setEmailAddress(email);
					serializer.edit(number, customer);
					System.out.println("Customer edited succesfully");
					break;
				}
				case 5 : 
				{
					int number;
					System.out.println("Type in the customer number of the customer you want to delete.");
					System.out.println("Enter \"e\" to get back to menue.");
					number = 0;
					while (number == 0)
					{
						try
						{
							String str = input.readLine();
							if(str.equals("e"))
								break;
							number = Integer.parseInt(str);
							if(number <= 0)
							{
								System.out.println("Invalid Number");
								number = 0;
							}
						}
						catch(NumberFormatException e)
						{
							System.out.println("Invalid Number.");
							number = 0;
						} 
						catch (IOException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							number = 0;
						}
					}
					if(number == 0)
						break;
					if(serializer.delete(number))
					{
						System.out.println("Customer deleted");
					}else
					{
						System.out.println("Customer not found.");
					}
					
					break;
				}
				case 6 : 
				{
					System.out.println("Have a nice Day.");
					serializer.saveFiles();
					menue = false;
					break;
				}
						
			}
			
		}
		
		
	}
}
