import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class CustomerScreen extends Screen {

    private JLabel message;
    private JPasswordField pwd;
    private JButton updatePwd;
    private JButton logout;
    private JButton neworder;

    public CustomerScreen() {
        message = new JLabel(
            "<html>" +
            "<p>&nbsp;</p>" +
            "<p><b><font size=+3>Customer Screen</font></b></p>" +
            "<p>Hello " + Data.getData().getCurrentUser().getUsername() + "! You can change your password and check the status of your orders</p><p>&nbsp;</p>" +
            "</html>");
        logout = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Logout</font></b></p>" +
            "</center></html>");
        neworder = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>New Order</font></b></p>" +
            "</center></html>");
        updatePwd = new JButton("Update");

        JLabel pwdLabel = new JLabel("Change Password:");
        pwd = new JPasswordField(12);
        pwd.setText(Data.getData().getCurrentUser().getPassword());

        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 5, 10, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        form.add(pwdLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        form.add(pwd, c);
        c.gridx = 2;
        c.gridy = 0;
        form.add(updatePwd, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;

        ArrayList<Order2> orders = Data.getData().getOrders(Data.getData().getCurrentUser().getUsername());
        int n = orders.size();
        if (n == 0) {
            form.add(new JLabel("You don't have any orders! Please click New Order to start a new one!"), c);
        } else {
            form.add(new JLabel("You have " + n + " orders!"), c);
            for (int i = 0; i < n; i++) {
                Order2 order = orders.get(i);
                int wait_minutes = Data.getData().getWaitTime(order);
                int wait_hours = wait_minutes / 60;
                wait_minutes = wait_minutes % 60;
                String waitTime = "" + wait_hours + "h " + wait_minutes + "m";
                c.gridy ++;
                JLabel label = new JLabel("Status: [" + order.getStatus() + "]     Expected Time: " + waitTime);
                label.setBorder(BorderFactory.createTitledBorder("Order: " + order.getNumber()));
                form.add(label, c);
            }
        }

        JPanel actions = new JPanel(new BorderLayout());
        actions.add(logout, BorderLayout.WEST);
        actions.add(neworder, BorderLayout.EAST);

        add(message, BorderLayout.PAGE_START);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane jsp = new JScrollPane(form);
        jsp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), BorderFactory.createRaisedBevelBorder()));
        add(jsp, BorderLayout.CENTER);
        add(actions, BorderLayout.PAGE_END);

        updatePwd.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String msg = "";
                    String p = new String(pwd.getPassword());
                    if (p.length() < 3) {
                        msg = "Password must be at least three characters long";
                    }
                    if (! msg.isEmpty()) {
                        JOptionPane.showMessageDialog(CustomerScreen.this, msg, "Sun Devil: Failed to update password", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Data.getData().getCurrentUser().changePassword(p);
                    JOptionPane.showMessageDialog(CustomerScreen.this, "Your password successfully changed!", "Sun Devil: Change Password", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        logout.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Data.getData().logout();
                    App.showScreen(new HomeScreen());
                }
            }
        );

        neworder.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.showScreen(new MenuScreen2());
                }
            }
        );

    }
    
}
