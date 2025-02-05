package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Pagina selectare parte corp
 */
public class SelectareParteCorpPage {
	private JFrame frame;
	/**
	 * Constructor parametrizabil selectare parte corp
	 * @param username
	 */
	public SelectareParteCorpPage(String username) {
		frame = new JFrame("Selectare parte corp");
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().setBackground(new Color(0, 10, 128));
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Alege partea corpului care prezinta discomfort");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(27,29,421,50);
		frame.getContentPane().add(titleLabel);
		
		JButton closeButton = new JButton("Incheie");
		closeButton.setForeground(new Color(0, 10, 128));
		closeButton.setBackground(Color.WHITE);
		closeButton.setBounds(0,438,486,25);
		frame.getContentPane().add(closeButton);
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MainPage(username);
			}
			
		});
		
		JButton ochiButton = new JButton("Ochi");
		ochiButton.setBackground(Color.WHITE);
		ochiButton.setForeground(new Color(0, 10, 128));
		ochiButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		ochiButton.setBounds(178, 103, 114, 57);
		frame.getContentPane().add(ochiButton);
		ochiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectareSimptomPage("Ochi",username);
			}
			
		});
		
		JButton guraButton = new JButton("Gura");
		guraButton.setBackground(Color.WHITE);
		guraButton.setForeground(new Color(0, 10, 128));
		guraButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		guraButton.setBounds(178, 256, 114, 57);
		frame.getContentPane().add(guraButton);
		guraButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectareSimptomPage("Gura",username);
			}
			
		});
		
		JButton urechiButton = new JButton("Urechi");
		urechiButton.setBackground(Color.WHITE);
		urechiButton.setForeground(new Color(0, 10, 128));
		urechiButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		urechiButton.setBounds(178, 178, 114, 57);
		frame.getContentPane().add(urechiButton);
		urechiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectareSimptomPage("Urechi",username);
			}
			
		});
		
		JButton gatButton = new JButton("Gat");
		gatButton.setBackground(Color.WHITE);
		gatButton.setForeground(new Color(0, 10, 128));
		gatButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		gatButton.setBounds(178, 335, 114, 57);
		frame.getContentPane().add(gatButton);
		gatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectareSimptomPage("Gat",username);
			}
			
		});
		
		JButton pieptButton = new JButton("Piept");
		pieptButton.setBackground(Color.WHITE);
		pieptButton.setForeground(new Color(0, 10, 128));
		pieptButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		pieptButton.setBounds(313, 181, 133, 50);
		frame.getContentPane().add(pieptButton);
		pieptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectareSimptomPage("Piept",username);
			}
			
		});
		
		
		JButton abdomenButton = new JButton("Abdomen");
		abdomenButton.setBackground(Color.WHITE);
		abdomenButton.setForeground(new Color(0, 10, 128));
		abdomenButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		abdomenButton.setBounds(313, 259, 133, 50);
		frame.getContentPane().add(abdomenButton);
		abdomenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectareSimptomPage("Abdomen",username);
			}
			
		});
		
		
		JButton manaButton = new JButton("Mana");
		manaButton.setBackground(Color.WHITE);
		manaButton.setForeground(new Color(0, 10, 128));
		manaButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		manaButton.setBounds(27, 181, 133, 50);
		frame.getContentPane().add(manaButton);
		manaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectareSimptomPage("Mana",username);
			}
			
		});
		
		JButton piciorButton = new JButton("Picior");
		piciorButton.setBackground(Color.WHITE);
		piciorButton.setForeground(new Color(0, 10, 128));
		piciorButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		piciorButton.setBounds(27, 259, 133, 50);
		frame.getContentPane().add(piciorButton);
		piciorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectareSimptomPage("Picior",username);	
			}
			
		});
		
		frame.setVisible(true);
	}
}
