import java.util.ArrayList;

public class Application {

	public ArrayList<Employee> employees;
	public ArrayList<Customer> customers;
	public ArrayList<Item> menuitems;
	public WaitList waitlist;
	public Customer theCustomer;
	
	public Application(WaitList wl) {
		waitlist = wl;
	}
	
	public Application() {
		menuitems = new ArrayList<Item>();
		customers = new ArrayList<Customer>();
		employees = new ArrayList<Employee>();
		
		//menuitems.add( new Item
	}
	
	
	public void addCustomer(Customer input)
	{
		customers.add(input);
	}
	public void addItem(Item input)
	{
		menuitems.add(input);
	}
	public void addEmployee(Employee input)
	{
		employees.add(input);
	}
	
	public Item getItem(int index) {
		return menuitems.get(index);
	}
	
	public int getSize() {
		return menuitems.size();
	}
	
	
	public int closeDown() 
	{
		return -1;
	}

	public int getWaitTime() 
	{
		int total = 0;
		for(int i = 0; i < getSize(); i++) {
			total += getItem(i).getPrepTime();
		}
		return total;
	}
	
	public boolean checkUserPassCustomer(String username, String password)
	{
		int size = customers.size();
		for(int i = 0; i < size; i++)
		{
			
			if(customers.get(i).username.equals(username))
			{
				if(customers.get(i).getPassword().equals(password))
				{
					theCustomer = customers.get(i);
					return true;
				}
			}
		}
		System.out.println("yo");
		// all usernames and passwords checked
		return false;
	}
	
	public boolean checkUserPassEmployee(String username, String password)
	{
		
		int size = employees.size();
		for(int i = 0; i < size; i++)
		{
			if(employees.get(i).username.equals(username))
			{
				if(employees.get(i).getPassword().equals(password))
				{
					return true;
				}
			}
		}
		
		// all usernames and passwords checked
		return false;
	}
	
}
