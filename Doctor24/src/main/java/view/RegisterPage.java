package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import obiecte.Pacient;
import obiecte.Particularitati;
import repository.PacientRepository;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * Pagina register 
 */
public class RegisterPage {
	private JFrame frame;
	private JTextField numeField;
	private JTextField usernameField;
	private	JPasswordField passwordField;
	private JComboBox<String> sexField;
	private JComboBox<Integer> varstaField;
	private JComboBox<Integer> greutateField;
	private JComboBox<Integer> inaltimeField;
	/**
	 * Constructor neparametrizabil register
	 */
	public RegisterPage() {
		frame = new JFrame("Register");
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().setBackground(new Color(0, 10, 128));
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel numeLabel = new JLabel("Nume:");
		numeLabel.setBounds(23, 178, 80, 25);
		numeLabel.setForeground(Color.WHITE);
		numeLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(numeLabel);
		
		numeField = new JTextField();
		numeField.setBounds(124, 170, 247, 41);
		numeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(numeField);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(23, 244, 105, 25);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(124, 236, 247, 41);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(usernameField);
		
		JLabel passwordLabel = new JLabel("Parola:");
		passwordLabel.setBounds(23, 311, 80, 25);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 303, 247, 41);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(passwordField);
		
		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setBounds(34, 75, 59, 25);
		sexLabel.setForeground(Color.WHITE);
		sexLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(sexLabel);
		
		sexField = new JComboBox<>(new String[]{"M", "F"});
		sexField.setBounds(34, 110, 59, 41);
		sexField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(sexField);
		
		JLabel varstaLabel = new JLabel("Varsta:");
		varstaLabel.setBounds(118, 75, 80, 25);
		varstaLabel.setForeground(Color.WHITE);
		varstaLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(varstaLabel);
		
		Integer[] varste = new Integer[100];
		for(int i=0; i<100; i++) {
			varste[i] = i + 1;
		}
		varstaField = new JComboBox(varste);
		varstaField.setBounds(118, 111, 80, 41);
		varstaField.setFont(new Font("Dialog", Font.PLAIN, 13));
		frame.getContentPane().add(varstaField);
		
		JLabel greutateLabel = new JLabel("Greutate:");
		greutateLabel.setBounds(227, 75, 80, 25);
		greutateLabel.setForeground(Color.WHITE);
		greutateLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(greutateLabel);
		
		Integer[] greutati = new Integer[200];
		for(int i=0; i<200; i++) {
			greutati[i] = i + 1;
		}
		greutateField = new JComboBox(greutati);
		greutateField.setBounds(227, 111, 82, 41);
		greutateField.setFont(new Font("Dialog", Font.PLAIN, 13));
		frame.getContentPane().add(greutateField);
		
		JLabel inaltimeLabel = new JLabel("Inaltime:");
		inaltimeLabel.setBounds(342, 75, 80, 25);
		inaltimeLabel.setForeground(Color.WHITE);
		inaltimeLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        frame.getContentPane().add(inaltimeLabel);

        Integer[] inaltimi = new Integer[230];
        for (int i = 0; i < 230; i++) {
            inaltimi[i] = i + 1;
        }
        inaltimeField = new JComboBox<>(inaltimi);
        inaltimeField.setBounds(342, 111, 82, 41);
        inaltimeField.setFont(new Font("Dialog", Font.PLAIN, 13));
        frame.getContentPane().add(inaltimeField);
		
		JButton registerButton = new JButton("Inregistreaza-te");
		registerButton.setBounds(163, 368, 159, 46);
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(registerButton);
		
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nume = numeField.getText();
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String sex =  (String) sexField.getSelectedItem();
				int varsta = (Integer) varstaField.getSelectedItem();
				int greutate = (Integer) greutateField.getSelectedItem();
				int inaltime = (Integer) inaltimeField.getSelectedItem();
				
				if(nume.isEmpty() || username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Toate campurile sunt obligatorii");
					return;
				}
				
				if(PacientRepository.takenUsername(username)) {
					JOptionPane.showMessageDialog(frame, "Username deja folosit");
					return;
				}
				
			    Particularitati particularitati = new Particularitati(sex,varsta,greutate,inaltime);
				Pacient pacient = new Pacient(username,password,nume,particularitati);
				
				if(PacientRepository.addPacient(pacient)) {
					JOptionPane.showMessageDialog(frame, "Pacient inregistrat cu succes");
					frame.dispose();
					new LoginPage();
					
				}else {
					JOptionPane.showMessageDialog(frame, "Eroare intampinata la inregistrare");
				}
			}
			
		});
		
		JButton cancelButton = new JButton("Inapoi");
		cancelButton.setBounds(0, 442, 486, 21);
		frame.getContentPane().add(cancelButton);
		
		JLabel doctorLabel = new JLabel("DOCTOR24");
		doctorLabel.setBounds(130, 22, 215, 43);
		doctorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		doctorLabel.setForeground(Color.WHITE);
		doctorLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		frame.getContentPane().add(doctorLabel);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginPage();
			}
			
		});
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new RegisterPage();
	}
}
