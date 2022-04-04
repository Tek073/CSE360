import java.util.ArrayList;

public class Application {

	public ArrayList<Employee> employees;
	public ArrayList<Customer> customers;
	public ArrayList<Item> menuitems;
	public WaitList waitlist;
	
	public Application(WaitList wl) {
		waitlist = wl;
	}
	
	public Application() {
		menuitems = new ArrayList<Item>();
		
		//menuitems.add( new Item
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
	
}
