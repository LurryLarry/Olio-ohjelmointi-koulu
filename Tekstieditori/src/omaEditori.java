import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultEditorKit.CutAction;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class omaEditori extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					omaEditori frame = new omaEditori();

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
	public omaEditori() {

		setSize(700, 600);
		setTitle("Oma Editori");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);

		JMenuItem mntmAvaa = new JMenuItem("Avaa");

		mntmAvaa.setIcon(new ImageIcon(omaEditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		mntmAvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmAvaa);

		JMenuItem mntmTallenna = new JMenuItem("Tallenna");

		mntmTallenna.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmTallenna
				.setIcon(new ImageIcon(omaEditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnTiedosto.add(mntmTallenna);

		JMenuItem mntmSulje = new JMenuItem("Sulje");

		mntmSulje.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmSulje.setIcon(
				new ImageIcon(omaEditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		mnTiedosto.add(mntmSulje);

		JMenu mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);

		JMenuItem mntmEtsi = new JMenuItem("Etsi");
		mntmEtsi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));

		mnMuokkaa.add(mntmEtsi);

		JMenuItem mntmKorvaa = new JMenuItem("Korvaa");
		mntmKorvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));

		mnMuokkaa.add(mntmKorvaa);

		JMenu mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);

		JMenuItem mntmNewMenuItem = new JMenuItem("Tietoja ohjelmasta");

		mnTietoja.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		JButton tiedostoNappi = new JButton("");
		tiedostoNappi.setToolTipText("Avaa");

		tiedostoNappi
				.setIcon(new ImageIcon(omaEditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		toolBar.add(tiedostoNappi);

		JButton tallennusNappi = new JButton("");
		tallennusNappi.setToolTipText("Tallenna");

		tallennusNappi
				.setIcon(new ImageIcon(omaEditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		toolBar.add(tallennusNappi);

		JButton leikkausNappi = new JButton();

		leikkausNappi.setToolTipText("Leikkaa");
		leikkausNappi.setIcon(new ImageIcon("img\\scissor.PNG"));
		toolBar.add(leikkausNappi);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setSelectionColor(Color.YELLOW);

		contentPane.add(editorPane, BorderLayout.CENTER);

		mntmKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String valittuSana = editorPane.getSelectedText();
				System.out.println(valittuSana);
				String korvaavaSana = JOptionPane.showInputDialog("Korvaa valittu teksti sanalla: ");
				if (valittuSana == null) { // poistaa errorin jos ei laita mit‰‰n
					return;
				}
				System.out.println(korvaavaSana);
				String sisalto = editorPane.getText();

				String uusiSisalto = sisalto.replaceAll(valittuSana, korvaavaSana);
				editorPane.setText(uusiSisalto);

				System.out.println(uusiSisalto);

			}
		});

		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ohjelmatietoja.tietojaIkkuna();
			}
		});

		mntmSulje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mntmTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser valintaikkuna = new JFileChooser();

				valintaikkuna.showSaveDialog(null);

				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();

				System.out.println("Kirjoitettava tiedosto: " + uusiTiedosto);

				try {

					PrintWriter writer = new PrintWriter(uusiTiedosto);
					String sisalto = editorPane.getText();
					
					writer.println(sisalto);
					writer.flush();
					writer.close();
				} catch (Exception e2) {
					System.out.println("Tallennus ei onnistunut.");
					e2.printStackTrace();
				}
			}
		});

		mntmEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String etsittavaSana = JOptionPane.showInputDialog("Etsi sanaa: ");
				if (etsittavaSana == null) { // poistaa errorin jos ei laita mit‰‰n
					return;
				}
				String sisalto = editorPane.getText();
				int indeksi = sisalto.indexOf(etsittavaSana);

				editorPane.setSelectionColor(Color.YELLOW);
				editorPane.setSelectionStart(indeksi);
				editorPane.setSelectionEnd(indeksi + etsittavaSana.length());

			}
		});

		tallennusNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showSaveDialog(null);

				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();

				System.out.println("Kirjoitettava tiedosto: " + uusiTiedosto);

				try {

					PrintWriter writer = new PrintWriter(uusiTiedosto);
					String sisalto = editorPane.getText();
					
					writer.println(sisalto);
					writer.flush();
					writer.close();
				} catch (Exception e2) {
					System.out.println("Tallennus ei onnistunut.");
					e2.printStackTrace();
				}
			}
		});

		tiedostoNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.setApproveButtonText("Avaa tiedosto");
				valintaikkuna.setDialogTitle("Tiedoston valinta");
				valintaikkuna.showOpenDialog(null);

				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				String rivi = "";
				try {

					Scanner lukija = null;
					// File tiedosto = new File("src//jokuteksti.txt");
					File tiedosto = new File(uusiTiedosto);

					lukija = new Scanner(tiedosto);

					while (lukija.hasNextLine()) {
						rivi += lukija.nextLine() + "\n";
						System.out.println(rivi);
					}

					editorPane.setText(rivi);

				} catch (FileNotFoundException e1) {
					System.out.println("Tiedoston avaaminen ei onnistunut.");
					e1.printStackTrace();
				}
			}
		});

		mntmAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.setApproveButtonText("Avaa tiedosto");
				valintaikkuna.setDialogTitle("Tiedoston valinta");
				valintaikkuna.showOpenDialog(null);

				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				String rivi = "";
				try {

					Scanner lukija = null;
					// File tiedosto = new File("src//jokuteksti.txt");
					File tiedosto = new File(uusiTiedosto);

					lukija = new Scanner(tiedosto);

					while (lukija.hasNextLine()) {
						rivi += lukija.nextLine() + "\n";
						System.out.println(rivi);
					}

					editorPane.setText(rivi);

				} catch (FileNotFoundException e1) {
					System.out.println("Tiedoston avaaminen ei onnistunut.");
					e1.printStackTrace();
				}
			}
		});
	}

}
