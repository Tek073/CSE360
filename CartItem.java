public class CartItem extends MenuItem {
    private int quantity;

    public CartItem(MenuItem menuItem, int quantity) {
        super(menuItem.getDesc(), menuItem.getPrice(), menuItem.getPrepTime(), menuItem.getIngradients(), menuItem.getImageFilename());
        this.quantity = quantity;
    }

    public int getQuanity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
