// ========================================================
// Class: CSE 360 Wednesday section
// Group: Wednesday 31
// Project: Restaurant menu
// Class: Main method to run the logic
// ========================================================

import javax.swing.*;
import java.awt.*;

public class main 
{

	public static void main(String[] args) 
	{
		// basically the frame "theFrame" will be changing states when
		// buttons are pressed. Also things like a cart will change
		// when buttons are pressed. Entire program hinges on presssing
		// buttons
		
		// Initial initialization of program presets
		// stuff like premade user classes and menu items will be here
		
		
		// end of initialization
		
		// set up the frame to hold different panels
		JFrame theFrame = new JFrame();
		theFrame.setSize(new Dimension(500,700));
		theFrame.setTitle("Restaurant Menu");
	    
	    //
		// START OF LOGIN PANE
		//
	    JPanel loginScreen = new JPanel();
	    SpringLayout loginLayout = new SpringLayout();
	    loginScreen.setLayout(loginLayout);
	    
	    // make components to go into the panel
	    JLabel loginText = new JLabel("Login: ");
	    loginText.setFont(new Font("Calibri", Font.PLAIN, 30));
	    JTextField inputUser = new JTextField("<UserName>",20);
	    JLabel passwordText = new JLabel("Password: ");
	    passwordText.setFont(new Font("Calibri", Font.PLAIN, 30));
	    JTextField inputPassword = new JTextField("<UserName>",20);
	    JLabel restaurantNameLogin = new JLabel("Wednesday the 31st");
	    restaurantNameLogin.setFont(new Font("Dialog", Font.BOLD, 35));
	    
	    // one button to login and one to continue as a guest
	    JButton loginButton = new JButton("Login");
	    loginButton.setPreferredSize(new Dimension(140,35));
	    JButton guestButton = new JButton("Guest Login");
	    guestButton.setPreferredSize(new Dimension(140,35));
	    
	    
	    loginScreen.setSize(new Dimension(500,700));
	    loginScreen.add(loginText);
	    loginScreen.add(inputUser);
	    loginScreen.add(passwordText);
	    loginScreen.add(inputPassword);
	    loginScreen.add(restaurantNameLogin);
	    loginScreen.add(loginButton);
	    loginScreen.add(guestButton);
	    
	    
	    // put them in the panel correctly
	    loginLayout.putConstraint(SpringLayout.WEST, loginText,10, SpringLayout.WEST, loginScreen);
	    loginLayout.putConstraint(SpringLayout.NORTH, loginText,250, SpringLayout.NORTH, loginScreen);
	    loginLayout.putConstraint(SpringLayout.WEST, inputUser,150, SpringLayout.WEST, loginScreen);
	    loginLayout.putConstraint(SpringLayout.NORTH, inputUser,260, SpringLayout.NORTH, loginScreen);
	    
	    loginLayout.putConstraint(SpringLayout.WEST, passwordText,10, SpringLayout.WEST, loginScreen);
	    loginLayout.putConstraint(SpringLayout.NORTH, passwordText,300, SpringLayout.NORTH, loginScreen);
	    loginLayout.putConstraint(SpringLayout.WEST, inputPassword,150, SpringLayout.WEST, loginScreen);
	    loginLayout.putConstraint(SpringLayout.NORTH, inputPassword,305, SpringLayout.NORTH, loginScreen);
	    
	    // input the buttons onto panel
	    loginLayout.putConstraint(SpringLayout.WEST, loginButton,150, SpringLayout.WEST, loginScreen);
	    loginLayout.putConstraint(SpringLayout.NORTH, loginButton,500, SpringLayout.NORTH, loginScreen);
	    loginLayout.putConstraint(SpringLayout.WEST, guestButton,150, SpringLayout.WEST, loginScreen);
	    loginLayout.putConstraint(SpringLayout.NORTH, guestButton,550, SpringLayout.NORTH, loginScreen);
	    //
	    // END OF LOGIN PANE
	    //
	    
	    
	    //
	    // START OF HOME PAGE PANE
	    //
	    
	    JPanel homeScreen = new JPanel();
	    SpringLayout homeLayout = new SpringLayout();
	    homeScreen.setLayout(homeLayout);
	    
	    // make components to go into the panel
	    
	    JLabel restaurantNameHome = new JLabel("Wednesday the 31st");
	    restaurantNameHome.setFont(new Font("Dialog", Font.BOLD, 35));
	    
	    
	    
	    //
	    // END OF HOME PAGE PANE
	    //
	    
	    // testers to see if the panes are working
	    // moving forward the setContentPane's will be attached to buttons
	    theFrame.setContentPane(loginScreen);
	    theFrame.setVisible(true);
	    
	    
	}

}
