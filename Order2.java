import java.util.ArrayList;

public class Order2 {
    private String username;
    CreditCard2 crediCard;
    Coupon2 coupon;
    private int number;
    private String status;
    private ArrayList<CartItem> items = new ArrayList<CartItem>();
    public Order2(String username, CreditCard2 card, Coupon2 coupon, Cart2 cart, int num) {
        this.username = username;
        this.crediCard = card;
        this.coupon = coupon;
        for (CartItem c : cart.getItems()) {
            items.add(c);
        }
        number = num;
        status = "Placed";
    }

    public String getUsername() {
        return username;
    }

    public double getDiscount() {
        return coupon == null ? 0 : getTotal() * coupon.getDiscount() / 100.0;
    }

    public double getTotal() {
        double total = 0;
        for (CartItem c : items) {
            total += ( c.getQuantity() * c.getPrice() ) ;
        }
        return total;
    }

    public double getAmount() {
        return getTotal() - getDiscount();
    }

    public int getTotalPrepTime() {
        int total = 0;
        for (CartItem c : items) {
            total += ( c.getQuantity() * c.getPrepTime() ) ;
        }
        return total;
    }

    public int getItemCount() {
        return items.size();
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public int getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
