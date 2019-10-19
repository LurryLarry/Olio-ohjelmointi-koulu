import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Versiotiedot {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void versioIkkuna() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Versiotiedot window = new Versiotiedot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Versiotiedot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblJuomaautomaattiV = new JLabel("JUOMA-AUTOMAATTI V. 1.0");
		lblJuomaautomaattiV.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblJuomaautomaattiV.setBounds(102, 93, 247, 14);
		frame.getContentPane().add(lblJuomaautomaattiV);
		
		JLabel lblTekijLariVesterinen = new JLabel("Tekij\u00E4: Lari Vesterinen =)");
		lblTekijLariVesterinen.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTekijLariVesterinen.setBounds(127, 118, 236, 14);
		frame.getContentPane().add(lblTekijLariVesterinen);
	}

}
