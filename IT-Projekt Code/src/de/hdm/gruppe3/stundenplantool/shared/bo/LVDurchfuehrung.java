package de.hdm.gruppe3.stundenplantool.shared.bo;

import java.util.ArrayList;

public class LVDurchfuehrung extends BusinessObject {

	// Instanzvariablen bzw. Membervariablen
	private static final long serialVersionUID = 1L;

	private Lehrveranstaltung veranstaltung;
	private ArrayList<Zeitslot> zeitslots = new ArrayList<Zeitslot>();
	private Raum raum;
	private Semesterverband semesterverband;

	// Konstruktor
	public LVDurchfuehrung(Lehrveranstaltung veranstaltung,
			ArrayList<Zeitslot> zeitslots, Raum raum,
			Semesterverband semesterverband) {
		this.veranstaltung = veranstaltung;
		this.zeitslots = zeitslots;
		this.raum = raum;
		this.semesterverband = semesterverband;
	}

	// Getter und Setter
	public Lehrveranstaltung getVeranstaltung() {
		return veranstaltung;
	}

	public void setVeranstaltung(Lehrveranstaltung veranstaltung) {
		this.veranstaltung = veranstaltung;
	}

	public ArrayList<Zeitslot> getZeitslots() {
		return zeitslots;
	}

	public void setZeitslots(ArrayList<Zeitslot> zeitslots) {
		this.zeitslots = zeitslots;
	}

	public Raum getRaum() {
		return raum;
	}

	public void setRaum(Raum raum) {
		this.raum = raum;
	}

	public Semesterverband getSemesterverband() {
		return semesterverband;
	}

	public void setSemesterverband(Semesterverband semesterverband) {
		this.semesterverband = semesterverband;
	}

}
