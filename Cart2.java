import java.util.ArrayList;

public class Cart2 {
    
    private ArrayList<CartItem> items = new ArrayList<CartItem>();

    public void add(MenuItem item, int quantity) {
        for (CartItem c : items) {
            if (c.getDesc().equals(item.getDesc())) {
                c.setQuantity(quantity + c.getQuanity());
                break;
            }
        }
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
            total += ( c.getQuanity() * c.getPrice() ) ;
        }
        return total;
    }

    public int getItemCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }
}
