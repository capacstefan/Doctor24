package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

import obiecte.Particularitati;
import repository.PacientRepository;
/**
 * Pagina main
 */
public class MainPage {
    protected static final String String = null;
	private JFrame frame;
    
	/**
	 * Constructor parametrizabil main
	 * @param username
	 */
    public MainPage(String username) {
        frame = new JFrame("Doctor24");
        frame.getContentPane().setForeground(new Color(0, 10, 128));
        frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
        frame.getContentPane().setBackground(new Color(0, 10, 128));
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);  
        
        JLabel welcomeLabel = new JLabel("Bun venit, " + username + "!");
        welcomeLabel.setForeground(new Color(255, 255, 255));
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(33, 89, 417, 43);
        frame.getContentPane().add(welcomeLabel);  
        
        JLabel doctorLabel = new JLabel("DOCTOR24");
        doctorLabel.setForeground(new Color(255, 255, 255));
        doctorLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        doctorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        doctorLabel.setBounds(138, 21, 215, 43);
        frame.getContentPane().add(doctorLabel);
        
        JButton consultButton = new JButton("CONSULT");
        consultButton.setBackground(Color.WHITE);
        consultButton.setForeground(new Color(0, 10, 128));
        consultButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        consultButton.setBounds(146, 172, 192, 52);
        frame.getContentPane().add(consultButton);  
        consultButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectareParteCorpPage(username);
			}
		});

        JButton istoricButton = new JButton("ISTORIC");
        istoricButton.setBackground(Color.WHITE);
        istoricButton.setForeground(new Color(0, 10, 128));
        istoricButton.setFont(new Font("Dialog", Font.BOLD, 12));
        istoricButton.setBounds(33, 359, 167, 36);
        frame.getContentPane().add(istoricButton);
        istoricButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new IstoricPage(username);	
			}
        	
        });
        

        JButton partButton = new JButton("PARTICULARITATI");
        partButton.setBackground(Color.WHITE);
        partButton.setForeground(new Color(0, 10, 128));
        partButton.setFont(new Font("Dialog", Font.BOLD, 12));
        partButton.setBounds(33, 313, 167, 36);
        frame.getContentPane().add(partButton); 
        partButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ParticularitatiPage(frame, username);
            }
        });
        
        JButton deconButton = new JButton("DECONECTEAZA-TE");
        deconButton.setBackground(Color.WHITE);
        deconButton.setForeground(new Color(0, 10, 128));
        deconButton.setFont(new Font("Dialog", Font.BOLD, 12));
        deconButton.setBounds(283,360,167,36);
        frame.getContentPane().add(deconButton);
        deconButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginPage();
				
			}
		});
        
        JButton delButton = new JButton("SETERGE CONT");
        delButton.setBackground(Color.WHITE);
        delButton.setForeground(new Color(0, 10, 128));
        delButton.setFont(new Font("Dialog", Font.BOLD, 12));
        delButton.setBounds(283,314,167,36);
        frame.getContentPane().add(delButton);
        delButton.addActionListener(new ActionListener() {
			
        	@Override
			public void actionPerformed(ActionEvent e) {
        		
        		int daSauNu = JOptionPane.showConfirmDialog(
        				frame,
        				"Esti sigur? Contul va fi sters permanent.",
        				"Confirmare stergere",
        				JOptionPane.YES_NO_OPTION,
        				JOptionPane.WARNING_MESSAGE
        		);
        		if(daSauNu == JOptionPane.YES_OPTION) {
        			PacientRepository.deletePacient(username);
					frame.dispose();
					new LoginPage();
        		}
        	}
		});
        
        
        JButton imcButton = new JButton("CALCULEAZA IMC");
        imcButton.setForeground(new Color(0, 10, 128));
        imcButton.setBackground(Color.WHITE);
        imcButton.setFont(new Font("Dialog", Font.BOLD, 12));
        imcButton.setBounds(161,234,160,43);
        frame.getContentPane().add(imcButton);
        imcButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ImcPage(username);
			}
        	
        });
        
        frame.setVisible(true);  
    }
    
    
    
    public static void main(String[] args) {
        new MainPage("a"); 
    }
}