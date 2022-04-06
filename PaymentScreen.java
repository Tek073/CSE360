import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PaymentScreen extends Screen {

    private JLabel message;
    private JButton back;
    private JButton submit;

    private JLabel amountValueLabel;
    private JTextField number;
    private JTextField expDate;
    private JTextField zipCode;

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public PaymentScreen() {
        message = new JLabel(
            "<html>" +
            "<p>&nbsp;</p>" +
            "<p><b><font size=+3>Payment Screen</font></b></p>" +
            "<p>Please enter payment details and place your order!</p><p>&nbsp;</p>" +
            "</html>");
        back = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Back</font></b></p>" +
            "</center></html>");
        submit = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Submit Order</font></b></p>" +
            "</center></html>");

        JLabel amountLabel = new JLabel("Order Total:");
        amountValueLabel = new JLabel(currencyFormat.format(Data.getData().getCurrentUser().getCart().getTotal()));
        
        JLabel numberLabel = new JLabel("Credit/Debit Card Number:");
        number = new JTextField(16);
        JLabel expDateLabel = new JLabel("Expiration date (mm/yy):");
        expDate = new JTextField(16);
        JLabel zipCodeLabel = new JLabel("5-digit zipcode:");
        zipCode = new JTextField(16);

        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 5, 10, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        form.add(amountLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        form.add(amountValueLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        form.add(numberLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        form.add(number, c);
        c.gridx = 0;
        c.gridy = 2;
        form.add(expDateLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        form.add(expDate, c);
        c.gridx = 0;
        c.gridy = 3;
        form.add(zipCodeLabel, c);
        c.gridx = 1;
        c.gridy = 3;
        form.add(zipCode, c);

        form.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), BorderFactory.createRaisedBevelBorder()));

        JPanel actions = new JPanel(new BorderLayout());
        actions.add(back, BorderLayout.WEST);
        actions.add(submit, BorderLayout.EAST);

        add(message, BorderLayout.PAGE_START);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        add(form, BorderLayout.CENTER);
        add(actions, BorderLayout.PAGE_END);

        back.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.showScreen(new OrderScreen());
                }
            }
        );

        submit.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Order2 order = Data.getData().placeOrder(
                        Data.getData().getCurrentUser().getUsername(),
                        new CreditCard2(number.getText(), expDate.getText(), zipCode.getText()),
                        null, // no coupon
                        Data.getData().getCurrentUser().getCart()
                    );
                    Data.getData().getCurrentUser().getCart().clear();
                    App.showScreen(new ConfirmationScreen(order));
                }
            }
        );

    }
    
}

