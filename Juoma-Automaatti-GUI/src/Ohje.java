import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Ohje {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void ohjeIkkuna() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ohje window = new Ohje();
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
	public Ohje() {
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
		
		JLabel lblOtaHiiri = new JLabel("1. Ota hiiri k\u00E4teen");
		lblOtaHiiri.setBounds(137, 111, 121, 14);
		frame.getContentPane().add(lblOtaHiiri);
		
		JLabel lblKlikkaileYmpriins = new JLabel("2. Klikkaile ymp\u00E4riins\u00E4");
		lblKlikkaileYmpriins.setBounds(137, 136, 166, 14);
		frame.getContentPane().add(lblKlikkaileYmpriins);
		
		JLabel lblNautiskele = new JLabel("3. Nautiskele");
		lblNautiskele.setBounds(137, 161, 121, 14);
		frame.getContentPane().add(lblNautiskele);
		
		JLabel lblOhjeet = new JLabel("Ohjeet");
		lblOhjeet.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblOhjeet.setBounds(137, 86, 232, 14);
		frame.getContentPane().add(lblOhjeet);
	}

}
