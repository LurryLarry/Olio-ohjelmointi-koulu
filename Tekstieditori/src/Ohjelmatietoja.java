import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Ohjelmatietoja extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void tietojaIkkuna() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ohjelmatietoja frame = new Ohjelmatietoja();
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
	public Ohjelmatietoja() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblTekstieditoriV = new JLabel("TEKSTIEDITORI V. 1.0");
		lblTekstieditoriV.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTekstieditoriV.setBounds(125, 113, 236, 14);
		contentPane.add(lblTekstieditoriV);

		JLabel lblTekijLariVesterinen = new JLabel("TEKIJ\u00C4: LARI VESTERINEN =)");
		lblTekijLariVesterinen.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTekijLariVesterinen.setBounds(101, 157, 247, 14);
		contentPane.add(lblTekijLariVesterinen);

		JLabel lblHttpswwwlinkedincominlarivesterinenb = new JLabel(
				"https://www.linkedin.com/in/lari-vesterinen-37189716b/");
		lblHttpswwwlinkedincominlarivesterinenb.setLabelFor(this);
		lblHttpswwwlinkedincominlarivesterinenb.setBounds(82, 196, 311, 14);
		contentPane.add(lblHttpswwwlinkedincominlarivesterinenb);
	}
}
