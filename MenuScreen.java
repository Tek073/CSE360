import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class MenuScreen extends Screen {

    private JLabel message;
    private JButton cancel;
    private JButton checkout;

    public MenuScreen() {
        message = new JLabel(
            "<html>" +
            "<p>&nbsp;</p>" +
            "<p><b><font size=+3>Restaurant Menu</font></b></p>" +
            "<p>Please add items to your order!</p><p>&nbsp;</p>" +
            "</html>");
        cancel = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Cancel</font></b></p>" +
            "</center></html>");
        checkout = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Checkout</font></b></p>" +
            "</center></html>");

        // Define menu
        int nitems = 4;
        String[] descStrings = new String[] {"Salad", "Burger", "Soda", "Chips"};
        String[] priceStrings = new String[] {"$5.50", "$8.50", "$0.99", "$1.99"};

        // Create menu components (item descriptions, unit prices, and quantities)
        JLabel[] descriptions = new JLabel[nitems];
        JTextField[] prices = new JTextField[nitems];
        JSpinner[] quantities = new JSpinner[nitems];
        for (int i = 0; i < nitems; i++) {

            descriptions[i] = new JLabel(descStrings[i]);
            prices[i] = new JTextField(priceStrings[i]);
            prices[i].setEditable(false);
            prices[i].setBackground(Color.lightGray);
            quantities[i] = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
            JFormattedTextField tf = ((JSpinner.DefaultEditor) quantities[i].getEditor()).getTextField();
            tf.setEditable(false);
            tf.setBackground(Color.lightGray);
        }

        // Add menu items
        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 5, 10, 5);

        for (int i = 0; i < nitems; i++) {
            c.gridy = i;

            c.gridx = 0;
            form.add(descriptions[i], c);

            c.gridx = 1;
            form.add(prices[i], c);

            c.gridx = 2;
            form.add(quantities[i], c);
        }

        form.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), BorderFactory.createRaisedBevelBorder()));

        JPanel actions = new JPanel(new BorderLayout());
        actions.add(cancel, BorderLayout.WEST);
        actions.add(checkout, BorderLayout.EAST);

        add(message, BorderLayout.PAGE_START);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane jsp = new JScrollPane(form);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jsp, BorderLayout.CENTER);
        add(actions, BorderLayout.PAGE_END);

        cancel.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.showScreen(new HomeScreen());
                }
            }
        );

        checkout.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    App.showScreen(new OrderScreen());
                }
            }
        );

    }
    
}


