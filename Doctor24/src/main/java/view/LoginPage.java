package view;

import repository.PacientRepository;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
/**
 * Pagina login
 */
public class LoginPage {
	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	/**
	 * Constructor neparametrizabil login
	 */
	public LoginPage() {
		frame = new JFrame("Login");
		frame.getContentPane().setBackground(new Color(0, 10, 128));
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameLabel.setBounds(42,150,104,25);
		frame.getContentPane().add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		usernameField.setBounds(156,141,235,45);
		frame.getContentPane().add(usernameField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordLabel.setBounds(42,224,104,25);
		frame.getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(156,215,235,45);
		frame.getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("Conectare");
		loginButton.setBackground(Color.WHITE);
		loginButton.setForeground(new Color(0, 10, 128));
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		loginButton.setBounds(54,349,153,29);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("Inregistrare");
		registerButton.setBackground(Color.WHITE);
		registerButton.setForeground(new Color(0, 10, 128));
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		registerButton.setBounds(275,349,153,29);
		frame.getContentPane().add(registerButton);
		
		JLabel lblNewLabel = new JLabel("DOCTOR24");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(99, 33, 282, 64);
		frame.getContentPane().add(lblNewLabel);
		

		 loginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String username = usernameField.getText();
	                String password = String.valueOf(passwordField.getPassword());

	                if (PacientRepository.validateLogin(username, password)) {
	                    JOptionPane.showMessageDialog(frame, "Login cu succes!");
	                    frame.dispose();
	                    new MainPage(username);
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Username sa parola gresite.");
	                }
	            }
	     });
		 

		 registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new RegisterPage();
				
			}
		});
			
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
	        try {
	            LoginPage login = new LoginPage(); 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
	}
}
