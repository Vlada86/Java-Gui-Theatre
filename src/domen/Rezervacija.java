package domen;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Rezervacija {

	
	ArrayList<Predstava > al = new ArrayList<>();
	
	public void dodaj (Predstava p){
		al.add(p);
	}

	public ArrayList<Predstava> getAl() {
		return al;
	}

	public void setAl(ArrayList<Predstava> al) {
		this.al = al;
	}

	private int idKorisnk, idPredstava, idRezervsisanaKarta;


	public int getIdRezervsisanaKarta() {
		return idRezervsisanaKarta;
	}

	public void setIdRezervsisanaKarta(int idRezervsisanaKarta) {
		this.idRezervsisanaKarta = idRezervsisanaKarta;
	}

	private Date datum;
	private String pozoriste;
	private String predstava;
	private Time pocetak;
	private int kolicina;
	private double cena;
	private String imePrezime;

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public int getIdKorisnk() {
		return idKorisnk;
	}

	public void setIdKorisnk(int idKorisnk) {
		this.idKorisnk = idKorisnk;
	}

	public int getIdPredstava() {
		return idPredstava;
	}

	public void setIdPredstava(int idPredstava) {
		this.idPredstava = idPredstava;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getPozoriste() {
		return pozoriste;
	}

	public void setPozoriste(String pozoriste) {
		this.pozoriste = pozoriste;
	}

	public String getPredstava() {
		return predstava;
	}

	public void setPredstava(String predstava) {
		this.predstava = predstava;
	}

	public Time getPocetak() {
		return pocetak;
	}

	public void setPocetak(Time pocetak) {
		this.pocetak = pocetak;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

}
