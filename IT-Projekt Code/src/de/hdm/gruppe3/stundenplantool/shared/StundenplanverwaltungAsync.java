package de.hdm.gruppe3.stundenplantool.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.gruppe3.stundenplantool.shared.bo.Dozent;
import de.hdm.gruppe3.stundenplantool.shared.bo.LVDurchfuehrung;
import de.hdm.gruppe3.stundenplantool.shared.bo.Lehrveranstaltung;
import de.hdm.gruppe3.stundenplantool.shared.bo.Raum;
import de.hdm.gruppe3.stundenplantool.shared.bo.Semesterverband;
import de.hdm.gruppe3.stundenplantool.shared.bo.Zeitslot;

public interface StundenplanverwaltungAsync {

	void anlegenDozent(String Vorname, String Nachname,
			AsyncCallback<Dozent> callback);

	void anlegenDurchfuehrung(int svId, int raumId, int lvId, int zIds,
			AsyncCallback<LVDurchfuehrung> callback);

	void anlegenLehrveranstaltung(String Bezeichnung, int Semester, int Umfang,
			AsyncCallback<Lehrveranstaltung> callback);

	void anlegenRaum(String Bezeichnung, int Kapazit�t,
			AsyncCallback<Raum> callback);

	void anlegenSemesterverband(String semesterhalbjahr, int anzahlStudierende,
			int jahrgang, AsyncCallback<Semesterverband> callback);

	void anlegenZeitslot(String wochentag, AsyncCallback<Zeitslot> callback);

	void getAllRaeume(AsyncCallback<Vector<Raum>> callback);

	void getDozentByName(Dozent name, AsyncCallback<Dozent> callback);

	void getDozentByNummer(int nr, AsyncCallback<Dozent> callback);

	void getDurchfuehrungByNummer(LVDurchfuehrung nr,
			AsyncCallback<LVDurchfuehrung> callback);

	void getLehrveranstaltungByBezeichnung(String bez,
			AsyncCallback<Lehrveranstaltung> callback);

	void getLehrveranstaltungByNummer(int nr,
			AsyncCallback<Lehrveranstaltung> callback);

	void getRaumByBezeichnung(Raum r, AsyncCallback<Raum> callback);

	void getRaumbyNummer(int nr, AsyncCallback<Raum> callback);

	void getSemesterverbandByNummer(int nr,
			AsyncCallback<Semesterverband> callback);

	void getSemesterverbandBySemesterHalbjahr(String semesterHalbjahr,
			AsyncCallback<Semesterverband> callback);

	void getZeitslotByNummer(int nr, AsyncCallback<Zeitslot> callback);

	void loeschenDozent(Dozent d, AsyncCallback<Dozent> callback);

	void loeschenDurchfuehrung(LVDurchfuehrung d,
			AsyncCallback<LVDurchfuehrung> callback);

	void loeschenLehrveranstaltung(Lehrveranstaltung lv,
			AsyncCallback<Lehrveranstaltung> callback);

	void loeschenRaum(Raum r, AsyncCallback<Raum> callback);

	void loeschenSemesterverband(Semesterverband sv,
			AsyncCallback<Semesterverband> callback);

	void loeschenZeitslot(Zeitslot z, AsyncCallback<Zeitslot> callback);

	void modifizierenDozent(String vorname, String nachname,
			AsyncCallback<Dozent> callback);

	void modifizierenDurchfuehrung(int svId, int raumId, int lvId, int zIds,
			AsyncCallback<LVDurchfuehrung> callback);

	void modifizierenLehrveranstaltung(String bezeichnung, int semester,
			int umfang, AsyncCallback<Lehrveranstaltung> callback);

	void modifizierenRaum(String bez, int kapa, AsyncCallback<Raum> callback);

	void modifizierenSemesterverband(String semesterhalbjahr,
			int anzahlStudierende, int jahrgang,
			AsyncCallback<Semesterverband> callback);

	void modifizierenZeitslot(String wochentag, AsyncCallback<Zeitslot> callback);

}
