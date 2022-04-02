public class Employee {
    int id;
    String firstname;
    String lastname;
    
    public Employee(String firstname, String lastname, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public void editItem (Item menuItem, String newDesc, String newName, int newPrice) {
        menuItem.setPrice(newPrice);
        menuItem.setDesc(newDesc);
        menuItem.setName(newName);
    }

    public void removeItem (Item menuItem) {
        menuItem.remove();
    }

    public void addItem (Item menuItem, String name, String desc, int price) {
        menuItem = new Item(name, desc, price);
    }

    public void removeCustomer (Customer customer) {
        customer.remove();
    }

    public void giveCoupon (Coupon coupon, Customer customer) {
        customer.couponList.addCoupon(coupon);
    }

    public void removeCoupon(Coupon coupon, Customer customer) {
        Coupon couponToRemove = customer.getCoupon(coupon.getName());
        customer.removeCoupon(couponToRemove);
        coupon.setName("NULL");
        coupon.setDiscount(0.00);
    }

    public void completeOrder( ) {
        
    }
}
