package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import repository.PacientRepository;

/**
 * Pagina istoric diagnostice
 */
public class IstoricPage {
    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollPane;

    /**
     * Constructor parametrizabil istoric
     * @param username
     */
    public IstoricPage(String username) {
        frame = new JFrame("Istoric");
        frame.getContentPane().setBackground(new Color(0, 10, 128));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panou principal pentru scroll
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(0, 10, 128)); // Fundal al panoului cu istoricul

        // Adaugăm spații între elemente
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Creăm istoricul
        getIstoric(username);

        // Adăugăm scroll pane-ul
        scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getViewport().setBackground(new Color(0, 10, 128)); // Fundal pentru viewport
        scrollPane.getVerticalScrollBar().setBackground(new Color(0, 10, 128)); // Fundal scrollbar vertical

        frame.add(scrollPane);

        // Butonul de revenire
        JButton cancelButton = new JButton("Inapoi");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainPage(username);
            }
        });
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setForeground(new Color(0, 10, 128));
        frame.add(cancelButton, "South");

        frame.setVisible(true);
    }

    /**
     * Metoda generare istoric pacient
     * @param username
     */
    private void getIstoric(String username) {
        HashMap<String, String> istoric = (HashMap<String, String>) PacientRepository.getIstoric(username);

        if (istoric.isEmpty()) {
            JLabel golLabel = new JLabel("Nu exista diagnostice recente");
            golLabel.setForeground(Color.WHITE);
            golLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Central
            panel.add(golLabel);
        } else {
            for (String diagnostic : istoric.keySet()) {
                String data = istoric.get(diagnostic);

                // Panou pentru fiecare diagnostic
                JPanel diagnosticPanel = new JPanel();
                diagnosticPanel.setLayout(new BoxLayout(diagnosticPanel, BoxLayout.Y_AXIS));
                diagnosticPanel.setBackground(new Color(15, 30, 160)); // Fundal personalizat
                diagnosticPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
                diagnosticPanel.setPreferredSize(new Dimension(380, 70));
                diagnosticPanel.setMaximumSize(new Dimension(380, 100));
                
                JLabel diagnosticLabel = new JLabel("Diagnostic: " + diagnostic + "    Comentariu: " + data);
                diagnosticLabel.setForeground(Color.WHITE); // Text alb
                diagnosticLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Central

                JButton deleteButton = new JButton("Sterge");
                deleteButton.setBackground(Color.WHITE);
                deleteButton.setForeground(new Color(0, 10, 128));
                deleteButton.setAlignmentX(JButton.CENTER_ALIGNMENT); // Central
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        istoric.remove(diagnostic);
                        PacientRepository.updateIstoric(username, istoric);
                        panel.remove(diagnosticPanel);
                        panel.revalidate();
                        panel.repaint();
                    }
                });


                diagnosticPanel.add(diagnosticLabel);
                diagnosticPanel.add(Box.createVerticalStrut(12));
                diagnosticPanel.add(deleteButton);

                // Adăugăm panoul de diagnostic în panoul principal
                panel.add(diagnosticPanel);
                panel.add(Box.createVerticalStrut(10)); // Spațiu între elemente
            }
        }
    }

    public static void main(String[] args) {
        new IstoricPage("a");
    }
}
