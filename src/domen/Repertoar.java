package domen;

public class Repertoar {

	
	private int idPozorista,idAutor,idPredstava,ukupnoSedista;
	private int idRezervisanaKarta;
	public int getIdRezervisanaKarta() {
		return idRezervisanaKarta;
	}
	public void setIdRezervisanaKarta(int idRezervisanaKarta) {
		this.idRezervisanaKarta = idRezervisanaKarta;
	}
	private String ime;
	private String naziv;
	private String datum;
	private String pocetak;
	private String kraj;
	private double cena;
	private String autor,rezija;
	public int getIdPozorista() {
		return idPozorista;
	}
	public void setIdPozorista(int idPozorista) {
		this.idPozorista = idPozorista;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public int getIdPredstava() {
		return idPredstava;
	}
	public void setIdPredstava(int idPredstava) {
		this.idPredstava = idPredstava;
	}
	public int getUkupnoSedista() {
		return ukupnoSedista;
	}
	public void setUkupnoSedista(int ukupnoSedista) {
		this.ukupnoSedista = ukupnoSedista;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
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
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getRezija() {
		return rezija;
	}
	public void setRezija(String rezija) {
		this.rezija = rezija;
	}
	
	
}
