// ========================================================
// Class: CSE 360 Wednesday section
// Group: Wednesday 31
// Project: Restaurant menu
// Class: CreditCard
// ========================================================

public class CreditCard 
{
	
	private String name;
	private int number;
	
	public CreditCard()
	{
		this.name = null;
		this.number = -1;
	}
	public CreditCard(String name, int number)
	{
		this.name = name;
		this.number = number;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getNumber() 
	{
		return number;
	}
	public void setNumber(int number) 
	{
		this.number = number;
	}
	
	
}
