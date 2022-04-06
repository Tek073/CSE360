import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HomeScreen extends Screen  {

    private JLabel welcomeMsg;
    private JButton empLogin;
    private JButton custLogin;

    public HomeScreen() {
        welcomeMsg = new JLabel(
            "<html>" +
            "<p>&nbsp;</p><p>&nbsp;</p><p>Welcome to " + Data.getData().getRestaurantName() + "!</p><p>&nbsp;</p>" +
            "</html>");
        custLogin = new JButton(
            "<html><center>" +
            "<p><b><font size=+5>Start Your Order!</font></b></p>" +
            "</center></html>");
        empLogin = new JButton("<html><right>Employees: Login Here</right></html>");

        add(welcomeMsg, BorderLayout.PAGE_START);
        add(custLogin, BorderLayout.CENTER);
        add(empLogin, BorderLayout.PAGE_END);

        welcomeMsg.setHorizontalAlignment(SwingConstants.CENTER);
        empLogin.setHorizontalAlignment(SwingConstants.RIGHT);

        custLogin.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.showScreen(new LoginScreen());
                }
            }
        );

        empLogin.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.showScreen(new EmployeeLoginScreen());
                }
            }
        );
    }
}
