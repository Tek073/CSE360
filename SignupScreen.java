import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignupScreen extends Screen {

    private JLabel message;
    private JTextField usr;
    private JPasswordField pwd;
    private JPasswordField pwd2;
    private JButton cancel;
    private JButton signup;

    public SignupScreen() {
        message = new JLabel(
            "<html>" +
            "<p>&nbsp;</p>" +
            "<p><b><font size=+3>Signup Screen</font></b></p>" +
            "<p>Please signup below to create an account!</p><p>&nbsp;</p>" +
            "</html>");
        cancel = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Cancel</font></b></p>" +
            "</center></html>");
        signup = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Create Account</font></b></p>" +
            "</center></html>");

        JLabel usrLabel = new JLabel("Username:");
        usr = new JTextField(12);
        JLabel pwdLabel = new JLabel("Password:");
        pwd = new JPasswordField(12);
        JLabel pwd2Label = new JLabel("Confirm Password:");
        pwd2 = new JPasswordField(12);

        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 5, 10, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        form.add(usrLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        form.add(usr, c);
        c.gridx = 0;
        c.gridy = 1;
        form.add(pwdLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        form.add(pwd, c);
        c.gridx = 0;
        c.gridy = 2;
        form.add(pwd2Label, c);
        c.gridx = 1;
        c.gridy = 2;
        form.add(pwd2, c);

        c.gridx = 1;
        c.gridy = 3;
        form.add(signup, c);

        form.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), BorderFactory.createRaisedBevelBorder()));

        JPanel actions = new JPanel(new BorderLayout());
        actions.add(cancel, BorderLayout.WEST);
        // actions.add(signup, BorderLayout.EAST);

        add(message, BorderLayout.PAGE_START);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        add(form, BorderLayout.CENTER);
        add(actions, BorderLayout.PAGE_END);

        cancel.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.showScreen(new HomeScreen());
                }
            }
        );

        signup.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                	String username = usr.getText();
                	String password = pwd.getText();
                	String confirmPassword = pwd2.getText();
                	
                	
                	boolean ifTrue = password.equals(confirmPassword);
                	
                	// if these two are equal then add user into application data base
                	if(ifTrue)
                	{
                		Customer nextCustomer = new Customer(username, password);
                		App.info.theCustomer = nextCustomer;
                		App.info.customers.add(nextCustomer);
                		
                		App.showScreen(new MenuScreen());
                	}
                	
                    
                }
            }
        );

    }
    
}

