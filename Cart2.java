import java.util.ArrayList;

public class Cart2 {
    
    private ArrayList<CartItem> items = new ArrayList<CartItem>();

    public void add(MenuItem item, int quantity) {
        for (CartItem c : items) {
            if (c.getDesc().equals(item.getDesc())) {
                c.setQuantity(quantity + c.getQuantity());
                return;
            }
        }
        items.add(new CartItem(item, quantity));
    }

    public boolean remove(MenuItem item) {
        CartItem found = null;
        for (CartItem c : items) {
            if (c.getDesc().equals(item.getDesc())) {
                found = c;
                break;
            }
        }
        if (found != null) {
            items.remove(found);
            return true;
        }
        return false;
    }

    public double getTotal() {
        double total = 0;
        for (CartItem c : items) {
            total += ( c.getQuantity() * c.getPrice() ) ;
        }
        return total;
    }

    public int getItemCount() {
        int total = 0;
        for (CartItem c : items) {
            total += c.getQuantity() ;
        }
        return total;
    }

    public void clear() {
        items.clear();
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }
}
