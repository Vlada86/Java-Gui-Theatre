package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.table.DefaultTableModel;

import Kontroler.Kontroler;
import domen.Korisnik;
import domen.MojeRezervacije;
import domen.Pozoriste;
import domen.Predstava;
import domen.Repertoar;
import domen.Rezervacija;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

public class RepertoarForma extends JFrame {
	
	private MojeRezervacije mr = new MojeRezervacije();
	private Rezervacija r = new Rezervacija();
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton rbtnCeo, rbtnDeo;
	private JTextField tfPretraga;
	private JButton btnOsvezi;
	private JButton btnRezervacija;
	private JButton btnNewButton;
	private String imePozorista;
	private int idPozorista;
	private JLabel lblLogin;
	private JLabel lblUser;
	private String user;
	private JLabel lblBrojRez;
	private JLabel lblNewLabel;
	private int redniBrojRezervacije;
	private String imePrezime;
	private int idKorisnik;
	private JLabel lblID;
	private Korisnik korisnik;
	private ArrayList<Repertoar> alReper = new ArrayList<>();
	private JTextField tfKolicina;
	private int slobodnaMesta;
	private int ukupMesta;
	private int idP;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param user 
	 * @param idKorisnik 
	 */
	public RepertoarForma(String user, int idKorisnik) {
		this.user=user;
		this.idKorisnik=idKorisnik;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1389, 582);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 291, 1032, 242);
		panel.add(scrollPane);

		table = new JTable(dtm);
		scrollPane.setViewportView(table);

		rbtnCeo = new JRadioButton("Po celom nazivu ",true);
		rbtnCeo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rbtnCeo.setBounds(152, 162, 109, 23);
		panel.add(rbtnCeo);
		bg.add(rbtnCeo);

		rbtnDeo = new JRadioButton("Po delu naziva",false);
		rbtnDeo.setBounds(303, 162, 109, 23);
		panel.add(rbtnDeo);
		bg.add(rbtnDeo);

		tfPretraga = new JTextField();
		tfPretraga.setBounds(152, 135, 260, 20);
		panel.add(tfPretraga);
		tfPretraga.setColumns(10);

		JLabel lblPretraga = new JLabel("Pretraga predstava ");
		lblPretraga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPretraga.setBounds(235, 104, 135, 20);
		panel.add(lblPretraga);
		
		JButton btnPretraga = new JButton("Pretrazi");
		btnPretraga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Image img5 = new ImageIcon(this.getClass().getResource("/lupa.png")).getImage();
		btnPretraga.setIcon(new ImageIcon(img5));
		
		btnPretraga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pretraziPodatke();
			}
		});
		btnPretraga.setBounds(152, 192, 109, 25);
		panel.add(btnPretraga);
		
		btnOsvezi = new JButton("Osvezi");
		btnOsvezi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Image img4 = new ImageIcon(this.getClass().getResource("/osvezi1.png")).getImage();
		btnOsvezi.setIcon(new ImageIcon(img4));
		btnOsvezi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dtm.setNumRows(0);
				//srediPodatke();
				izbaciPredstave();
			}

			
		});
		btnOsvezi.setBounds(297, 192, 116, 25);
		panel.add(btnOsvezi);
		
		btnRezervacija = new JButton("Dodaj u rezervacije");
		Image img1 = new ImageIcon(this.getClass().getResource("/kanta.png")).getImage();
		btnRezervacija.setIcon(new ImageIcon(img1));
		btnRezervacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int redovi=table.getSelectedRow();
				
				String id =table.getValueAt(redovi,0).toString();
				String naziv = table.getValueAt(redovi,2).toString();
				String datum = table.getValueAt(redovi, 3).toString();
				String pocetak =table.getValueAt(redovi, 4).toString();
				
				String kolicina=tfKolicina.getText().toString();
				String ukupnoMesta = table.getValueAt(redovi,7).toString();
				
				String cena=table.getValueAt(redovi, 8).toString();
				System.out.println(ukupMesta);
				if(Integer.parseInt(kolicina) >Integer.parseInt(ukupnoMesta)){
					JOptionPane.showMessageDialog(null,"Za zeljenu kolicinu nema dovoljno karata");
				}else if(Integer.parseInt(kolicina)==0  ){
					JOptionPane.showMessageDialog(null,"Unesite zeljenu kolicinu ");
				
					
				}
				else if(Integer.parseInt(kolicina) <=Integer.parseInt(ukupnoMesta)){
						Predstava p = new Predstava(Integer.parseInt(id),naziv,datum,pocetak,Integer.parseInt(kolicina),Integer.parseInt(ukupnoMesta),(int) Double.parseDouble(cena));
						r.dodaj(p);
						slobodnaMesta=Integer.parseInt(ukupnoMesta) - Integer.parseInt(kolicina);
						Kontroler.getInstanca().upisiRezervaciju(idKorisnik,Integer.parseInt(id),slobodnaMesta,Integer.parseInt(kolicina));
						lblBrojRez.setText(Integer.toString(r.getAl().size()));
						izbaciPredstave();
					}
			}
				
				
	
				
				
			}
		);
		btnRezervacija.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRezervacija.setBounds(631, 190, 199, 27);
		panel.add(btnRezervacija);
		
		btnNewButton = new JButton("Moje rezervacije");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				RezervacijeForma rf = new RezervacijeForma(idKorisnik,user,r.getAl(),mr.getAl(),ukupMesta);
				rf.setVisible(true);
				System.out.println(ukupMesta);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(866, 190, 141, 27);
		panel.add(btnNewButton);
		
		lblLogin = new JLabel("Ulogovani ste kao :");
		lblLogin.setBounds(10, 11, 120, 23);
		panel.add(lblLogin);
		
		
		
		lblBrojRez = new JLabel("0");
		lblBrojRez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBrojRez.setBounds(1009, 37, 37, 21);
		panel.add(lblBrojRez);
		
		lblNewLabel = new JLabel("Broj dodatih rezervacija :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(831, 37, 153, 20);
		panel.add(lblNewLabel);
		
		
		
		lblUser = new JLabel("");
		lblUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblUser.setBounds(10, 56, 88, 14);
		panel.add(lblUser);
		lblUser.setText(user);
		
		tfKolicina = new JTextField();
		tfKolicina.setText("0");
		tfKolicina.setColumns(10);
		tfKolicina.setBounds(631, 135, 109, 20);
		panel.add(tfKolicina);
		
		JLabel lblKolicina = new JLabel("Kolicina karata");
		lblKolicina.setBounds(631, 109, 109, 14);
		panel.add(lblKolicina);
		
		Object[] kolone = new Object[9];
		kolone[0] = "RB";
		kolone[1]= "POZORISTE";
		kolone[2] = "NAZIV";
		kolone[3] = "DATUM";
		kolone[4] = "POCETAK";
		kolone[5] = "ZAVRSETAK";
		kolone[6] = "AUTOR";
		kolone[7] = "SLOBODNO MESTA";
		kolone[8]= "CENA";
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		dtm.addColumn(kolone[6]);
		dtm.addColumn(kolone[7]);
		dtm.addColumn(kolone[8]);
		
		table.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int red = table.getSelectedRow();
				
				String id = (table.getValueAt(red,1).toString());
				idP=Integer.valueOf(id);
				String slobodnoMesta = null;
				
				slobodnoMesta=(table.getValueAt(red, 7).toString());
				ukupMesta=Integer.valueOf(slobodnoMesta);
				
				
				
			}
	});
		
		
		izbaciPredstave();
		
		
	
	
	}
	

		private void izbaciPredstave(){
			Object[]redovi = new Object[9];
			dtm.setRowCount(0);
			for(Repertoar rp : Kontroler.getInstanca().repertoarPredstava()){
				
				
				redovi[0]=rp.getIdPredstava();
				redovi[1]= rp.getIme();
				redovi[2]=rp.getNaziv();
				redovi[3]=rp.getDatum();
				redovi[4]=rp.getPocetak();
				redovi[5]=rp.getKraj();
				redovi[6]=rp.getAutor();
				redovi[7]=rp.getUkupnoSedista();
				redovi[8]=rp.getCena();
				dtm.addRow(redovi);
	}
		}


	protected void pretraziPodatke() {
		// TODO Auto-generated method stub
		
		
		
		String naziv=tfPretraga.getText();
		dtm.setNumRows(0);
		
		if(rbtnCeo.isSelected()){
			for(Repertoar p : Kontroler.getInstanca().getAlRep()){
				
				if(naziv.equalsIgnoreCase(p.getNaziv())|| naziv.equalsIgnoreCase(p.getIme())){
					
					String id =String.valueOf(p.getIdPozorista());
					String naziv1=p.getIme();
					String predstava = p.getNaziv();
					String datum =String.valueOf(p.getDatum());
					String pocetak = String.valueOf(p.getPocetak());
					String kraj = String.valueOf(p.getKraj());
					String autor = p.getAutor();
					
					String ukupnoKarata=String.valueOf(p.getUkupnoSedista());
					String cena = String.valueOf(p.getCena());
					
					Object[]niz= {id,naziv1,predstava,datum,pocetak,kraj,autor,ukupnoKarata,cena};
					dtm.addRow(niz);
				}
			}}else if(rbtnDeo.isSelected()){
				
				for(Repertoar p :Kontroler.getInstanca().getAlRep()){
					if (p.getNaziv().toLowerCase().contains(tfPretraga.getText().toLowerCase()) || p.getIme().toLowerCase().contains(tfPretraga.getText().toLowerCase())) {
						
						String id =String.valueOf(p.getIdPozorista());
						String naziv1 = p.getIme();
						String predstava = p.getNaziv();
						String datum =String.valueOf(p.getDatum());
						String pocetak = String.valueOf(p.getPocetak());
						String kraj = String.valueOf(p.getKraj());
						String autor=p.getAutor();
						
						String ukupnoKarata=String.valueOf(p.getUkupnoSedista());
						String cena = String.valueOf(p.getCena());
						
						Object[]niz= {id,naziv1,predstava,datum,pocetak,kraj,autor,ukupnoKarata,cena};
						dtm.addRow(niz);
					}
				}
			
			
		
	
		


	;}
			
		
		
	}
	}


