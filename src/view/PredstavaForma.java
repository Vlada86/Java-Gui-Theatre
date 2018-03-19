package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Kontroler.Kontroler;

import domen.Autor;

import domen.Pozoriste;
import domen.Repertoar;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PredstavaForma extends JFrame {

	private JPanel contentPane;
	private JComboBox cbAutor; 
	private JComboBox cbPozoriste;
	private JLabel lblPozoriste;
	private JLabel lblNewLabel;
	private JTextField tfNazivP;
	private JTextField tfPocetak;
	private JTextField tfKraj;
	private JTextField tfUkupnoSedista;
	private JTextField tfCena;
	private JLabel lblPredstava;
	private JLabel lblDate;
	private JLabel lblPocetak;
	private JLabel lblKraj;
	private JLabel lblUkupnoSedista;
	private JLabel lblCena;
	private  int idPozorista;
	private String ime;
	private int autor1;
	private JButton btnDodaj;
	private JDateChooser dateChooser;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JButton btnBrisi;
	private int id,id1,id2;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PredstavaForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbPozoriste = new JComboBox();
		cbPozoriste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String pozoriste = cbPozoriste.getSelectedItem().toString();
				for(Pozoriste p : Kontroler.getInstanca().vratiPozorista()){
					
					if(pozoriste.equals(p.getNaziv())){
						idPozorista = p.getId();
						
					}
				}
			}
		});
		cbPozoriste.setBounds(36, 44, 212, 20);
		contentPane.add(cbPozoriste);
		
		cbAutor = new JComboBox();
		cbAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String autor = cbAutor.getSelectedItem().toString();
				for(Autor a : Kontroler.getInstanca().vratiAutore()){
					
					if(autor.equals(a.getAutor())){
						
						autor1= a.getId();
					}
				}
			}
		});
		cbAutor.setBounds(349, 44, 217, 20);
		contentPane.add(cbAutor);
		
		lblPozoriste = new JLabel("Izaberi pozoriste");
		lblPozoriste.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPozoriste.setBounds(86, 11, 162, 14);
		contentPane.add(lblPozoriste);
		
		lblNewLabel = new JLabel("Izaberi autora");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(349, 11, 155, 14);
		contentPane.add(lblNewLabel);
		
		tfNazivP = new JTextField();
		tfNazivP.setBounds(253, 149, 162, 20);
		contentPane.add(tfNazivP);
		tfNazivP.setColumns(10);
		
		tfPocetak = new JTextField();
		tfPocetak.setBounds(253, 211, 162, 20);
		contentPane.add(tfPocetak);
		tfPocetak.setColumns(10);
		
		tfKraj = new JTextField();
		tfKraj.setBounds(253, 242, 162, 20);
		contentPane.add(tfKraj);
		tfKraj.setColumns(10);
		
		tfUkupnoSedista = new JTextField();
		tfUkupnoSedista.setBounds(253, 273, 162, 20);
		contentPane.add(tfUkupnoSedista);
		tfUkupnoSedista.setColumns(10);
		
		tfCena = new JTextField();
		tfCena.setBounds(253, 304, 162, 20);
		contentPane.add(tfCena);
		tfCena.setColumns(10);
		
		lblPredstava = new JLabel("Naziv predstave :");
		lblPredstava.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPredstava.setBounds(36, 149, 141, 17);
		contentPane.add(lblPredstava);
		
		lblDate = new JLabel("Datum predstave :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(36, 183, 141, 17);
		contentPane.add(lblDate);
		
		lblPocetak = new JLabel("Pocetak predstave :");
		lblPocetak.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPocetak.setBounds(36, 211, 141, 17);
		contentPane.add(lblPocetak);
		
		lblKraj = new JLabel("Kraj predstave :");
		lblKraj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKraj.setBounds(36, 239, 141, 17);
		contentPane.add(lblKraj);
		
		lblUkupnoSedista = new JLabel("Ukupno mesta :");
		lblUkupnoSedista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUkupnoSedista.setBounds(36, 267, 141, 17);
		contentPane.add(lblUkupnoSedista);
		
		lblCena = new JLabel("Cena karte : ");
		lblCena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCena.setBounds(36, 304, 141, 17);
		contentPane.add(lblCena);
		
		btnDodaj = new JButton("Dodaj Predstavu");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
				String predstava = tfNazivP.getText().toString();
				String datum =df.format(dateChooser.getDate());
				String pocetak = tfPocetak.getText().toString();
				String kraj = tfKraj.getText().toString();
				String ukupnoMesta = tfUkupnoSedista.getText().toString();
				String cena = tfCena.getText().toString();
				
				Kontroler.getInstanca().upisiPredstavu(idPozorista,autor1,predstava,datum,pocetak,kraj,ukupnoMesta,cena);
				vidiRepertoar();
			}
		});
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDodaj.setBounds(253, 335, 162, 23);
		contentPane.add(btnDodaj);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(253, 180, 162, 20);
		contentPane.add(dateChooser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 385, 881, 193);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		btnBrisi = new JButton("Izbrisi predstavu ");
		btnBrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				for(Repertoar rp : Kontroler.getInstanca().repertoarPredstava()){
					
					if(id == rp.getIdPredstava()){
						id1=rp.getIdAutor();
						id2=rp.getIdPozorista();
						
					}
				}
				
				Kontroler.getInstanca().izbrisiPredstavu(id,id1,id2);
				vidiRepertoar();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Ne mozete obrisati predstavu zato sto je vec rezervisana ");
				}
			}
		});
		btnBrisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBrisi.setBounds(465, 337, 162, 23);
		contentPane.add(btnBrisi);
		
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
		
		srediCombo();
		vidiRepertoar();
		
		table.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int red = table.getSelectedRow();
				String idPredstave= null;
				
				idPredstave=(table.getModel().getValueAt(red, 0).toString());
				id=Integer.valueOf(idPredstave);
				
				
			}
		});
	}
	

	private void vidiRepertoar() {
		// TODO Auto-generated method stub
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

	private void srediCombo() {
		// TODO Auto-generated method stub
		for(Pozoriste p :Kontroler.getInstanca().vratiPozorista()) {
			
			cbPozoriste.addItem(p.getNaziv());
		
			
		}
		for(Autor a : Kontroler.getInstanca().vratiAutore()) {
			
			cbAutor.addItem(a.getAutor());
	}
}
}
