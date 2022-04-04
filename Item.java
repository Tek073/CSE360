// ========================================================
// Class: CSE 360 Wednesday section
// Group: Wednesday 31
// Project: Restaurant menu
// Class: Item for menu items
// ========================================================


import java.util.ArrayList;

public class Item 
{
	private String name;
	private String description;
	private int price;
	private int prepTime;
	private ArrayList<String> ingredients;
	
	
	public Item()
	{
		this.name = null;
		this.description = null;
		this.price = 0;
		this.ingredients = new ArrayList<String>();
	}
	public Item(String name, String description, int price, String[] list)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		
		this.ingredients = new ArrayList<String>();
		
		for(int i = 0; i < list.length; i++)
		{
			this.ingredients.add(list[0]);
		}
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	public int getPrepTime() 
	{
		return prepTime;
	}
	public void setPrepTime(int prepTime) 
	{
		this.prepTime = prepTime;
	}
	public String getIngredients()
	{
		String listIngredients = "";
		for(int i = 0; i < ingredients.size(); i++)
		{
			listIngredients += ingredients.get(i);
			if(i != ingredients.size() - 1)
			{
				listIngredients += ", ";
			}
		}
		
		return listIngredients;
	}
	// no setter for Ingredients 
	
}
