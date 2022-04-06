import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class MenuScreen2 extends Screen {

    private JLabel message;
    private JButton cancel;
    private JButton checkout;

    JSpinner qty[];

    public MenuScreen2() {
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

        JPanel form = new JPanel();
        qty = new JSpinner[Data.getData().getMenu().size()];
        int i = 0;
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        for (MenuItem mi : Data.getData().getMenu()) {
            JPanel panel = new JPanel(new BorderLayout());
            
            panel.add(new JLabel(mi.getDesc()), BorderLayout.NORTH);
            panel.add(new JLabel(mi.getIngradients()), BorderLayout.SOUTH);
            panel.add(new JLabel("$" + mi.getPrice()), BorderLayout.WEST);
            qty[i] = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
            JFormattedTextField tf = ((JSpinner.DefaultEditor) qty[i].getEditor()).getTextField();
            tf.setEditable(false);
            tf.setBackground(Color.lightGray);
            panel.add(qty[i], BorderLayout.EAST);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(mi.getImageFilename()).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_DEFAULT));
            panel.add(new JLabel(imageIcon));
            panel.setBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(20, 30, 20, 30),
                    BorderFactory.createCompoundBorder(
                        BorderFactory.createRaisedBevelBorder(),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    )
                )
            );

            form.add(panel);
            i++;
        }

        JPanel actions = new JPanel(new BorderLayout());
        actions.add(cancel, BorderLayout.WEST);
        actions.add(checkout, BorderLayout.EAST);

        add(message, BorderLayout.PAGE_START);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane jsp = new JScrollPane(form);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), BorderFactory.createRaisedBevelBorder()));
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


