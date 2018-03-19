package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Kontroler.Kontroler;
import domen.MojeRezervacije;
import domen.Predstava;
import domen.Repertoar;
import domen.Rezervacija;
import domen.SveRezervacije;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class RezervacijeForma extends JFrame {
	
	
	
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private ArrayList<Predstava> alPred = new ArrayList<>();
	private ArrayList<MojeRezervacije> alMoje= new ArrayList<>();
	private int ukupnaCena =0;
	private JLabel lblUkupnaCena;
	private JLabel lblIznos;
	private JTextField tfKolicina;
	private int idKorisnik;
	private JLabel lblId;
	private int predstava;
	private  int slobMesta;
	private String idPredstava;
	private int ukupnoMesta;
	private String user;
	private int idRezervisanaKarta;
	private int kolicina;
	private String kolicina1;
	private JButton btnIzmeni;
	private int ukupMesta1;
	
	
	
	public RezervacijeForma(int idKorisnik, String user, ArrayList<Predstava> alPredstava, ArrayList<MojeRezervacije> alMoje, int ukupMesta) {
		this.idKorisnik = idKorisnik;
		this.user=user;
		this.alPred = alPredstava;
		this.alMoje=alMoje;
		this.ukupMesta1=ukupMesta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 115, 928, 171);
		contentPane.add(scrollPane);

		table = new JTable(dtm);
		scrollPane.setViewportView(table);

		lblUkupnaCena = new JLabel("UKUPNA CENA :");
		lblUkupnaCena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUkupnaCena.setBounds(10, 297, 111, 14);
		contentPane.add(lblUkupnaCena);

		lblIznos = new JLabel("0.0");
		lblIznos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIznos.setBounds(131, 297, 80, 14);
		contentPane.add(lblIznos);


		tfKolicina = new JTextField();
		tfKolicina.setColumns(10);
		tfKolicina.setBounds(241, 38, 109, 20);
		contentPane.add(tfKolicina);

		JLabel label = new JLabel("Kolicina karata");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(241, 13, 109, 14);
		contentPane.add(label);


		
		JButton btnNazad = new JButton("Nazad");
		Image img5 = new ImageIcon(this.getClass().getResource("/nazad1.png")).getImage();
		btnNazad.setIcon(new ImageIcon(img5));
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				RepertoarForma rf = new RepertoarForma(user,idKorisnik);
				rf.setVisible(true);
			}
		});
		btnNazad.setBounds(10, 11, 111, 23);
		contentPane.add(btnNazad);
		
		JButton btnOtkazi = new JButton("Otkazi rezervaciju");
		btnOtkazi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				for(MojeRezervacije mj : Kontroler.getInstanca().mojeRezervacije(idKorisnik)){
					
					if(idRezervisanaKarta == mj.getIdRezervisanaKarta()){
						predstava=mj.getIdPredstava();
						slobMesta=mj.getUkupnoSedista();
						System.out.println(predstava);
						System.out.println(idRezervisanaKarta);
						
					}
				}
					ukupnoMesta=slobMesta +kolicina;
				
				
				
				Kontroler.getInstanca().otkaziRezervaciju (idRezervisanaKarta,predstava,ukupnoMesta);
				
				
				prikaziRezervacije();
				
				
			}
		});
		btnOtkazi.setBounds(794, 74, 159, 23);
		contentPane.add(btnOtkazi);
		
		btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				for(MojeRezervacije mj : Kontroler.getInstanca().mojeRezervacije(idKorisnik)){
					
					if(idRezervisanaKarta == mj.getIdRezervisanaKarta()){
						predstava=mj.getIdPredstava();
						slobMesta=mj.getUkupnoSedista();
						
					}
				}
				System.out.println(kolicina);
				System.out.println(ukupMesta1);
				int kol=Integer.valueOf(tfKolicina.getText());
				if(kol-kolicina>ukupMesta1 ){
					
					JOptionPane.showMessageDialog(null,"Za zeljenu kolicinu nema dovoljno karata");
				}else if(kol==0  ){
					JOptionPane.showMessageDialog(null,"Unesite zeljenu kolicinu ");
				
				}else if(kol < kolicina){
			
					ukupnoMesta=slobMesta + (kolicina - kol);
				
				Kontroler.getInstanca().izmenirezervaciju(idRezervisanaKarta,predstava,ukupnoMesta,tfKolicina.getText());
				prikaziRezervacije();
				}else if ( kol >kolicina){
					ukupnoMesta = slobMesta + (kolicina - kol);
					Kontroler.getInstanca().izmenirezervaciju(idRezervisanaKarta,predstava,ukupnoMesta,tfKolicina.getText());
					prikaziRezervacije();
					
				}
			}
		});
		btnIzmeni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIzmeni.setBounds(241, 72, 145, 23);
		contentPane.add(btnIzmeni);

		Object[] kolone = new Object[8];
		kolone[0] = "RB";
		kolone[1] = "IME I PREZIME";
		kolone[2] = "PREDSTAVA";
		kolone[3] = "DATUM";
		kolone[4] = "POCETAK";
		kolone[5] = "CENA";
		kolone[6] = "KOLICINA";
		kolone[7]= "UKUPNA CENA";

		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		dtm.addColumn(kolone[6]);
		dtm.addColumn(kolone[7]);
		
		table.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int red = table.getSelectedRow();
				String idRezervisanaKarta1,idKolicina= null;
				
				idRezervisanaKarta1=(table.getValueAt(red, 0).toString());
				idRezervisanaKarta=Integer.valueOf(idRezervisanaKarta1);
				idKolicina = (table.getModel().getValueAt(red, 6).toString());
				kolicina=Integer.valueOf(idKolicina);
				tfKolicina.setText(idKolicina);
				
				
			}
	});
		
		
		//prikaziPodatkeNaTabelu();
		
		prikaziRezervacije();

	}

	
	
	


	private void prikaziRezervacije() {
		// TODO Auto-generated method stub
		dtm.setNumRows(0);
		Object[]redovi = new Object[8];
		for (MojeRezervacije mr : Kontroler.getInstanca().mojeRezervacije(idKorisnik)) {
			
			redovi[0]=mr.getIdRezervisanaKarta();
			redovi[1]=mr.getImePrezime();
			redovi[2]=mr.getPredstava();
			redovi[3]= mr.getDatum();
			redovi[4]=mr.getPocetak();
			redovi[5]=mr.getCena();
			redovi[6]= mr.getKolicina();
			redovi[7] = mr.getKolicina() * mr.getCena();
			ukupnaCena+=(int) redovi[7];
			lblIznos.setText(Double.toString(ukupnaCena));
			dtm.addRow(redovi);
			
	}






	






	/*private void prikaziPodatkeNaTabelu() {
		// TODO Auto-generated method stub
		tfKolicina.setText("0");
		
		dtm.setNumRows(0);
		
		String slobMest=null;
		for (Predstava p : alPred) {

			String id = String.valueOf(p.getIdPredstava());
			String predstava = p.getNaziv();
			String datum = p.getDatum();
			String pocetak = p.getPocetak();
			slobMest = String.valueOf(p.getKolicina());
			String cena = String.valueOf(p.getCena());

			Object[] red = { id, predstava, datum, pocetak, slobMest, cena };
			dtm.addRow(red);
			
			ukupnaCena = p.getKolicina() * p.getCena();
			System.out.println(p.getKolicina()*p.getCena());
			lblIznos.setText(Double.toString(ukupnaCena));
		}
		*/
	}
}
