package domen;

public class Predstava {
	
	private int idPredstava;
	private String naziv;
	private String datum;
	private String pocetak;
	private String kraj;
	private int kolicina;
	private int ukupnoSedista;
	private double cena;
	private int idRezervisanaKarta; 
	
	
	
	
	
	public int getIdRezervisanaKarta() {
		return idRezervisanaKarta;
	}
	public void setIdRezervisanaKarta(int idRezervisanaKarta) {
		this.idRezervisanaKarta = idRezervisanaKarta;
	}
	public Predstava(int idPredstava, String naziv, String datum, String pocetak, int kolicina, int ukupnoSedista,
			double cena) {
		super();
		this.idPredstava = idPredstava;
		this.naziv = naziv;
		this.datum = datum;
		this.pocetak = pocetak;
		this.kolicina = kolicina;
		this.ukupnoSedista = ukupnoSedista;
		this.cena = cena;
	}
	public int getIdPredstava() {
		return idPredstava;
	}
	public void setIdPredstava(int idPredstava) {
		this.idPredstava = idPredstava;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
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
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public int getUkupnoSedista() {
		return ukupnoSedista;
	}
	public void setUkupnoSedista(int ukupnoSedista) {
		this.ukupnoSedista = ukupnoSedista;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	
	
	
}
