import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Ohjeet extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void ohjeitaIkkuna() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ohjeet frame = new Ohjeet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ohjeet() {
		setTitle("Ohjeet");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblTekstieditoriV = new JLabel("Yleisi\u00E4 ohjeita:\r\n\r\n\r\n");
		lblTekstieditoriV.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTekstieditoriV.setBounds(10, 36, 414, 21);
		contentPane.add(lblTekstieditoriV);
		
		JLabel lblNewLabel = new JLabel("- Lis\u00E4\u00E4 tietueihin arvot\r\n");
		lblNewLabel.setBounds(10, 68, 264, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("- Indeksin ja teoksen nimen oltava uniikkeja voidaksesi lis\u00E4t\u00E4 ne tietokantaan!\r\n");
		lblNewLabel_1.setBounds(10, 93, 400, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("- Klikkaa p\u00E4ivit\u00E4 n\u00E4pp\u00E4int\u00E4 p\u00E4ivitt\u00E4\u00E4ksesi koko taulukon tietokantaan\r\n");
		lblNewLabel_2.setBounds(10, 118, 390, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("- Poista valittu rivi poistaa automaattisesti my\u00F6s tietokannasta");
		lblNewLabel_3.setBounds(10, 143, 369, 14);
		contentPane.add(lblNewLabel_3);
	}
}


