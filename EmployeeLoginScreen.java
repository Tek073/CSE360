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
import javax.swing.SwingUtilities;

public class EmployeeLoginScreen extends Screen {

    private JLabel message;
    private JTextField usr;
    private JPasswordField pwd;
    private JButton cancel;
    private JButton login;

    public EmployeeLoginScreen() {
        message = new JLabel(
            "<html>" +
            "<p>&nbsp;</p>" +
            "<p><b><font size=+3>Employee Login Screen</font></b></p>" +
            "<p>Please login to manage the menu and orders!</p><p>&nbsp;</p>" +
            "</html>");
        cancel = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Cancel</font></b></p>" +
            "</center></html>");
        login = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Login</font></b></p>" +
            "</center></html>");

        JLabel usrLabel = new JLabel("Username:");
        usr = new JTextField(12);
        JLabel pwdLabel = new JLabel("Password:");
        pwd = new JPasswordField(12);

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

        c.gridx = 1;
        c.gridy = 2;
        form.add(login, c);

        form.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), BorderFactory.createRaisedBevelBorder()));

        JPanel actions = new JPanel(new BorderLayout());
        actions.add(cancel, BorderLayout.WEST);

        add(message, BorderLayout.PAGE_START);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        add(form, BorderLayout.CENTER);
        add(actions, BorderLayout.PAGE_END);

        SwingUtilities.invokeLater( new Runnable() { 
            public void run() { 
                usr.requestFocus(); 
            } 
        } );
        usr.requestFocus();

        cancel.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.showScreen(new HomeScreen());
                }
            }
        );

        login.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String u = usr.getText().trim();
                    String p = new String(pwd.getPassword()).trim();
                    if (Data.getData().loginEmployee(u, p) == null) {
                        JOptionPane.showMessageDialog(EmployeeLoginScreen.this, new String[] {"Invalid Username/Password", "Don't have an accout? Please contact the store manager!"}, "Sun Devil: Failed to login", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    App.showScreen(new EmployeeScreen());
                }
            }
        );

    }
    
}
