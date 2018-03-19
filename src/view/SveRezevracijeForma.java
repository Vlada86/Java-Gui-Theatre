package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Kontroler.Kontroler;
import domen.SveRezervacije;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SveRezevracijeForma extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SveRezevracijeForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 895, 271);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		Object[] kolone = new Object[8];
		kolone[0] = "RB";
		kolone[1]= "IME I PREZIME ";
		kolone[2] = "PREDSTAVA";
		kolone[3] = "DATUM";
		kolone[4] = "POCETAK";
		kolone[5] = "KOLICINA ";
		kolone[6] = "CENA";
		kolone[7] = "UKUPNO CENA";
		
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		dtm.addColumn(kolone[6]);
		dtm.addColumn(kolone[7]);
	
		
		izbaciSveRezervacije();
	}


	private void izbaciSveRezervacije() {
		// TODO Auto-generated method stub
		double ukupanIznos = 0;
		Object[]redovi = new Object[8];
		dtm.setRowCount(0);

		for(SveRezervacije sr: Kontroler.getInstanca().vratiSveRezervacije()){
			
			redovi[0]=sr.getIdKorisnik();
			redovi[1]=sr.getImePrezime();
			redovi[2]=sr.getPredstava();
			redovi[3]=sr.getDatum();
			redovi[4]=sr.getPocetak();
			redovi[5]=sr.getKolicina();
			redovi[6] = sr.getCena();
			double ukupnaCena = sr.getCena()*sr.getKolicina();
			redovi[7] = ukupnaCena;
			
			dtm.addRow(redovi);
			
		}
	}
}
