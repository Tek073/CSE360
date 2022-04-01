// ========================================================
// Class: CSE 360 Wednesday section
// Group: Wednesday 31
// Project: Restaurant menu
// Class: CreditCard
// ========================================================

public class Order 
{
	public Item[] orderList;
	private CreditCard payment;
	private Coupon discount;		// only one coupon can be applied per order
	
	public Order()
	{
		this.orderList = null;
		this.payment = null;
		this.discount = null;
	}
	public Order(Cart purchases, CreditCard payment)
	{
		int size = purchases.getList().size();
		this.orderList = new Item[size];
		
		for(int i = 0; i < size; i++)
		{
			this.orderList[i] = purchases.getList().get(i);
		}
		this.payment = payment;
	}
	public Order(Cart purchases, CreditCard payment, Coupon discount)
	{
		int size = purchases.getList().size();
		this.orderList = new Item[size];
		
		for(int i = 0; i < size; i++)
		{
			this.orderList[i] = purchases.getList().get(i);
		}
		this.payment = payment;
		this.discount = discount;
	}
	public double totalCost()
	{
		double cost = 0;
		
		for(int i = 0; i < orderList.length; i++)
		{
			cost += orderList[i].getPrice();
		}
		
		if(discount != null)
		{
			double modifier = 1 - discount.getDiscount();
			cost = cost * modifier;
		}
		
		return cost;
	}
}
