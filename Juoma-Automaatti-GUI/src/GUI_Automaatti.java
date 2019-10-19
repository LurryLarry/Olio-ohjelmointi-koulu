import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Insets;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitell‰‰n t‰‰ll‰ jotta komponentteihin voidaan viitata mist‰ tahansa luokan
	// sis‰lt‰

	JPanel contentPane;
	private JMenuItem mntmTallennaAutomaatinTila;
	private JMenuItem mntmLataaAutomaatti;

	/**
	 * Main-metodi, joka k‰ynnist‰‰ sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// K‰yttˆliittym‰ saa parametrina olion, jonka tiedot se n‰ytt‰‰
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan k‰yttˆliittym‰. Huomaa, ett‰ otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. T‰m‰ siksi, ett‰ voidaan n‰ytt‰‰ sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko

		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("Yll\u00E4pito");
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmAsetaKahvinMr = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		
		
		mnNewMenu.add(mntmAsetaKahvinMr);
		
		JMenuItem mntmAsetaTeenMr = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		
		mnNewMenu.add(mntmAsetaTeenMr);
		
		JMenuItem mntmAsetaKaakaonMr = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
	
		mnNewMenu.add(mntmAsetaKaakaonMr);
		
		JMenuItem mntmTallennaAutomaatinTila_1 = new JMenuItem("Tallenna automaatin tila");
		
		mnNewMenu.add(mntmTallennaAutomaatinTila_1);
		
		JMenuItem mntmLataaAutomaatti_1 = new JMenuItem("Lataa automaatti");
		
		mnNewMenu.add(mntmLataaAutomaatti_1);
		
		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		
		mnNewMenu.add(mntmLopeta);
		
		JMenu mnNewMenu_1 = new JMenu("Tietoa ohjelmasta");
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmVersiotiedot = new JMenuItem("Versiotiedot");
		mntmVersiotiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Versiotiedot.versioIkkuna();
			}
		});
		mnNewMenu_1.add(mntmVersiotiedot);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ohje");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ohje.ohjeIkkuna();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

	 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JLabel lblKahvi = new JLabel("Kahvi");
		lblKahvi.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		lblKahvi.setBounds(70, 190, 46, 14);
		contentPane.add(lblKahvi);
		
		JLabel lblNewLabel = new JLabel("Tee");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(70, 382, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kaakao");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(70, 581, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel kahviMaara = new JLabel("Kahvia: " + ja.getKahvi());
		kahviMaara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		kahviMaara.setBounds(220, 104, 79, 14);
		contentPane.add(kahviMaara);
		
		JLabel teeMaara = new JLabel("Teet\u00E4: " + ja.getTee());
		teeMaara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		teeMaara.setBounds(220, 295, 79, 14);
		contentPane.add(teeMaara);
		
		JLabel kaakaoMaara = new JLabel("Kaakaota: " + ja.getKaakao());
		kaakaoMaara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		kaakaoMaara.setBounds(220, 499, 79, 14);
		contentPane.add(kaakaoMaara);
		
		
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String kysyArvo = JOptionPane.showInputDialog("Anna uusi arvo: ");
				int numeraalinenArvo = Integer.parseInt(kysyArvo);
				ja.setKaakao(numeraalinenArvo);
				
				kaakaoMaara.setText("Kaakaota: " + ja.getKaakao());
				kaakaoMaara.setForeground(Color.BLACK);

				if(ja.getKaakao() < 20) {
					kaakaoMaara.setForeground(Color.RED);
				} else {
					kaakaoMaara.setForeground(Color.BLACK);
				}
			}
		});
		
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				String kysyArvo = JOptionPane.showInputDialog("Anna uusi arvo: ");
				int numeraalinenArvo = Integer.parseInt(kysyArvo);
				ja.setTee(numeraalinenArvo);
				
				teeMaara.setText("Teet‰: " + ja.getTee());
				
				if(ja.getTee() < 20) {
					teeMaara.setForeground(Color.RED);
				} else {
					teeMaara.setForeground(Color.BLACK);
				}
			}
		});
		
		mntmAsetaKahvinMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String kysyArvo = JOptionPane.showInputDialog("Anna uusi arvo: ");
				int numeraalinenArvo = Integer.parseInt(kysyArvo);
				
				ja.setKahvi(numeraalinenArvo);
				
				kahviMaara.setText("Kahvia: " + ja.getKahvi());
				
				if(ja.getKahvi() < 20) {
					kahviMaara.setForeground(Color.RED);
				} else {
					kahviMaara.setForeground(Color.BLACK);
				}
				
				
			}
		});
		
		mntmLataaAutomaatti_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
					System.out.println(uusi); // console.loggaus auttoi tajuamaan miten t‰m‰ lataaminen toimii
					uusi.getKahvi();
					kahviMaara.setText("Kahvia: " + uusi.getKahvi());
					
					uusi.getTee();
					teeMaara.setText("Teet‰: " + uusi.getTee());
		
					uusi.getKaakao();
					kaakaoMaara.setText("Kaakaota: " + uusi.getKaakao());
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		mntmTallennaAutomaatinTila_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Sarjallistamista.kirjoitaTiedostoon(ja);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JButton kahviNappi = new JButton("Kahvi");
		kahviNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ja.tilaaKahvi();
				
				
				kahviMaara.setText("Kahvia: " + ja.getKahvi());
				
				if(ja.getKahvi() < 20) {
					kahviMaara.setForeground(Color.RED);
				}
				
			}
		});
		kahviNappi.setIcon(new ImageIcon("img\\coffee.jpg"));
		kahviNappi.setBounds(29, 44, 122, 135);
		contentPane.add(kahviNappi);
		
		JButton btnNewButton_1 = new JButton("Tee");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ja.tilaaTee();
				
				teeMaara.setText("Teet‰: " + ja.getTee());
				
				if(ja.getTee() < 20) {
					teeMaara.setForeground(Color.RED);
				}
			}
		});
		btnNewButton_1.setMargin(new Insets(2, 14, 2, 0));
		btnNewButton_1.setIcon(new ImageIcon("img\\tea.jpg"));
		btnNewButton_1.setBounds(29, 232, 122, 140);
		contentPane.add(btnNewButton_1);
		
		JButton kaakaoNappi = new JButton("Kaakao");
		kaakaoNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ja.tilaaKaakao();
				
				kaakaoMaara.setText("Kaakaota: " + ja.getKaakao());
				
				if(ja.getKaakao() < 20) {
					kaakaoMaara.setForeground(Color.RED);
				}
			}
		});
		
		kaakaoNappi.setIcon(new ImageIcon("img\\cocoa.jpg"));
		kaakaoNappi.setBounds(29, 443, 122, 127);
		contentPane.add(kaakaoNappi);
	}
	
	
}
