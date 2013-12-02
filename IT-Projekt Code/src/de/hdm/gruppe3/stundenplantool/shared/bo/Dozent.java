package de.hdm.gruppe3.stundenplantool.shared.bo;

import java.util.ArrayList;

public class Dozent extends BusinessObject {

	// Instanzvariablen bzw. Membervariablen
	private static final long serialVersionUID = 1L;

	private String vorname;
	private String nachname;
	private ArrayList<Lehrveranstaltung> veranstaltungen = new ArrayList<Lehrveranstaltung>();

	// Konstruktor
	public Dozent(String vorname, String nachname,
			ArrayList<Lehrveranstaltung> veranstaltungen) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.veranstaltungen = veranstaltungen;
	}

	// Getter und Setter
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public ArrayList<Lehrveranstaltung> getVeranstaltungen() {
		return veranstaltungen;
	}

	public void setVeranstaltungen(ArrayList<Lehrveranstaltung> veranstaltungen) {
		this.veranstaltungen = veranstaltungen;
	}

}
