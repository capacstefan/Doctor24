package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import obiecte.Particularitati;
import repository.PacientRepository;
import javax.swing.SwingConstants;
/**
 * Pagina calculare IMC
 */
public class ImcPage {
	private JFrame frame;
	
	/**
	 * Constructor parametrizabil istoric
	 * @param username
	 */
	public ImcPage(String username) {
		frame = new JFrame("Indiciele de masa Corporala (IMC)");
		frame.getContentPane().setBackground(new Color(0, 10, 128));
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Particularitati partic = PacientRepository.getParticularitati(username);
		if(partic == null) {
			JOptionPane.showMessageDialog(frame, "Eroare obtinere informatii pacient");
			frame.dispose();
			return;
		}
		
		int greutate = partic.getGreutate();
        int inaltime = partic.getInaltime();
        String sex = partic.getSex();
        int varsta = partic.getVarsta();
        
        double inaltimeM = inaltime / 100.0;
        double imc = greutate / (inaltimeM * inaltimeM);

        if (sex.equals("F"))
            imc *= 1.1;
        
        if (varsta > 40) 
            imc *= 1.05;
        
        String interpretare;
        String sugestie;

        if (imc < 18.5) {
            interpretare = "Subponderal";
            sugestie = "Este posibil sa ai nevoie sa cresti aportul caloric si sa incluzi alimente bogate in nutrienti esentiali, cum ar fi proteine, grasimi sanatoase si carbohidrati complecsi. Incearca sa mananci mai frecvent, sa incluzi gustari sanatoase si sa consulti un specialist pentru a-ti crea un plan alimentar personalizat.";
        } else if (imc < 25) {
            interpretare = "Greutate normala";
            sugestie = "Felicitari! Mentinerea greutatii ideale implica un stil de viata sanatos, care include o dieta echilibrata, activitate fizica regulata si gestionarea stresului. Continua sa monitorizezi echilibrul intre aportul caloric si consumul energetic si nu uita sa te hidratezi corespunzator.";
        } else if (imc < 30) {
            interpretare = "Supraponderal";
            sugestie = "Pentru a reveni la o greutate sanatoasa, este important sa faci alegeri alimentare echilibrate, cum ar fi reducerea consumului de alimente procesate, zaharuri si grasimi saturate. Incearca sa integrezi activitati fizice regulate, cum ar fi mersul pe jos, alergatul usor sau exercitii la sala. Ofera-ti timp si rabdare, iar pentru rezultate optime, discuta cu un nutritionist.";
        } else {
            interpretare = "Obezitate";
            sugestie = "Obezitatea poate avea un impact semnificativ asupra sanatatii tale pe termen lung. Este esential sa adopti un plan bine structurat care sa includa o dieta hipocalorica, bogata in fibre, vitamine si minerale. Activitatea fizica regulata, chiar si de intensitate moderata, poate contribui la reducerea greutatii corporale. Este puternic recomandat sa consulti un medic specialist sau un nutritionist pentru a crea un program personalizat care sa se potriveasca nevoilor tale specifice.";
        }

        
        JLabel imcLabel = new JLabel("IMC-ul dvs este: " + String.format("%.2f", imc));
        imcLabel.setForeground(new Color(255, 255, 255));
        imcLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imcLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        imcLabel.setBounds(75, 59, 300, 30); 
        frame.getContentPane().add(imcLabel);

        JLabel interpLabel = new JLabel("Interpretare: " + interpretare);
        interpLabel.setForeground(new Color(255, 255, 255));
        interpLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        interpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        interpLabel.setBounds(75, 99, 300, 30); 
        frame.getContentPane().add(interpLabel);

        JLabel sugestieLabel = new JLabel("<html><b>Sugestie:</b> " + sugestie + "</html>");
        sugestieLabel.setForeground(Color.WHITE);
        sugestieLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        sugestieLabel.setVerticalAlignment(SwingConstants.TOP);
        sugestieLabel.setHorizontalAlignment(SwingConstants.LEFT);
        sugestieLabel.setBounds(59, 171, 350, 183); 
        frame.getContentPane().add(sugestieLabel);

        JButton cancelButton = new JButton("Inapoi");
        cancelButton.setBounds(0, 442, 486, 21); 
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainPage(username);
            }
        });
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setForeground(new Color(0, 10, 128));
        frame.getContentPane().add(cancelButton);

        
        frame.setVisible(true);
	}
}
