package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import repository.PacientRepository;
import java.awt.Font;
/**
 * Pagina dialog particularitati
 */
public class ParticularitatiPage extends JDialog{
	private JComboBox<String> sexField;
	private JComboBox<Integer> varstaField;
	private JComboBox<Integer> greutateField;
	private JComboBox<Integer> inaltimeField;
	
	/**
	 * Constructor parametrizabil particularitati
	 * @param parent
	 * @param username
	 */
	public ParticularitatiPage(JFrame parent,String username) {
		super(parent, "Modificare Particularitati");
		getContentPane().setBackground(new Color(0, 10, 128));
		setSize(339,233);
		getContentPane().setLayout(null);
		setLocationRelativeTo(parent);
		
		
		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sexLabel.setForeground(Color.WHITE);
		sexLabel.setBounds(20,22,64,25);
		getContentPane().add(sexLabel);
		
		sexField = new JComboBox<>(new String[] {"M","F"});
		sexField.setBounds(92,22,80,25);
		getContentPane().add(sexField);
		
		JLabel varstaLabel = new JLabel("Varsta:");
		varstaLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		varstaLabel.setForeground(Color.WHITE);
		varstaLabel.setBounds(20,57,64,25);
		getContentPane().add(varstaLabel);
		
		Integer[] varste = new Integer[100];
		for(int i=0; i<100; i++) {
			varste[i] = i + 1;
		}
		varstaField = new JComboBox<>(varste);
		varstaField.setBounds(94,57,78,25);
		getContentPane().add(varstaField);
		
		JLabel greutateLabel = new JLabel("Greutate:");
		greutateLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		greutateLabel.setForeground(Color.WHITE);
		greutateLabel.setBounds(20,92,64,25);
		getContentPane().add(greutateLabel);
		
		Integer[] greutati = new Integer[200];
		for(int i=0; i<200; i++) {
			greutati[i] = i + 1;
		}
		greutateField = new JComboBox<>(greutati);
		greutateField.setBounds(92,92,80,25);
		getContentPane().add(greutateField);
		
		JLabel inaltimeLabel = new JLabel("Inaltime:");
		inaltimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		inaltimeLabel.setForeground(Color.WHITE);
        inaltimeLabel.setBounds(20, 127, 64, 25);
        getContentPane().add(inaltimeLabel);

        Integer[] inaltimi = new Integer[230];
        for (int i = 0; i < 230; i++) {
            inaltimi[i] = i + 1; 
        }
        inaltimeField = new JComboBox<>(inaltimi);
        inaltimeField.setBounds(92, 127, 80, 25);
        getContentPane().add(inaltimeField);
		
		JButton saveSexButton = new JButton("Salveaza");
		saveSexButton.setBounds(209,22,89,25);
		getContentPane().add(saveSexButton);
		saveSexButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sex = (String) sexField.getSelectedItem();
				PacientRepository.updateSex(username, sex);
			}
		});
		
		JButton saveVarstaButton = new JButton("Salveaza");
		saveVarstaButton.setBounds(209,57,89,25);
		getContentPane().add(saveVarstaButton);
		saveVarstaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int varsta = (Integer) varstaField.getSelectedItem();
				PacientRepository.updateVarsta(username, varsta);
			}
		});
		
		JButton saveGreutateButton = new JButton("Salveaza");
		saveGreutateButton.setBounds(209,91,89,26);
		getContentPane().add(saveGreutateButton);
		saveGreutateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int greutate = (Integer) greutateField.getSelectedItem();
				PacientRepository.updateGreutate(username, greutate);
			}
		});
		
		JButton saveInaltimeButton = new JButton("Salveaza");
        saveInaltimeButton.setBounds(209, 127, 89, 25);
        getContentPane().add(saveInaltimeButton);
        saveInaltimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int inaltime = (Integer) inaltimeField.getSelectedItem();
                PacientRepository.updateInaltime(username, inaltime);
            }
        });
        
		JButton cancelButton = new JButton("Inapoi");
		cancelButton.setBounds(0,177,325,19);
		getContentPane().add(cancelButton,BorderLayout.SOUTH);
		cancelButton.setBackground(Color.WHITE);
        cancelButton.setForeground(new Color(0, 10, 128));
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		setVisible(true);
	}
}
