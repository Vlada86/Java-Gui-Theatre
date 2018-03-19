package broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domen.Autor;
import domen.Korisnik;
import domen.MojeRezervacije;
import domen.Pozoriste;
import domen.Predstava;

import domen.Repertoar;
import domen.SveRezervacije;

public class DBKomunikacija {

	public static DBKomunikacija broker;
	private Connection con;

	private DBKomunikacija() {

		ucitajDriver();
	}

	private void ucitajDriver() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void otvoriKonekciju() {

		try {
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pozoriste?" + "user=root&password=vv24041986");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void zatvoriKonekciju() {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DBKomunikacija getBroker() {

		if (broker == null) {

			broker = new DBKomunikacija();
		}

		return broker;
	}

	public void upisiKorisnika(String imePrezime, String userName, String password, String datumRodjenja,
			String telefon) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO korisnik (imePrezime,userName,password,datumRodjenja,telefon) Values (?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, imePrezime);
			ps.setString(2, userName);
			ps.setString(3, password);
			ps.setString(4, datumRodjenja);
			ps.setString(5, telefon);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	

	public ArrayList<Korisnik> vratiKorisnike() {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		Statement st = null;
		ArrayList<Korisnik> pr1 = new ArrayList<>();
		String sql = "select * from korisnik";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				Korisnik k = new Korisnik();
				k.setIdKorisnik(rs.getInt("idKorisnik"));
				k.setImePrezime(rs.getString("imePrezime"));
				k.setUserName(rs.getString("userName"));
				k.setPassword(rs.getString("password"));
				k.setDatumRodjenja(rs.getString("datumRodjenja"));
				k.setTelefon(rs.getString("telefon"));
				pr1.add(k);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr1;

	}

	public ArrayList<Pozoriste> vratiPozorista() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Statement st = null;
		ArrayList<Pozoriste> poz = new ArrayList<>();
		String sql = "select * from Pozoriste";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				Pozoriste p = new Pozoriste();
				p.setId(rs.getInt("idPozoriste"));
				p.setNaziv(rs.getString("nazivPozorista"));
				poz.add(p);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return poz;

	}

	public ArrayList<Autor> vratiAutore() {

		ResultSet rs = null;
		Statement st = null;
		ArrayList<Autor> ar = new ArrayList<>();
		String sql = "Select * from autor";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				Autor a = new Autor();
				a.setId(rs.getInt("idAutor"));
				a.setAutor(rs.getString("autor"));
				ar.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ar;

		// TODO Auto-generated method stub

	}

	public boolean proveraKorisnika(String user, String pass ,int prioritet) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL database connection
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pozoriste?" + "user=root&password=vv24041986");
			PreparedStatement pst = conn.prepareStatement("Select * from korisnik where userName=? and password=? and prioritet=?");
			pst.setString(1, user);
			pst.setString(2, pass);
			pst.setInt(3, prioritet);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Repertoar> repertoarPredstava() {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT  predstava.idPredstava,pozoriste.nazivPozorista,predstava.naziv,autor.autor,predstava.datum,predstava.pocetak,predstava.kraj,predstava.ukupnoSedista,predstava.Cena From predstava Inner join pozoriste on pozoriste.idPozoriste=predstava.idPozoriste Inner join autor on predstava.idAutor = autor.idautor  WHERE predstava.datum >= CURDATE() + 0 ";
		ArrayList<Repertoar> rep1 = new ArrayList<>();

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				Repertoar r = new Repertoar();

				r.setIdPredstava(rs.getInt("idPredstava"));
				
				r.setIme(rs.getString("nazivPozorista"));
				r.setNaziv(rs.getString("naziv"));
				r.setAutor(rs.getString("autor"));
				r.setDatum(rs.getString("datum"));
				r.setPocetak(String.valueOf(rs.getString("pocetak")));
				r.setKraj(rs.getString("kraj"));
				r.setUkupnoSedista(rs.getInt("ukupnoSedista"));
				r.setCena(rs.getDouble("cena"));
				rep1.add(r);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep1;
	}

	public void upisiRezervaciju(int idKorisnik, int predstava, int ukupnoMesta,int kolicina) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		//int kol = Integer.valueOf(string);
		//System.out.println(kol);
		String sqlK = "Insert into korisnik (idKorisnik) values (?)";
		String sqlP = "Update predstava  Set ukupnoSedista = '" + ukupnoMesta+ "' where idPredstava = '" + predstava
				+ "'";
		String sqlR = " Insert into rezervisanaKarta(idKorisnik,idPredstava,kolicina) values (?,?,?)";

