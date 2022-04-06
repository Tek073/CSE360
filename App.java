// ========================================================
// Class: CSE 360 Wednesday section
// Group: Wednesday 31
// Project: Restaurant menu
// Class: Main method for initial logic
// Note: global variables are made and used here for
// both the gui and the logic
// ========================================================

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	public static Application info;
    private static JFrame jf;
    public static void main(String[] args) throws Exception {
        jf = new JFrame("Restaurant Kiosk");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(700, 400);
        jf.setLocationRelativeTo(null);
        
        // preset some customers and menu items
        Customer customer1 = new Customer("JohnSmith","ilike360");
        Customer customer2 = new Customer("TamTam","iceCream");
        Customer customer3 = new Customer("username","1234");
        
        // preset employees
        Employee employee1 = new Employee("ceo240","123456",10);
        
        // preset menu items
        String[] hamburgerIng = {"patty","lettuce","cheese","bread"};
        Item hamburger = new Item("Hamburger", "Juicy Hamburger with your choice of toppings", 8, hamburgerIng);
        String[] frysIng = {"potato","oil"};
        Item frys = new Item("Frys", "Plain crispy frys", 4, frysIng);
        String[] chipsIng = {"patty","lettuce","cheese","bread"};
        Item chips = new Item("Chips", "Good Ol' fashioned chips", 8, chipsIng);
        String[] sodaIng = {"food coloring","some chemicals"};
        Item soda = new Item("Soda", "The best pop around", 2, sodaIng);
        
        // add all the presets into application
        info = new Application();
        info.customers.add(customer1);
        info.customers.add(customer2);
        info.customers.add(customer3);
        info.employees.add(employee1);
        info.menuitems.add(hamburger);
        info.menuitems.add(frys);
        info.menuitems.add(chips);
        info.menuitems.add(soda);
        
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jf.setContentPane(panel);
        showScreen(new HomeScreen());
    }

    public static void showScreen(Screen s) {
        jf.getContentPane().removeAll();
        jf.getContentPane().add(s);
        jf.setVisible(true);
    }
}
