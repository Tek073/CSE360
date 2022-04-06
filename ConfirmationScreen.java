import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConfirmationScreen extends Screen {

    private JLabel message;
    private JTextField orderNum;
    private JTextField waitTime;
    private JTextField couponCode;
    private JButton ok;

    public ConfirmationScreen(Order2 order) {
        message = new JLabel(
            "<html>" +
            "<p>&nbsp;</p>" +
            "<p><b><font size=+3>Thank you</font></b></p>" +
            "<p>Please note your order number and wait time!</p><p>&nbsp;</p>" +
            "</html>");
        ok = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>OK</font></b></p>" +
            "</center></html>");

        JLabel orderNumLabel = new JLabel("Order Number:");
        orderNum = new JTextField("" + order.getNumber());
        orderNum.setEditable(false);
        orderNum.setBackground(Color.lightGray);
        JLabel waitLabel = new JLabel("Your expected wait time:");
        int wait_minutes = Data.getData().getWaitTime(order);
        int wait_hours = wait_minutes / 60;
        wait_minutes = wait_minutes % 60;
        waitTime = new JTextField("" + wait_hours + "h " + wait_minutes + "m");
        waitTime.setEditable(false);
        waitTime.setBackground(Color.lightGray);
        JLabel couponLabel = new JLabel("Your 20% off coupon code:");
        couponCode = new JTextField("ABC20");
        couponCode.setEditable(false);
        couponCode.setBackground(Color.lightGray);

        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 5, 10, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        form.add(orderNumLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        form.add(orderNum, c);
        c.gridx = 0;
        c.gridy = 1;
        form.add(waitLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        form.add(waitTime, c);
        c.gridx = 0;
        c.gridy = 2;
        form.add(couponLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        form.add(couponCode, c);

        form.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), BorderFactory.createRaisedBevelBorder()));

        JPanel actions = new JPanel(new BorderLayout());
        // actions.add(cancel, BorderLayout.WEST);
        actions.add(ok, BorderLayout.EAST);

        add(message, BorderLayout.PAGE_START);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        add(form, BorderLayout.CENTER);
        add(actions, BorderLayout.PAGE_END);

        ok.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.showScreen(new CustomerScreen());
                }
            }
        );

    }
    
}

