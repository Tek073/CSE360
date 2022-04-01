// ========================================================
// Class: CSE 360 Wednesday section
// Group: Wednesday 31
// Project: Restaurant menu
// Class: CreditCard
// ========================================================


public class Coupon 
{
	private String name;
	private double discount;
	
	public Coupon()
	{
		this.name = "Generic Coupon";
		this.discount = 0.05;
	}
	public Coupon(String name, double discount)
	{
		this.name = name;
		this.discount = discount;
	}
	
	public String getName() 
	{
		return name;
	}
	public double getDiscount() 
	{
		return discount;
	}
	
	
	
}
