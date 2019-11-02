package main;

public class Pesma {
	private int id;
	private String izvodjac;
	private String ime;
	private String album;
	private int trajanjeSekunde;
	
	
	
	public Pesma() {}
	public Pesma(int id, String izvodjac, String ime, String album, int trajanjeSekunde) {
		this.id = id;
		this.izvodjac = izvodjac;
		this.ime = ime;
		this.album = album;
		this.trajanjeSekunde = trajanjeSekunde;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getIzvodjac() {
		return izvodjac;
	}
	public void setIzvodjac(String izvodjac) {
		this.izvodjac = izvodjac;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getTrajanjeSekunde() {
		return trajanjeSekunde;
	}
	public void setTrajanjeSekunde(int trajanjeSekunde) {
		this.trajanjeSekunde = trajanjeSekunde;
	}
	
	
}
