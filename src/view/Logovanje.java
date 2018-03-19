package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.Validator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Kontroler.Kontroler;
import domen.Korisnik;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Logovanje extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JLabel lblImage;
	private int idKorisnik;
	private JPasswordField tfPass;
	private int prioritet=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logovanje frame = new Logovanje();
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
	public Logovanje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(174, 83, 393, 251);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUser = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/gost.png")).getImage();
		lblUser.setIcon(new ImageIcon(img5));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBounds(158, 41, 42, 33);
		panel.add(lblUser);

		JLabel lblPassword = new JLabel("");
		Image img6 = new ImageIcon(this.getClass().getResource("/katanac.png")).getImage();
		lblPassword.setIcon(new ImageIcon(img6));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(158, 100, 42, 33);
		panel.add(lblPassword);

		tfUser = new JTextField();
		tfUser.setBounds(210, 43, 175, 31);
		panel.add(tfUser);
		tfUser.setColumns(10);

		JButton btnLogin = new JButton("LogIn");
		btnLogin.setBackground(Color.WHITE);
		Image img1 = new ImageIcon(this.getClass().getResource("/ok1.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img1));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String user = tfUser.getText().toString(); // Collecting the
				String pass = tfPass.getText().toString();

				for (Korisnik k : Kontroler.getInstanca().vratiKorisnike()) {

					if (user.equals(k.getUserName()) && pass.equals(k.getPassword()))

						idKorisnik = k.getIdKorisnik();

				}
				if (tfUser.getText().length() == 0) { // Checking for empty
														// field
					JOptionPane.showMessageDialog(null, "Neko polje je ostalo prazno,popunite ga za nastavak");
				} else if (tfPass.getText().length() == 0) { // Checking for
																// empty
																// field
					JOptionPane.showMessageDialog(null, "Neko polje je ostalo prazno,popunite ga za nastavak");

				} else if (proveraKorisnika(user, pass,prioritet=0)) {

					RepertoarForma rf = new RepertoarForma(user, idKorisnik);

					rf.setVisible(true);
					dispose();

				}

				if (proveraKorisnika(user,pass,prioritet=1)) {

					MedjuForma mf = new MedjuForma(user);
					mf.setVisible(true);
					dispose();
				}else{
					
					
				}

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnLogin.setBounds(210, 194, 175, 33);
		panel.add(btnLogin);

		JButton btnRegistracija = new JButton("Registracija");
		btnRegistracija.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		Image img2 = new ImageIcon(this.getClass().getResource("/prijava1.png")).getImage();
		btnRegistracija.setIcon(new ImageIcon(img2));
		btnRegistracija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				KorisnikForma kf = new KorisnikForma();
				kf.setVisible(true);
			}
		});
		btnRegistracija.setBounds(41, 194, 159, 33);
		panel.add(btnRegistracija);

		tfPass = new JPasswordField();
		tfPass.setBounds(210, 100, 175, 33);
		panel.add(tfPass);

		JCheckBox cbPrikaz = new JCheckBox("prikazi sifru");
		cbPrikaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbPrikaz.isSelected()) {

					tfPass.setEchoChar((char) 0);
				} else {
					tfPass.setEchoChar('*');
				}
			}
		});
		cbPrikaz.setBounds(210, 140, 97, 23);
		panel.add(cbPrikaz);

		JLabel lblNewLabel = new JLabel("Dobrodosli,ulogujte se !!!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		lblNewLabel.setBounds(158, 11, 272, 39);
		contentPane.add(lblNewLabel);

		lblImage = new JLabel("");
		lblImage.setBackground(Color.LIGHT_GRAY);
		Image img = new ImageIcon(this.getClass().getResource("/pozoriste.png")).getImage();
		lblImage.setIcon(new ImageIcon(img));
		lblImage.setBounds(20, 83, 156, 224);
		contentPane.add(lblImage);
		Image img3 = new ImageIcon(this.getClass().getResource("/gost.png")).getImage();

		JLabel lblInfo = new JLabel(
				"* Da biste u potpunosti koristili aplikaciju ,potrebno je da se registrujete ,odnosno ulogujete !");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfo.setBounds(10, 388, 557, 14);
		contentPane.add(lblInfo);
		Image img4 = new ImageIcon(this.getClass().getResource("/crna.png")).getImage();
	}

	

	protected boolean proveraKorisnika(String user, String pass,int prioritet ) {
		// TODO Auto-generated method stub
		boolean primer = Kontroler.getInstanca().proveraKorisnika(user, pass,prioritet);
		return primer;
	}
}