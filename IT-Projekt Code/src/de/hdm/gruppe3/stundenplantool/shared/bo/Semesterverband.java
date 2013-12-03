package de.hdm.gruppe3.stundenplantool.shared.bo;

import java.util.ArrayList;

public class Semesterverband extends BusinessObject {

	// Instanzvariablen bzw. Membervariablen
	private static final long serialVersionUID = 1L;

	private String semester;
	private int jahrgang;
	private int anzahlStudenten;

	// Konstruktor
	public Semesterverband(String semester, int jahrgang, int anzahlStudenten,
			ArrayList<LVDurchfuehrung> durchfuehungen) {
		this.semester = semester;
		this.jahrgang = jahrgang;
		this.anzahlStudenten = anzahlStudenten;
		this.durchfuehungen = durchfuehungen;
	}

	public Semesterverband() {
		// TODO Auto-generated constructor stub
	}

	// Getter und Setter
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getJahrgang() {
		return jahrgang;
	}

	public void setJahrgang(int jahrgang) {
		this.jahrgang = jahrgang;
	}

	public int getAnzahlStudenten() {
		return anzahlStudenten;
	}

	public void setAnzahlStudenten(int anzahlStudenten) {
		this.anzahlStudenten = anzahlStudenten;
	}

	public ArrayList<LVDurchfuehrung> getDurchfuehungen() {
		return durchfuehungen;
	}

	public void setDurchfuehungen(ArrayList<LVDurchfuehrung> durchfuehungen) {
		this.durchfuehungen = durchfuehungen;
	}

	private ArrayList<LVDurchfuehrung> durchfuehungen = new ArrayList<LVDurchfuehrung>();
}
