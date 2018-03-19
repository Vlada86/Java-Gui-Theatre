package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedjuForma extends JFrame {

	private JPanel contentPane;
	private String user;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MedjuForma(String user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDodaj = new JButton("Dodaj predstavu ");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PozoristeForma pf = new PozoristeForma(user);
				pf.setVisible(true);
			}
		});
		btnDodaj.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDodaj.setBounds(122, 137, 157, 53);
		contentPane.add(btnDodaj);
		
		JButton btnVidi = new JButton("Vidi sve rezervacije ");
		btnVidi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SveRezevracijeForma svf = new SveRezevracijeForma();
				svf.setVisible(true);
			}
		});
		btnVidi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVidi.setBounds(336, 137, 164, 53);
		contentPane.add(btnVidi);
	}
}
