import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class K�ytt�liittym� {
	
	static String URL = "jdbc:mysql://remotemysql.com:3306";
	 static String dbname = "QpLNBmWat5";
	static String USER = "QpLNBmWat5";
	 static String PASS = "Xmq1q2DvGL";
	 private static JTextField textField;
	
  
	
    public static void main(String[] args){
    	
    	
    	
    	
    	Kirja oletuskirja = new Kirja();
       
        JFrame frame = new JFrame("Kirjasovellus"); // luodaan ikkuna ja taulukko
        JTable table = new JTable(); 
        
        Object[] columns = {"Indeksi", "Teoksen nimi","Tekij�n nimi","Julkaisuvuosi"}; // m��ritell��n taulukon kolumnit
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.WHITE);
        table.setForeground(Color.black);
        table.setFont(new Font("Helvetica", Font.BOLD, 20));
        table.setRowHeight(30);
       
        // create JTextFields

        JTextField indeksiInput= new JTextField();
        JTextField teosInput= new JTextField();
        JTextField tekijaInput = new JTextField();
        JTextField vuosiInput = new JTextField();
    
        indeksiInput.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    long number = Long.parseLong(indeksiInput.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Only Numbers Allowed");
                    indeksiInput.setText("");
                }
            }
        });
        
        
        vuosiInput.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    long number = Long.parseLong(vuosiInput.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Only Numbers Allowed");
                    vuosiInput.setText("");
                }
            }
        });
        // create JButtons
        JButton btnAdd = new JButton("Lis\u00E4\u00E4 teos");
        JButton poistaRivi = new JButton("Poista valittu rivi");
        JButton btnUpdate = new JButton("P\u00E4ivit\u00E4 taulukko");     
        
        teosInput.setBounds(20, 220, 100, 25);
        tekijaInput.setBounds(20, 250, 100, 25);
        vuosiInput.setBounds(20, 280, 100, 25);
        indeksiInput.setBounds(20, 194, 100, 20);
        
        btnAdd.setBounds(20, 310, 100, 25);
        btnUpdate.setBounds(407, 192, 169, 25);
        poistaRivi.setBounds(233, 192, 164, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 181);
        
        frame.getContentPane().setLayout(null);
        
        frame.getContentPane().add(pane);
        
        // add JTextFields to the jframe
        frame.getContentPane().add(teosInput);
        frame.getContentPane().add(tekijaInput);
        frame.getContentPane().add(vuosiInput);
        frame.getContentPane().add(indeksiInput);
    
        // add JButtons to the jframe
        frame.getContentPane().add(btnAdd);
        frame.getContentPane().add(poistaRivi);
        frame.getContentPane().add(btnUpdate);
        
        JLabel lblTeoksenNimi = new JLabel("Teoksen nimi");
        lblTeoksenNimi.setBounds(130, 225, 85, 14);
        frame.getContentPane().add(lblTeoksenNimi);
        
        JLabel lblTeoksenTekij = new JLabel("Teoksen tekij\u00E4");
        lblTeoksenTekij.setBounds(130, 255, 85, 14);
        frame.getContentPane().add(lblTeoksenTekij);
        
        JLabel lblJulkaisuvuosi = new JLabel("Julkaisuvuosi");
        lblJulkaisuvuosi.setBounds(132, 285, 83, 14);
        frame.getContentPane().add(lblJulkaisuvuosi);
        
        
        
        JLabel lblIndeksi = new JLabel("Indeksi");
        lblIndeksi.setBounds(130, 197, 46, 14);
        frame.getContentPane().add(lblIndeksi);
        
        JLabel lblOhjeIndeksiJa = new JLabel("Ohje: Indeksi ja julkaisuvuosi pit\u00E4\u00E4 olla uniikkeja lis\u00E4\u00E4ksesi ne tietokantaan!");
        lblOhjeIndeksiJa.setBounds(233, 285, 385, 14);
        frame.getContentPane().add(lblOhjeIndeksiJa);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu mnOhjeet = new JMenu("Tiedosto");
        menuBar.add(mnOhjeet);
        
        JMenuItem mntmOhjeet = new JMenuItem("Ohjeet");
        mntmOhjeet.setIcon(new ImageIcon(K�ytt�liittym�.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
        mnOhjeet.add(mntmOhjeet);
        
        JMenuItem mntmSulje = new JMenuItem("Sulje");
        mntmSulje.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        mntmSulje.setIcon(new ImageIcon(K�ytt�liittym�.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
        mnOhjeet.add(mntmSulje);
        
        JMenu mnTietojaOhjelmasta = new JMenu("Tietoja ohjelmasta");
        mnTietojaOhjelmasta.setIcon(null);
        menuBar.add(mnTietojaOhjelmasta);
        
        JMenuItem mntmVersiotiedot = new JMenuItem("Versiotiedot");
        mntmVersiotiedot.setIcon(new ImageIcon(K�ytt�liittym�.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
        mnTietojaOhjelmasta.add(mntmVersiotiedot);
        frame.setVisible(true);
        
        // create an array of objects to set the row data
        Object[] rivi = new Object[4];
        
       
        
        
        try {

			String URL = "jdbc:mysql://remotemysql.com:3306";
			String dbname = "QpLNBmWat5";
			String USER = "QpLNBmWat5";
			String PASS = "Xmq1q2DvGL";

			// Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/kirjasto", "root", "");
			Connection con = DriverManager.getConnection(URL + "/" + dbname, USER, PASS);
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM kirjat");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
				 rivi[0] = rs.getString(1);
                 rivi[1] = rs.getString(2);
                 rivi[2] = rs.getString(3);
                 rivi[3] = rs.getString(4);
           // add row to the model
           model.addRow(rivi);
				
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
        
        mntmOhjeet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Ohjeet.ohjeitaIkkuna();
        	}
        });
        
        
        mntmVersiotiedot.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Ohjelmatietoja.tietojaIkkuna();
        	}
        });
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
         
            	 if(teosInput.getText().isEmpty() || tekijaInput.getText().isEmpty() || vuosiInput.getText().isEmpty()) {
            		 JOptionPane.showMessageDialog(frame, "�l� j�t� tietueita tyhj�ksi!");
            	 } else {
            		 rivi[0] = indeksiInput.getText();
            		 rivi[1] = teosInput.getText();
                     rivi[2] = tekijaInput.getText();
                     rivi[3] = vuosiInput.getText();
               
               // add row to the model
                     
               model.addRow(rivi);
            	 }
             		
                
                
                
            }
        });
        
        // button remove row
        poistaRivi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	 try {
            		 
            		 int i = table.getSelectedRow();
            		 System.out.println(i);
            		
            	//Yhteys tietokantaan
            	
    			Connection con = DriverManager.getConnection(URL + "/" + dbname, USER, PASS);
    			Statement stmt = con.createStatement();
    			stmt.executeUpdate("DELETE FROM kirjat WHERE teoksenNimi = ('" + table.getValueAt(i, 1) +"');");
//    			
    			//Suljetaan yhteys
    			con.close();
                // i = the index of the selected row
              
             
                if(i >= 0){
                    // remove a row from jtable
                	
                	
                    model.removeRow(i);
                    
                   
                }
                else{
                    System.out.println("Delete Error");
                }
                
                
             
        		
        			
        		} catch (SQLException e1) {
        			System.out.println("Error in deleting row.");
        			System.out.println(e1);
        		}
            }
            
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            indeksiInput.setText(model.getValueAt(i, 0).toString());
            teosInput.setText(model.getValueAt(i, 1).toString());
            tekijaInput.setText(model.getValueAt(i, 2).toString());
            vuosiInput.setText(model.getValueAt(i, 3).toString());
      
        }
        });
        
        
        
        
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
            	
            	Connection con;
				try {
					con = DriverManager.getConnection(URL + "/" + dbname, USER, PASS);
					Statement stmt = con.createStatement();
					
					int m��r� = table.getRowCount();
					System.out.println(m��r�);
					System.out.println(table.getValueAt(0, 0));
					for(int i = 0; i < m��r�; i++) {
						
						stmt.executeUpdate("REPLACE INTO kirjat VALUES (" + table.getValueAt(i, 0) + ",'"+ table.getValueAt(i, 1) + "', '" + table.getValueAt(i, 2) + "', '" + table.getValueAt(i, 3) +"');");
					}
					
//					"INSERT INTO `kirjat` VALUES" (9, '�l� pakota minua ajattelemaan', 'Krug, Steve', 2006)
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
	    			
            }
        });
        
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
}
