import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class L�mp�tilamuunnin {
	public static void main(String[] args) {
		
		JFrame ikkuna = new JFrame("Celcius Converter");
		
		
		GridLayout sijoittelija = new GridLayout(2,2);
		ikkuna.getContentPane().setLayout(sijoittelija);
		
		JLabel celciusOtsikko = new JLabel();
		celciusOtsikko.setText("Celcius");
		celciusOtsikko.setBackground(Color.lightGray);
		JTextField sy�te = new JTextField();
			
		JLabel fahrenheitOtsikko = new JLabel();
		fahrenheitOtsikko.setText("Fahrenheit: ");
		fahrenheitOtsikko.setBackground(Color.lightGray);
		
		
		JButton nappula = new JButton("Convert");
		
		nappula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String celciusM��r� = sy�te.getText();
				int numeraalinenM��r� = Integer.parseInt(celciusM��r�);
				
				double tulos = (numeraalinenM��r� * 1.8) + 32;
				
				fahrenheitOtsikko.setText(fahrenheitOtsikko.getText() + tulos);
				
			}
		});
		
		ikkuna.getContentPane().add(celciusOtsikko);
		ikkuna.getContentPane().add(sy�te);
		ikkuna.getContentPane().add(nappula);
		ikkuna.getContentPane().add(fahrenheitOtsikko);
		
		
		
		ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ikkuna.setSize(400, 100);
		ikkuna.setVisible(true);

	}

	
}