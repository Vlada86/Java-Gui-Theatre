package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kontroler.Kontroler;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class KorisnikForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfImePrezime;
	private JTextField tfUser;
	private JTextField tfPass;
	private JTextField tfTelefon;
	private String imePrezime;
	private String userName;
	private String password;
	private String date;
	private String telefon;
	private JDateChooser dcDatum;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public KorisnikForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 629, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistracija = new JLabel("Registracija !!!");
		lblRegistracija.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblRegistracija.setBounds(189, 35, 306, 36);
		contentPane.add(lblRegistracija);
		
		tfImePrezime = new JTextField();
		tfImePrezime.setBounds(425, 143, 153, 20);
		contentPane.add(tfImePrezime);
		tfImePrezime.setColumns(10);
		
		tfUser = new JTextField();
		tfUser.setBounds(425, 207, 153, 20);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		tfPass = new JTextField();
		tfPass.setBounds(425, 267, 153, 20);
		contentPane.add(tfPass);
		tfPass.setColumns(10);
		
		tfTelefon = new JTextField();
		tfTelefon.setBounds(425, 382, 153, 20);
		contentPane.add(tfTelefon);
		tfTelefon.setColumns(10);
		Image img2= new ImageIcon(this.getClass().getResource("/download.png")).getImage();
		
		JLabel lblImePrezime = new JLabel("Ime i prezime :");
		lblImePrezime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImePrezime.setBounds(273, 143, 89, 17);
		contentPane.add(lblImePrezime);
		
		JLabel lblzvezda = new JLabel("*");
		lblzvezda.setForeground(Color.RED);
		lblzvezda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblzvezda.setBounds(396, 144, 19, 14);
		contentPane.add(lblzvezda);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(396, 208, 19, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(396, 268, 19, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(396, 325, 19, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(396, 383, 19, 14);
		contentPane.add(label_3);
		
		JLabel lblUserName = new JLabel("Username : ");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(273, 207, 89, 17);
		contentPane.add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("* Obavezna polja za unos ! ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(375, 523, 211, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblPass = new JLabel("Password :");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPass.setBounds(273, 267, 89, 17);
		contentPane.add(lblPass);
		
		JLabel lblDate = new JLabel("Datum rodjenja : ");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(273, 324, 113, 17);
		contentPane.add(lblDate);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(273, 382, 100, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblImage = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		lblImage.setIcon(new ImageIcon(img3));
		lblImage.setBounds(38, 82, 170, 357);
		contentPane.add(lblImage);
		
		JButton btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image img4 = new ImageIcon(this.getClass().getResource("/download.png")).getImage();
		btnSacuvaj.setIcon(new ImageIcon(img4));
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
				
				 if(tfImePrezime.getText().length()==0)  // Checking for empty field
				      JOptionPane.showMessageDialog(null, "NEKO POLJE JE OSTALO PRAZNO,POPUNITE GA ZA NASTAVAK !");
				   else if(tfUser.getText().length ()==0)  // Checking for empty field
				      JOptionPane.showMessageDialog(null, "NEKO POLJE JE OSTALO PRAZNO,POPUNITE GA ZA NASTAVAK !");
				   else if(tfPass.getText().length()==0)  // Checking for empty field
				      JOptionPane.showMessageDialog(null, "NEKO POLJE JE OSTALO PRAZNO,POPUNITE GA ZA NASTAVAK !");
				   else if(dcDatum.getDate() == null)  // Checking for empty field
				      JOptionPane.showMessageDialog(null, "NEKO POLJE JE OSTALO PRAZNO,POPUNITE GA ZA NASTAVAK !");
				   else if(tfTelefon.getText().length ()==0)  // Checking for empty field
					      JOptionPane.showMessageDialog(null, "NEKO POLJE JE OSTALO PRAZNO,POPUNITE GA ZA NASTAVAK !");
				   else{
				try {
				String imePrezime = tfImePrezime.getText().toString();
				String userName = tfUser.getText().toString();
				String password = tfPass.getText().toString();
				String date =df.format(dcDatum.getDate());
				String telefon = tfTelefon.getText().toString();
				
				Kontroler.getInstanca().upisiKorisnika(imePrezime,userName,password,date,telefon);
				JOptionPane.showMessageDialog(null,"Uspesna registracija");
				
				}catch(Exception e1) {
				
				
				}
			}
			}
		});
		btnSacuvaj.setBounds(450, 451, 128, 23);
		contentPane.add(btnSacuvaj);
		
		JButton btnNazad = new JButton("Nazad");
		Image img5 = new ImageIcon(this.getClass().getResource("/nazad1.png")).getImage();
		btnNazad.setIcon(new ImageIcon(img5));
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Logovanje l = new Logovanje();
				l.setVisible(true);
				dispose();
			}
		});
		btnNazad.setBounds(10, 11, 105, 23);
		contentPane.add(btnNazad);
		
		dcDatum = new JDateChooser();
		dcDatum.setBounds(425, 319, 153, 20);
		contentPane.add(dcDatum);
		
	
		
	}
}
