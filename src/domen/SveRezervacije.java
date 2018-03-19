package domen;

public class SveRezervacije {

	
	private int idKorisnik,idPredstava,idRezervisanaKarta;
	private String imePrezime;
	private String predstava;
	private String datum;
	private String pocetak;
	private int kolicina;
	private int cena;
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public int getIdKorisnik() {
		return idKorisnik;
	}
	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}
	public int getIdPredstava() {
		return idPredstava;
	}
	public void setIdPredstava(int idPredstava) {
		this.idPredstava = idPredstava;
	}
	public int getIdRezervisanaKarta() {
		return idRezervisanaKarta;
	}
	public void setIdRezervisanaKarta(int idRezervisanaKarta) {
		this.idRezervisanaKarta = idRezervisanaKarta;
	}
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
		this.predstava = predstava;
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
	
	
	
}
