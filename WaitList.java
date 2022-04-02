import java.util.LinkedList;
import java.util.Queue;

public class WaitList {

	private Queue<Customer> WaitList = new LinkedList<>();
	
	public Customer deque() 
	{
		return WaitList.remove();
	}
	
	public void enque(Customer newCustomer) 
	{
		WaitList.add(newCustomer);
	}
	
	public int customersAhead(Customer newCustomer)
	{
	    int counter = 0;
	    for (Customer find : WaitList) {
	        if (find == newCustomer) {
	            return counter;
	        }
	        else counter++;
	    }
		return counter; //counter customers ahead of newCustomer
	}
	
	
}
