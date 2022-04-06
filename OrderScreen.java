import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OrderScreen extends Screen {

    private JLabel message;
    private JButton back;
    private JButton pay;

    private JLabel totalLabel;

    private JSpinner qty[];

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public OrderScreen() {
        message = new JLabel(
            "<html>" +
            "<p>&nbsp;</p>" +
            "<p><b><font size=+3>Order Screen</font></b></p>" +
            "<p>Please verify your order and make payment!</p><p>&nbsp;</p>" +
            "</html>");
        back = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Back</font></b></p>" +
            "</center></html>");
        pay = new JButton(
            "<html><center>" +
            "<p><b><font size=+1>Pay</font></b></p>" +
            "</center></html>");

        // Add cart items
        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 5, 10, 5);

        Cart2 cart = Data.getData().getCurrentUser().getCart();
        ArrayList<CartItem> items = cart.getItems();
        int n = items.size();
        qty = new JSpinner[n];

        for (int i = 0; i < n; i++) {
            CartItem item = items.get(i);
            c.gridy = i;

            c.gridx = 0;
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(item.getImageFilename()).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));
            form.add(new JLabel(imageIcon), c);

            c.gridx ++;

            form.add(new JLabel(item.getDesc()), c);

            c.gridx ++;
            form.add(new JLabel(currencyFormat.format(item.getPrice())), c);

            c.gridx ++;
            qty[i] = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
            JFormattedTextField tf = ((JSpinner.DefaultEditor) qty[i].getEditor()).getTextField();
            tf.setEditable(false);
            tf.setBackground(Color.lightGray);
            qty[i].setValue(item.getQuantity());
            form.add(qty[i], c);
            
            qty[i].addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    updateTotal();
                    
                }
                
            });
        }

        JPanel actions = new JPanel(new BorderLayout());
        actions.add(back, BorderLayout.WEST);
        actions.add(pay, BorderLayout.EAST);
        totalLabel = new JLabel("Order Total: " + currencyFormat.format(Data.getData().getCurrentUser().getCart().getTotal()));
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        actions.add(totalLabel);

        add(message, BorderLayout.PAGE_START);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane jsp = new JScrollPane(form);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), BorderFactory.createRaisedBevelBorder()));
        add(jsp, BorderLayout.CENTER);
        add(actions, BorderLayout.PAGE_END);

        back.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    updateCart();
                    App.showScreen(new MenuScreen2());
                }
            }
        );

        pay.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int total = 0;
                    for (int i = 0; i < qty.length; i++) {
                        total += ((Integer) qty[i].getValue());
                    }
                    if (total == 0) {
                        JOptionPane.showMessageDialog(OrderScreen.this, "Shopping cart is empy, please select items to purchase!", "Sun Devil: Empty order", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    updateCart();
                    App.showScreen(new PaymentScreen());
                }
            }
        );

    }

    private void updateCart() {
        ArrayList<CartItem> items = Data.getData().getCurrentUser().getCart().getItems();
        ArrayList<CartItem> items_to_remove = new ArrayList<CartItem>();
        for (int i = 0; i < qty.length; i++) {
            int q = (Integer) qty[i].getValue();
            items.get(i).setQuantity(q);
            if (q == 0) {
                items_to_remove.add(items.get(i));
            }
        }
        for (CartItem item : items_to_remove) {
            items.remove(item);
        }
    }

    private void updateTotal() {
        ArrayList<CartItem> items = Data.getData().getCurrentUser().getCart().getItems();
        double total = 0;
        for (int i = 0; i < qty.length; i++) {
            int q = (Integer) qty[i].getValue();
            total += (items.get(i).getPrice() * q);
        }
        
        totalLabel.setText("Order Total: " + currencyFormat.format(total));
    }
    
}

