package de.hdm.gruppe3.stundenplantool.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.gruppe3.stundenplantool.server.db.*;
import de.hdm.gruppe3.stundenplantool.shared.bo.*;


@RemoteServiceRelativePath("stundenplanverwaltung")
public interface Stundenplanverwaltung extends RemoteService{
	public Semesterverband anlegenSemesterverband(String semesterhalbjahr, int anzahlStudierende, int jahrgang);

	public Semesterverband modifizierenSemesterverband (String semesterhalbjahr, int anzahlStudierende, int jahrgang); //StundenplanVewaltung anpassen)

	public Semesterverband getSemesterverbandByNummer (int nr);

	public Semesterverband getSemesterverbandBySemesterHalbjahr (String semesterHalbjahr);

	public Semesterverband loeschenSemesterverband (Semesterverband sv);

	//public Zeitslot anlegenZeitslot (String wochentag, int anfangszeit);

	//public Zeitslot modifizierenZeitslot (Zeitslot z);

	public Zeitslot loeschenZeitslot (Zeitslot z);

	public Zeitslot getZeitslotByNummer (int nr);

	public Raum anlegenRaum (String Bezeichnung, int Kapazität);//klein schreiben !

	//public Raum modifizierenRaum (Raum r);

	public Raum loeschenRaum (Raum r);

	public Raum getRaumbyNummer (int nr);

	public Lehrveranstaltung anlegenLehrveranstaltung (String Bezeichnung, int Semester, int Umfang);

	//public Lehrveranstaltung modifizierenLehrveranstaltung (Lehrveranstaltung lv);

	public Lehrveranstaltung loeschenLehrveranstaltung (Lehrveranstaltung lv);

	public Lehrveranstaltung getLehrveranstaltungByNummer (int nr);

	public Lehrveranstaltung getLehrveranstaltungByBezeichnung (String bez);

	public Dozent anlegenDozent (String Vorname, String Nachname);

	//public Dozent modifizierenDozent (Dozent d);

	public Dozent loeschenDozent (Dozent d);

	public Dozent getDozentByNummer (int nr);

	//public Dozent getDozentByName (String name);

	public LVDurchfuehrung anlegenDurchfuehrung (int svId, int raumId, int lvId, int zIds);

	public LVDurchfuehrung modifizierenDurchfuehrung (int svId, int raumId, int lvId, int zIds);

	public LVDurchfuehrung loeschenDurchfuehrung (LVDurchfuehrung d);

	//public LVDurchfuehrung getDurchfuehrungByNummer (int nr);

	//public Raum getRaumByBezeichnung (String bez);

	Vector<Raum> getAllRaeume();

	Lehrveranstaltung modifizierenLehrveranstaltung(String bezeichnung,
			int semester, int umfang);

	Dozent getDozentByName(Dozent name);

	LVDurchfuehrung getDurchfuehrungByNummer(LVDurchfuehrung nr);

	Dozent modifizierenDozent(String vorname, String nachname);

	Raum getRaumByBezeichnung(Raum r);

	Zeitslot anlegenZeitslot(String wochentag);

	Zeitslot modifizierenZeitslot(String wochentag);

	Raum modifizierenRaum(String bez, int kapa);




}
