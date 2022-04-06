import java.util.ArrayList;

public class User {

    public User(String usr, String pwd, String r) {
        username = usr;
        password = pwd;
        role = r;
        if (role.equals("Customer")) {
            addCoupon(new Coupon2("NEW CUST", 20));
        }
    }

    private String username; // unique
    private String password;
    private String role; // customer or employee

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String pwd) {
        return password.equals(pwd);
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String pwd) {
        password = pwd;
    }

    public String getRole() {
        return role;
    }

    // Cart - one for each user
    private Cart2 cart = new Cart2();
    public Cart2 getCart() {
        return cart;
    }

    // User coupons - never expire
    private ArrayList<Coupon2> coupons = new ArrayList<Coupon2>();
    public void addCoupon(Coupon2 c) {
        coupons.add(c);
    }
    public void removeCoupon(String code) {
        Coupon2 found = null;
        for (Coupon2 c : coupons) {
            if (c.getCode().equals(code)) {
                found = c;
                break;
            }
        }
        if (found != null) {
            coupons.remove(found);
        }
    }
    public ArrayList<Coupon2> getCoupons() {
        return coupons;
    }

    // Credit Card - one per user
    private CreditCard2 creditCard;
    public void storeCreditCard(CreditCard2 c) {
        creditCard = c;
    }
    public void removeCreditCard() {
        creditCard = null;
    }
    public CreditCard2 getCreditCard() {
        return creditCard;
    }
    
}
