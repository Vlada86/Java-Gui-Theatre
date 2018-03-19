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

public class AutorForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfAutor;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AutorForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(159, 86, 178, 20);
		contentPane.add(tfAutor);
		tfAutor.setColumns(10);
		
		JLabel lblAutor = new JLabel("Unesi  autora :");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(159, 47, 98, 17);
		contentPane.add(lblAutor);
		
		JButton btnSacuvaj = new JButton("Dodaj u bazu ");
		btnSacuvaj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String autor = tfAutor.getText().toString();
				
				
				Kontroler.getInstanca().upisiAutore(autor);
			}
		});
		btnSacuvaj.setBounds(381, 85, 153, 23);
		contentPane.add(btnSacuvaj);
		
		JButton btnNext = new JButton("Nastavi sa unosom");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PredstavaForma pf = new PredstavaForma();
				pf.setVisible(true);
			}
		});
		btnNext.setBounds(381, 225, 153, 23);
		contentPane.add(btnNext);
		
		JLabel lblIme = new JLabel("Ime i prezime : ");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIme.setBounds(26, 86, 123, 17);
		contentPane.add(lblIme);
	}

}