		try {
			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement(sqlR);
			ps.setInt(1, idKorisnik);
			ps.setInt(2, predstava);
			ps.setInt(3, kolicina);

			ps.execute();

			ps = con.prepareStatement(sqlP);
			// ps.setInt(1, slobMesta);
			System.out.println(sqlP);
			ps.execute();
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void dodajPozoriste(String naziv) {
		// TODO Auto-generated method stub
		String sql = " INsert into pozoriste (nazivPozorista) values (?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, naziv);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void upisiAutore(String autor) {
		// TODO Auto-generated method stub
		String sql = " insert into autor (autor) values (?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, autor);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void upisiPredstavu(int idPozorista, int autor1, String predstava, String datum, String pocetak, String kraj,
			String ukupnoMesta, String cena) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		// String sql1 ="Insert into pozoriste(idPozoriste) values (?)";
		// String sql2=" Insert into autor (idAutor) values (?)";
		String sql = "Insert into predstava (idPozoriste,idAutor,naziv,datum,pocetak,kraj,ukupnoSedista,cena) values (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, idPozorista);
			ps.setInt(2, autor1);
			ps.setString(3, predstava);
			ps.setString(4, datum);
			ps.setString(5, pocetak);
			ps.setString(6, kraj);
			ps.setString(7, ukupnoMesta);
			ps.setString(8, cena);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<SveRezervacije> vratiSveRezervacije() {

		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT korisnik.idKorisnik,korisnik.imePrezime ,predstava.naziv,predstava.datum,predstava.pocetak,rezervisanakarta.kolicina,predstava.cena from rezervisanakarta inner join predstava on predstava.idPredstava= rezervisanakarta.idPredstava inner join korisnik on korisnik.idKorisnik = rezervisanakarta.idKorisnik";
		ArrayList<SveRezervacije> sve = new ArrayList<>();

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				SveRezervacije sr = new SveRezervacije();
				sr.setIdKorisnik(rs.getInt("idKorisnik"));
				sr.setImePrezime(rs.getString("imePrezime"));
				sr.setPredstava(rs.getString("naziv"));
				sr.setDatum(rs.getString("datum"));
				sr.setPocetak(rs.getString("pocetak"));
				sr.setKolicina(rs.getInt("kolicina"));
				sr.setCena(rs.getInt("cena"));

				sve.add(sr);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sve;

		// TODO Auto-generated method stub

	}

	public void prikaziPodatkeNaTabelu() {
		// TODO Auto-generated method stub

	}

	public void otkaziRezervaciju(int idRezervisanaKarta, int predstava,int ukupnoMesta) {
		// TODO Auto-generated method stub
		
		Statement st = null;
		ResultSet rs = null;
		//int kol = Integer.valueOf(string);
		//System.out.println(kol);
		//String sqlK = "Insert into korisnik (idKorisnik) values (?)";
		String sqlP = "Update predstava  Set ukupnoSedista = '" + ukupnoMesta + "' where idPredstava = '" + predstava
				+ "'";
		String sqlR = "Delete from rezervisanaKarta where idRezervisanaKarta = " + idRezervisanaKarta + "";

		try {
			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement(sqlP);
		

			
			// ps.setInt(1, slobMesta);
			ps = con.prepareStatement(sqlP);
			System.out.println(sqlP);
			ps.execute();
			
			
			ps = con.prepareStatement(sqlR);
			System.out.println(sqlR);
			ps.execute();
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public ArrayList<MojeRezervacije> mojeRezervacije(int idKorisnik) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT rezervisanaKarta.idrezervisanaKarta,korisnik.imePrezime ,predstava.idPredstava,predstava.naziv,predstava.datum,predstava.pocetak,predstava.cena,predstava.ukupnoSedista,rezervisanakarta.kolicina from rezervisanakarta  inner join predstava on predstava.idPredstava= rezervisanakarta.idPredstava  inner join korisnik on korisnik.idKorisnik = rezervisanakarta.idKorisnik where korisnik.idKorisnik=" + idKorisnik + "";
		ArrayList<MojeRezervacije> moje = new ArrayList<>();
		System.out.println(idKorisnik);
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				
				MojeRezervacije mr = new MojeRezervacije();
				mr.setIdRezervisanaKarta(rs.getInt("idRezervisanaKarta"));
				mr.setImePrezime(rs.getString("imePrezime"));
				mr.setIdPredstava(rs.getInt("idPredstava"));
				mr.setPredstava(rs.getString("naziv"));
				mr.setDatum(rs.getString("datum"));
				mr.setPocetak(rs.getString("pocetak"));
				mr.setCena(rs.getInt("Cena"));
				mr.setUkupnoSedista(rs.getInt("ukupnoSedista"));
				mr.setKolicina(rs.getInt("kolicina"));

				moje.add(mr);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moje;
	}

	public void izbrisiPredstavu(int id ,int id1 ,int id2) {
		// TODO Auto-generated method stub
		String brisanje = "Delete from predstava where idPredstava = " + id + "";
		//String brisanje1 = "Delete from pozoriste where idPozoriste = " + id1 + "";
		//String brisanje2 = "Delete from autor where idAutor = " + id2 + "";
		

		try {
			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement(brisanje);
		

			
			// ps.setInt(1, slobMesta);
			ps = con.prepareStatement(brisanje);
			System.out.println(brisanje);
			ps.execute();
			
			
			/*ps = con.prepareStatement(brisanje1);
			System.out.println(brisanje1);
			ps.execute();
			
			ps = con.prepareStatement(brisanje2);
			System.out.println(brisanje2);
			ps.execute();
			*/
			
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ne mozete obrisati predstavu zato sto je vec rezervisana ");
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		}
	}

	public void izmenirezervaciju(int idRezervisanaKarta,int predstava, int ukupnoMesta ,String string) {
		// TODO Auto-generated method stub
		
		String izmena = "UPDATE rezervisanaKarta SET kolicina = '" + string + "'where idrezervisanaKarta=" + idRezervisanaKarta + "";
		String izmena1 = "UPDATE predstava SET ukupnoSedista = '" + ukupnoMesta + "'where idPredstava=" + predstava + "";


				try {
					con.setAutoCommit(false);

					PreparedStatement ps = con.prepareStatement(izmena);
				

					
					// ps.setInt(1, slobMesta);
					ps = con.prepareStatement(izmena);
					System.out.println(izmena);
					ps.execute();
					
					
					ps = con.prepareStatement(izmena1);
					System.out.println(izmena1);
					ps.execute();
				
					
					
					con.commit();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

	}
}
