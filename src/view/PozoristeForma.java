package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kontroler.Kontroler;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PozoristeForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfPozoriste;
	private String user;
	private JLabel lblUser;
	private JLabel lblAdmin;
	private JButton btnDalje;
	private JButton btnDodaj;
	private String naziv;
	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 * @param user 
	 */
	public PozoristeForma(String user) {
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfPozoriste = new JTextField();
		tfPozoriste.setBounds(135, 121, 231, 20);
		contentPane.add(tfPozoriste);
		tfPozoriste.setColumns(10);
		
		JLabel lblNaziv = new JLabel("Unesi Pozoriste ");
		lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNaziv.setBounds(135, 90, 231, 20);
		contentPane.add(lblNaziv);
		
		lblUser = new JLabel("Ulogovani ste kao :");
		lblUser.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblUser.setBounds(10, 11, 124, 20);
		contentPane.add(lblUser);
		
		lblAdmin = new JLabel("");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAdmin.setBounds(10, 42, 110, 20);
		contentPane.add(lblAdmin);
		lblAdmin.setText(user);
		
		btnDalje = new JButton("Nastavi");
		btnDalje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AutorForma af = new AutorForma();
				af.setVisible(true);
			}
			
		});
		btnDalje.setBounds(420, 289, 124, 23);
		contentPane.add(btnDalje);
		
		btnDodaj = new JButton("Dodaj u bazu");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				naziv = tfPozoriste.getText().toString();
				Kontroler.getInstanca().dodajPozoriste(naziv);
			}
		});
		btnDodaj.setBounds(420, 120, 124, 23);
		contentPane.add(btnDodaj);
	}
}
