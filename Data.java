import java.util.ArrayList;

public class Data {

    private static Data data = new Data();
    public static Data getData() {
        return data;
    }

    private String restaurantName = "Sun Devil Restaurant";
    public String getRestaurantName() {
        return restaurantName;
    }

    // Initial default data
    private Data() {

        users.add(new User("abe", "lincoln", "Employee"));
        users.add(new User("bill", "clinton", "Customer"));
        users.add(new User("abc", "123", "Customer"));

        menu.add(new MenuItem("Bocca Burger",           7.50, 10, "Veg patty, Cheese, Lettuce, Tomoto, Mayo, Mustard", "bocca.jpg"));
        menu.add(new MenuItem("Grilled Chicker Burger", 8.50, 15, "Chicken patty, Cheese, Lettuce, Tomoto, Mayo, Mustard", "chickb.jpg"));
        menu.add(new MenuItem("Caesar Salad",           7.50, 10, "Salad, Ranch, Croutons, Cheese", "caesar.jpg"));
        menu.add(new MenuItem("Garden Fresh Salad",     8.50, 10, "Lettuce, Tomoto, Olives, Onion, Ranch, Croutons, Cheese", "garden.jpg"));
        menu.add(new MenuItem("French fries",           2.49, 1, "Fries, Lightly salted", "fries.jpg"));
        menu.add(new MenuItem("Chips",                  1.49, 1, "Kettle cooked, Potato chips", "chips.jpg"));
        menu.add(new MenuItem("Coke",                   1.99, 1, "Bottled soda", "coke.jpg"));
    }

    // User management
    private ArrayList<User> users = new ArrayList<User>();
    private User currentUser = null; // currently logged in customer/employee

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean addUser(String u, String p, String r) {
        for (User user : users) {
            if (user.getUsername().equals(u)) {
                return false; // username taken by another user
            }
        }
        users.add(new User(u, p, r));
        return true;
    }
    public User loginCustomer(String u, String p) {
        User user = getUser(u, p);
        if (user != null) {
            if (user.getRole().equals("Customer")) {
                currentUser = user;
                return user;
            }
        }
        return null;
    }
    public User loginEmployee(String u, String p) {
        User user = getUser(u, p);
        if (user != null) {
            if (user.getRole().equals("Employee")) {
                currentUser = user;
                return user;
            }
        }
        return null;
    }
    private User getUser(String u, String p) {
        for (User user : users) {
            if (user.getUsername().equals(u)) {
                if (! user.checkPassword(p)) {
                    return null;
                }
                return user;
            }
        }
        return null;
    }
    public void logout() {
        currentUser = null;
    }

    // Menu management
    private ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
    public boolean addMenuItem(MenuItem item) {
        for (MenuItem m : menu) {
            if (m.getDesc().equals(item.getDesc())) {
                return false; // an item with that description already exists in the menu
            }
        }
        menu.add(item);
        return true;
    }
    public boolean removeMenuItem(MenuItem item) {
        MenuItem found = null;
        for (MenuItem m : menu) {
            if (m.getDesc().equals(item.getDesc())) {
                found = m;
                break;
            }
        }
        if (found != null) {
            menu.remove(found);
            return true;
        }
        return false;
    }
    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    // Order management
    private ArrayList<Order2> orders = new ArrayList<Order2>();
    public ArrayList<Order2> getOrders() {
        return orders;
    }
    public ArrayList<Order2> getOrders(String username) {
        ArrayList<Order2> ret = new ArrayList<Order2>();
        for (Order2 order : orders) {
            if (order.getUsername().equals(username)) {
                ret.add(order);
            }
        }
        return ret;
    }
    public Order2 placeOrder(String username, CreditCard2 card, Coupon2 coupon, Cart2 cart) {
        // Find the next order number
        int num = 100;
        for (Order2 o : orders) {
            if (o.getNumber() > num) {
                num = o.getNumber();
            }
        }
        num += 10;
        Order2 order = new Order2(username, card, coupon, cart, num);
        orders.add(order);
        return order;
    }
    public int numberOfOrdersBefore(Order2 order) {
        int count = 0;
        for (Order2 o : orders) {
            if (o.getNumber() < order.getNumber() && o.getStatus().equals("Completed") == false) {
                count++;
            }
        }
        return count;
    }
    public int getWaitTime(Order2 order) {
        if (order.getStatus().equals("Completed")) {
            return 0;
        }
        int minutes = 0;
        for (Order2 o : orders) {
            if (o.getNumber() < order.getNumber() && o.getStatus().equals("Completed") == false) {
                minutes += o.getTotalPrepTime();
            }
        }
        return minutes + order.getTotalPrepTime();
    }

}
