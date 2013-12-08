package de.hdm.gruppe3.stundenplantool.shared.bo;

import java.util.Vector;

public class LVDurchfuehrung extends BusinessObject {

	// Instanzvariablen bzw. Membervariablen
	private static final long serialVersionUID = 1L;

	private Lehrveranstaltung veranstaltung;
	private Vector<Zeitslot> zeitslots = new Vector<Zeitslot>();
	private int raum;
	private int semesterverband;
	private int lvId;
	private int zIds;

	public int getzIds() {
		return zIds;
	}


	public void setZIds(int zIds2) {
		this.zIds = zIds2;
	}


	public int getLvId() {
		return lvId;
	}


	public void setLV(int lvId) {
		this.lvId = lvId;
	}


	public void setSemesterverband(int semesterverband) {
		this.semesterverband = semesterverband;
	}


	// Konstruktor
	/*public LVDurchfuehrung(Lehrveranstaltung veranstaltung,
			Vector<Zeitslot> zeitslots, Raum raum,
			Semesterverband semesterverband) {
		this.veranstaltung = veranstaltung;
		this.zeitslots = zeitslots;
		this.raum = raum;
		this.semesterverband = semesterverband;
	}*/
	
	
	public LVDurchfuehrung() {
	}


	// Getter und Setter
	public Lehrveranstaltung getVeranstaltung() {
		return veranstaltung;
	}

	public void setVeranstaltung(Lehrveranstaltung veranstaltung) {
		this.veranstaltung = veranstaltung;
	}

	public Vector<Zeitslot> getZeitslots() {
		return zeitslots;
	}

	public void setZeitslots(Vector<Zeitslot> zeitslots) {
		this.zeitslots = zeitslots;
	}

	public int getRaum() {
		return raum;
	}

	public void setRaum(int raumId) {
		this.raum = raumId;
	}

	public int getSemesterverband() {
		return semesterverband;
	}

	public void setSemesterverband(Semesterverband semesterverband) {
		this.semesterverband = semesterverband.getId();
	}

}
