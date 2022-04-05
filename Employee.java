import java.util.ArrayList;

public class Employee {
    int id;
    String firstname;
    String lastname;
    String username;
    String password;
    
    public Employee(String firstname, String lastname, int id, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void editItem (Item menuItem, String newDesc, String newName, int newPrice) {
        menuItem.setPrice(newPrice);
        menuItem.setDescription(newDesc);
        menuItem.setName(newName);
    }

    public void removeItem (Item menuItem, ArrayList<Item> menuList) {
        
    	int id = menuList.indexOf(menuItem);
    	menuList.remove(id);
    }

    public void addItem (Item menuItem, String name, String desc, int price
    		, ArrayList<Item> menuList, String[] ingredients) {
        menuItem = new Item(name, desc, price, ingredients);
        menuList.add(menuItem);
    }

    public void removeCustomer (Customer customer, ArrayList<Customer> customers) {
        customers.remove(customer);
    }
    
    /*
    public void giveCoupon (Coupon coupon, Customer customer) {
        customer.couponList.addCoupon(coupon);
    }

    public void removeCoupon(Coupon coupon, Customer customer) {
        Coupon couponToRemove = customer.getCoupon(coupon.getName());
        customer.removeCoupon(couponToRemove);
        coupon.setName("NULL");
        coupon.setDiscount(0.00);
    }
	*/
    
    
    
    public void completeOrder( ) {
        
    }

    public String getUsername() {
		return username;
	}

	protected void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}
}
