// ========================================================
// Class: CSE 360 Wednesday section
// Group: Wednesday 31
// Project: Restaurant menu
// Class: Cart
// ========================================================

import java.util.ArrayList;

public class Cart 
{
	private ArrayList<Item> list;
	
	public Cart()
	{
		list = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getList()
	{
		return list;
	}
	
	public void addItem(Item input)
	{
		list.add(input);
	}
	public void removeItem(int itemNum)
	{
		list.remove(itemNum);
	}
	
	
}
