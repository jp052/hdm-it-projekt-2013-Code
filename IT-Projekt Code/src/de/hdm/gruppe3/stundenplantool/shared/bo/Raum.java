package de.hdm.gruppe3.stundenplantool.shared.bo;

import java.util.ArrayList;

public class Raum extends BusinessObject {

	// Instanzvariablen bzw. Membervariablen
	private static final long serialVersionUID = 1L;

	private String bezeichnung;
	private int kapazitaet;
	private ArrayList<LVDurchfuehrung> durchfuehrungen = new ArrayList<LVDurchfuehrung>();

	// Konstruktor
	public Raum(String bezeichnung, int kapazitaet,
			ArrayList<LVDurchfuehrung> durchfuehrungen) {
		this.bezeichnung = bezeichnung;
		this.kapazitaet = kapazitaet;
		this.durchfuehrungen = durchfuehrungen;
	}

	public Raum() {
		// TODO Auto-generated constructor stub
	}

	// Getter und Setter
	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getKapazitaet() {
		return kapazitaet;
	}

	public void setKapazitaet(int kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

	public ArrayList<LVDurchfuehrung> getDurchfuehrungen() {
		return durchfuehrungen;
	}

	public void setDurchfuehrungen(ArrayList<LVDurchfuehrung> durchfuehrungen) {
		this.durchfuehrungen = durchfuehrungen;
	}
}
