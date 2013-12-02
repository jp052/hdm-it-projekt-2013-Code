package de.hdm.gruppe3.stundenplantool.shared.bo;

import java.util.ArrayList;

public class Lehrveranstaltung extends BusinessObject {

	// Instanzvariablen bzw. Membervariablen
	private static final long serialVersionUID = 1L;

	private String bezeichnung;
	private double umfang;
	private int semester;
	private Dozent dozent;
	private ArrayList<LVDurchfuehrung> durchfuehungen = new ArrayList<LVDurchfuehrung>();

	// Konstruktor
	public Lehrveranstaltung(String bezeichnung, double umfang, int semester,
			Dozent dozent, ArrayList<LVDurchfuehrung> durchfuehungen) {
		this.bezeichnung = bezeichnung;
		this.umfang = umfang;
		this.semester = semester;
		this.dozent = dozent;
		this.durchfuehungen = durchfuehungen;
	}

	// Getter und Setter
	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public double getUmfang() {
		return umfang;
	}

	public void setUmfang(double umfang) {
		this.umfang = umfang;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Dozent getDozent() {
		return dozent;
	}

	public void setDozent(Dozent dozent) {
		this.dozent = dozent;
	}

	public ArrayList<LVDurchfuehrung> getDurchfuehungen() {
		return durchfuehungen;
	}

	public void setDurchfuehungen(ArrayList<LVDurchfuehrung> durchfuehungen) {
		this.durchfuehungen = durchfuehungen;
	}
}
