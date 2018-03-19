package Kontroler;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import broker.DBKomunikacija;
import domen.Autor;
import domen.Korisnik;
import domen.MojeRezervacije;
import domen.Pozoriste;
import domen.Predstava;
import domen.Repertoar;
import domen.SveRezervacije;

public class Kontroler {

	private static Kontroler instanca;

	private ArrayList<Korisnik> alKorisnik = new ArrayList<>();
	private ArrayList<Repertoar> alRep = new ArrayList<>();
	private ArrayList<Pozoriste> alPoz = new ArrayList<>();
	private ArrayList<Autor> alAutor = new ArrayList<>();
	private ArrayList<SveRezervacije> alSve = new ArrayList<>();
	private ArrayList<MojeRezervacije> alMoje = new ArrayList<>();

	public static Kontroler getInstanca() {

		if (instanca == null) {

			instanca = new Kontroler();
		}

		return instanca;

	}

	public void upisiKorisnika(String imePrezime, String userName, String password, String date, String telefon) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().upisiKorisnika(imePrezime, userName, password, date, telefon);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}

	public void prikaziPodatkeNaTabelu() {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().prikaziPodatkeNaTabelu();
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}

	public ArrayList<Repertoar> getAlRep() {
		return alRep;
	}

	public void setAlRep(ArrayList<Repertoar> alRep) {
		this.alRep = alRep;
	}

	public ArrayList<Korisnik> vratiKorisnike() {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		alKorisnik = DBKomunikacija.getBroker().vratiKorisnike();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		return alKorisnik;
	}

	public ArrayList<Pozoriste> vratiPozorista() {
		// TODO Auto-generated method stub

		DBKomunikacija.getBroker().otvoriKonekciju();
		alPoz = DBKomunikacija.getBroker().vratiPozorista();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		return alPoz;
	}

	public boolean proveraKorisnika(String user, String pass, int prioritet) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		boolean prom = DBKomunikacija.getBroker().proveraKorisnika(user, pass,prioritet);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		return prom;

	}

	public ArrayList<Repertoar> repertoarPredstava() {
		// TODO Auto-generated method stub

		DBKomunikacija.getBroker().otvoriKonekciju();
		alRep = DBKomunikacija.getBroker().repertoarPredstava();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		return alRep;
	}

	public void upisiRezervaciju(int idKorisnik, int predstava, int ukupnoMesta, int kolicina) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().upisiRezervaciju(idKorisnik, predstava, ukupnoMesta,kolicina);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}

	

	public void dodajPozoriste(String naziv) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().dodajPozoriste(naziv);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}

	public void upisiAutore(String autor) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().upisiAutore(autor);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}

	public ArrayList<Autor> vratiAutore() {
		// TODO Auto-generated method stub

		DBKomunikacija.getBroker().otvoriKonekciju();
		alAutor = DBKomunikacija.getBroker().vratiAutore();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		return alAutor;
	}

	public void upisiPredstavu(int idPozorista, int autor1, String predstava, String datum, String pocetak, String kraj,
			String ukupnoMesta, String cena) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().upisiPredstavu(idPozorista, autor1, predstava, datum, pocetak, kraj, ukupnoMesta,
				cena);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}

	public ArrayList<SveRezervacije> vratiSveRezervacije() {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		alSve = DBKomunikacija.getBroker().vratiSveRezervacije();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		return alSve;
	}

	public void otkaziRezervaciju( int idRezervisanaKarta, int predstava,int ukupnoMesta) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().otkaziRezervaciju( idRezervisanaKarta, predstava, ukupnoMesta);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}

	public ArrayList<MojeRezervacije> mojeRezervacije(int idKorisnik) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		alMoje = DBKomunikacija.getBroker().mojeRezervacije(idKorisnik);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		return alMoje;
	}

	public void izbrisiPredstavu(int id ,int id1 ,int id2) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izbrisiPredstavu(id,id1,id2);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}

	public void izmenirezervaciju(int idRezervisanaKarta,int predstava,int ukupnoMesta ,String string) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izmenirezervaciju(idRezervisanaKarta,predstava,ukupnoMesta,string);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}

}
