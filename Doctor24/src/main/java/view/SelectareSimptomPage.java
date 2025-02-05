package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import obiecte.Diagnostic;
import obiecte.ParteCorp;
import repository.ParteCorpRepository;
/**
 * Pagina selectare simptome
 */
public class SelectareSimptomPage {
	private JFrame frame;
	
	/**
	 * Constructor parametrizabil selectare simptome
	 * @param numeParteCorp
	 * @param username
	 */
	public SelectareSimptomPage(String numeParteCorp, String username) {
		frame = new JFrame("Selectare simptome");
		frame.getContentPane().setBackground(new Color(0, 10, 128));
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ParteCorp parteCorp = ParteCorpRepository.getParteCorp(numeParteCorp);
		
		//parteCorp.getDiagnostice().stream().flatMap(d -> d.getSimptome().stream()).forEach(System.out::println);

		if(parteCorp!=null) {
		JLabel titleLabel = new JLabel("Selectati simptomele pentru <" + parteCorp.getNume() + ">");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(110,49,330,30);
		frame.getContentPane().add(titleLabel);
		}else {
			JLabel titleLabel = new JLabel("Parte corp " + numeParteCorp + " lipsa din baza de date");
			titleLabel.setBounds(156,49,300,30);
		}
		
		
		JButton closeButton = new JButton("Incheie");
		closeButton.setBounds(0,438,486,25);
		frame.getContentPane().add(closeButton);
		closeButton.setBackground(Color.WHITE);
        closeButton.setForeground(new Color(0, 10, 128));
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MainPage(username);
			}
			
		});
		
		
		Set<String> simptomeSet = new HashSet<>();
		if(parteCorp != null) {
			for(Diagnostic diagnostic : parteCorp.getDiagnostice()) {
				for(String simptom : diagnostic.getSimptome())
					simptomeSet.add(simptom);
				}
		} else {
			System.out.println("Parte corp " + numeParteCorp + " lipsa din baza de date");
		}
		
		List<JCheckBox> simptomeCheckBoxes = new ArrayList<>();
		int xPos = 60;
		int yPos = 100;
		
		for(String simptom : simptomeSet){
			JCheckBox CBSimptom = new JCheckBox(simptom);
			CBSimptom.setBackground(new Color(0, 10, 128));
			CBSimptom.setForeground(Color.WHITE);
			CBSimptom.setBounds(xPos,yPos,180,40);
			CBSimptom.setFont(new Font("Tahoma", Font.PLAIN, 15));
			simptomeCheckBoxes.add(CBSimptom);
			frame.getContentPane().add(CBSimptom);
			yPos += 60;
			if(yPos > 350) {
				yPos = 100;
				xPos += 180;
			}
		}
		
		
		
		JButton nextButton = new JButton("DIAGNOSTICARE");
		nextButton.setForeground(new Color(0, 10, 128));
		nextButton.setBackground(Color.WHITE);
		nextButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextButton.setBounds(154,394,177,34);
		frame.getContentPane().add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> simptome = new ArrayList<>();
				for(JCheckBox cb : simptomeCheckBoxes)
					if(cb.isSelected())
						simptome.add(cb.getText());
				if(simptome.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Trebuie sa selectati minim un simptom");
				}else {
					frame.dispose();
					new DiagnosticePage(username,simptome,parteCorp);
				}
			
						
			}
		});
		
		
		
		
		frame.setVisible(true);
	}

}
