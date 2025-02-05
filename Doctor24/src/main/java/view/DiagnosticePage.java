package view;

import java.util.List;
import java.util.Map;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import obiecte.Diagnostic;
import obiecte.ParteCorp;
import repository.PacientRepository;
import javax.swing.SwingConstants;
import java.awt.Font;
/**
 * Pagina diagnostice rezultate
 */
public class DiagnosticePage {
	private JFrame frame;
	/**
	 * Constructor parametrizabil pagina
	 * @param username
	 * @param simptome
	 * @param parteCorp
	 */
	public DiagnosticePage(String username, List<String> simptome, ParteCorp parteCorp) {
		frame = new JFrame("Diagnostice");
		frame.getContentPane().setBackground(new Color(0, 10, 128));
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titluLabel = new JLabel("Diagnostice identificate");
		titluLabel.setForeground(new Color(255, 255, 255));
		titluLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titluLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titluLabel.setBounds(109,20,249,28);
		frame.getContentPane().add(titluLabel);
		
		JButton closeButton = new JButton("Incheie");
		closeButton.setBounds(0,438,486,25);
		frame.getContentPane().add(closeButton);
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MainPage(username);
			}
			
		});
		
		JPanel diagnosticePanel = new JPanel();
		diagnosticePanel.setBackground(new Color(0, 10, 128));
		diagnosticePanel.setLayout(new BoxLayout(diagnosticePanel,BoxLayout.Y_AXIS));
		
		
		for(Diagnostic diagnostic : parteCorp.getDiagnostice()) {
			for(String simptom : simptome) {
				if(diagnostic.getSimptome().contains(simptom)) {
					
					JPanel diagnosticPanel = new JPanel();
					diagnosticPanel.setLayout(new BoxLayout(diagnosticPanel,BoxLayout.Y_AXIS));

		
					JLabel diagnosticLabel = new JLabel(diagnostic.getNume());
					if(diagnostic.getGrav())
					diagnosticLabel.setForeground(Color.RED);
					diagnosticLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
					diagnosticPanel.add(diagnosticLabel);
					
					JLabel cauzeLabel = new JLabel("Cauze:");
					diagnosticPanel.add(cauzeLabel);
					
					JLabel cauzeContent = new JLabel("<html>" + diagnostic.getCauze() + "</html>");
					cauzeContent.setPreferredSize(new Dimension(400, 35));  // Dimensiune preferată pentru a controla wrapping-ul

					diagnosticPanel.add(cauzeContent);
					
					JLabel indicatiiLabel = new JLabel("Indicatii:");
					diagnosticPanel.add(indicatiiLabel);
					
					JLabel indicatiiContent = new JLabel("<html>" + diagnostic.getIndicatii() + "</html>");
					indicatiiContent.setPreferredSize(new Dimension(400, 35));  

					diagnosticPanel.add(indicatiiContent);
					
					JButton istoricButton = new JButton("Adauga in istoric");
					istoricButton.setBackground(Color.WHITE);
					istoricButton.setForeground(new Color(0, 10, 128));
					istoricButton.addActionListener(new ActionListener() {
					
						@Override
						public void actionPerformed(ActionEvent e) {
							String comentariu = JOptionPane.showInputDialog(frame,"Introdu un comentariu (ex: data)");
							if(comentariu != null && !comentariu.isEmpty() && comentariu.length()<21) {
								Map<String,String> istoric = PacientRepository.getIstoric(username);
								istoric.put(diagnostic.getNume(), comentariu);
								PacientRepository.updateIstoric(username,istoric);
								
								JOptionPane.showMessageDialog(frame, "Diagnostic adaugat in istoric");
							} else if( comentariu != null &&( comentariu.length() == 0 || comentariu.length() > 20)){
								JOptionPane.showMessageDialog(frame, "Comentariu trebuie sa contine 1-20 caractere");
							}
						}
					});
					diagnosticPanel.add(istoricButton);
					
					diagnosticePanel.add(diagnosticPanel);
					diagnosticePanel.add(Box.createVerticalStrut(20));
					
					break;
				}
			}
		}
		
		JScrollPane scrollPane = new JScrollPane(diagnosticePanel);
		scrollPane.setBounds(10,60,460,370);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setBackground(new Color(0, 10, 128));
		frame.getContentPane().add(scrollPane);
		
		frame.setVisible(true);
		
		
		
		
		
	}
}
