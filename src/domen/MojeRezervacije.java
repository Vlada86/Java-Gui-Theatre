package domen;

import java.util.ArrayList;

public class MojeRezervacije {
	
	
	ArrayList<MojeRezervacije > al = new ArrayList<>();
	
	public ArrayList<MojeRezervacije> getAl() {
		return al;
	}

	public void setAl(ArrayList<MojeRezervacije> al) {
		this.al = al;
	}

	private int idRezervisanaKarta,idPredstava,idKorisnik,cena,kolicina;
	private int ukupnoSedista;
	
	public int getUkupnoSedista() {
		return ukupnoSedista;
	}

	public void setUkupnoSedista(int ukupnoSedista) {
		this.ukupnoSedista = ukupnoSedista;
	}

	private String imePrezime,predstava,datum,pocetak;
	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public String getPredstava() {
		return predstava;
	}

	public void setPredstava(String predstava) {
		this.predstava=predstava;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getPocetak() {
		return pocetak;
	}

	public void setPocetak(String pocetak) {
		this.pocetak = pocetak;
	}

	public int getIdRezervisanaKarta() {
		return idRezervisanaKarta;
	}

	public void setIdRezervisanaKarta(int idRezervisanaKarta) {
		this.idRezervisanaKarta = idRezervisanaKarta;
	}

	public int getIdPredstava() {
		return idPredstava;
	}

	public void setIdPredstava(int idPredstava) {
		this.idPredstava = idPredstava;
	}

	public int getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	

}
