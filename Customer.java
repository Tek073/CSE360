public class Customer {
    private Cart cart;
    private Coupon[] couponList;
    private Order order;
    private boolean orderMade;
    private CreditCard cardOnFile;
    public String firstname;
    public String lastname;
    public String username;
    private String password;

    public Customer (String username, String password) {
        this.username = username;
        this.password = password;
    }

    private void remove() {
        this.firstname = " ";
        this.lastname = " ";
    }

    public void addToCart (Item menuItem, Cart currentCart) {
        currentCart.addItem(menuItem);
    }

    /*public void removeFromCart (Item menuItem, Cart currentCart) {
        currentCart.removeItem(menuItem);
    }*/

    public void checkOut() {
        this.orderMade = true;
        this.order = new Order(this.cart, this.cardOnFile);
    }

    public Coupon getCoupon (String couponName) {
        for (int i = 0; i < this.couponList.length; i++) {
            if (this.couponList[i].equals(couponName)) return this.couponList[i];
        }
        System.out.println("Coupon not Found!");
        return null;
    }
    // cutting out coupons just to test functionality
    /*
    public Coupon[] addCoupon (Coupon coupon) {
        Coupon newList[] = new Coupon[this.couponList.length() + 1];
        for (int i = 0; i < this.couponList.length(); i++) {
            newList[i] = this.couponList[i];
        }
        newList[this.couponList.length()] = coupon;
        return newList;
    }

    //dont know if i did this right
    
    public Coupon[] removeCoupon (Coupon coupon) {
        Coupon newList[] = new Coupon[this.couponList.lenght() - 1];
        Coupon couponToRemove = this.couponList.getCoupon(coupon);
        for (int i = 0; i < this.couponList.length; i++) {
            if (!(this.couponList[i].equals(couponToRemove))) {
                newList[i] = this.couponList[i];
            }
        }
        return newList;
    }*/

    public boolean getOrderStatus () {
        return this.orderMade;
    }

    public CreditCard getCreditCard() {
        return this.cardOnFile;
    }

    public void setCreditCard (String name, int number, int date) {
        this.cardOnFile.setName(name);
        this.cardOnFile.setNumber(number);
        this.cardOnFile.setDate(date);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}
    
    
}
