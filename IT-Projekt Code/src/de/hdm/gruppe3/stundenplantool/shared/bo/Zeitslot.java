package de.hdm.gruppe3.stundenplantool.shared.bo;

import java.util.ArrayList;

public class Zeitslot extends BusinessObject {

	// Instanzvariablen bzw. Membervariablen
	private static final long serialVersionUID = 1L;

	private int anfangszeit;
	private int dauer;
	private String Wochentag;
	private ArrayList<LVDurchfuehrung> durchfuehrungen = new ArrayList<LVDurchfuehrung>();

	// Konstruktor
	public Zeitslot(int anfangszeit, int dauer, String wochentag,
			ArrayList<LVDurchfuehrung> durchfuehrungen) {
		this.anfangszeit = anfangszeit;
		this.dauer = dauer;
		Wochentag = wochentag;
		this.durchfuehrungen = durchfuehrungen;
	}

	// Getter und Setter
	public int getAnfangszeit() {
		return anfangszeit;
	}

	public void setAnfangszeit(int anfangszeit) {
		this.anfangszeit = anfangszeit;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public String getWochentag() {
		return Wochentag;
	}

	public void setWochentag(String wochentag) {
		Wochentag = wochentag;
	}

	public ArrayList<LVDurchfuehrung> getDurchfuehrungen() {
		return durchfuehrungen;
	}

	public void setDurchfuehrungen(ArrayList<LVDurchfuehrung> durchfuehrungen) {
		this.durchfuehrungen = durchfuehrungen;
	}
}
