import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

    private static JFrame jf;
    public static void main(String[] args) throws Exception {
        jf = new JFrame(Data.getData().getRestaurantName() + " Kiosk");
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
