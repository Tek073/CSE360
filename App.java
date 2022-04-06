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
