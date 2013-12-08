package de.hdm.gruppe3.stundenplantool.server;

import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.gruppe3.stundenplantool.server.db.*;
import de.hdm.gruppe3.stundenplantool.shared.Stundenplanverwaltung;
import de.hdm.gruppe3.stundenplantool.shared.bo.*;
import de.hdm.gruppe3.stundenplantool.shared.*;

public class StundenplanverwaltungImpl extends RemoteServiceServlet
implements Stundenplanverwaltung{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SemesterverbandMapper svMapper = null;

	private ZeitslotMapper zMapper = null;

	private RaumMapper rMapper = null;

	private LehrveranstaltungMapper lvMapper = null;

	private DozentMapper dMapper = null;

	private DurchfuehrungMapper dfMapper = null;  //siehe StundenplanVerwaltungImpl, Datentyp DurchfuehrungMapper, dvMapper heißt dfMapper



	public StundenplanverwaltungImpl () throws IllegalArgumentException {}


	public void init () throws IllegalArgumentException {

		svMapper = SemesterverbandMapper.svMapper();
		zMapper = ZeitslotMapper.zeitslotMapper();
		rMapper = RaumMapper.raumMapper();
		lvMapper = LehrveranstaltungMapper.lvMapper();
		dMapper = DozentMapper.dozentMapper();
		dfMapper = DurchfuehrungMapper.dfMapper();
		}


	//Methoden Semesterverband
	public Semesterverband anlegenSemesterverband(String semesterhalbjahr, int anzahlStudierende, int jahrgang) {

		Semesterverband sv = new Semesterverband();
		sv.setSemester (semesterhalbjahr);	
		sv.setAnzahlStudenten (anzahlStudierende);
		sv.setJahrgang (jahrgang);
		return svMapper.anlegen(sv);
		}


	public Semesterverband modifizierenSemesterverband (String semesterhalbjahr, int anzahlStudierende, int jahrgang){ //StundenplanVerwaltung anpassen !!!
		
		Semesterverband sv = new Semesterverband ();
		sv.setSemester (semesterhalbjahr);	
		sv.setAnzahlStudenten (anzahlStudierende);
		sv.setJahrgang (jahrgang); 
		return svMapper.modifizieren(sv);
		}

	public Semesterverband getSemesterverbandByNummer (int nr){
		
		return svMapper.findeId(nr);
		}


/*	public Semesterverband getSemesterverbandBySemesterHalbjahr (String semesterHalbjahr){

		return svMapper.ffindeSemester(semesterHalbjahr);
		}


	public Semesterverband loeschenSemesterverband (Semesterverband sv){

		return svMapper.loeschen(sv.getId());
		}*/


	//TODO Methoden Zeitslot, Zeitslot muss verändert werden, da die Attribute noch nicht vollständig sind
	public Zeitslot anlegenZeitslot (String wochentag) {	//Kleinschreibung Diagramm übernehmen, Aktuelle Attribute von der Klasse Zeitslot hier einfügen
		
		Zeitslot z = new Zeitslot();
		z.setWochentag (wochentag);
		return zMapper.anlegen(z);
		}

	public Zeitslot modifizierenZeitslot (String wochentag){ //wochentag in Diagramm übernehmen bzw. ersetzen
		
		Zeitslot z = new Zeitslot ();
		z.setWochentag (wochentag);
		return zMapper.modifizieren(z);
		}

	public Zeitslot loeschenZeitslot (Zeitslot z){

		return zMapper.loeschen(z);
		}

	public Zeitslot getZeitslotByNummer (int nr){
		
		return zMapper.findeId(nr);
		}


	//Methoden Raum
	public Raum anlegenRaum (String bez, int kapa){
		
		Raum r = new Raum ();
		r.setBezeichnung (bez);
		r.setKapazitaet (kapa);
		return rMapper.anlegen(r);
		}


	public Raum modifizierenRaum (String bez, int kapa){ //Diagramm anpassen

		Raum r = new Raum ();
		r.setBezeichnung (bez);
		r.setKapazitaet (kapa);
		return rMapper.modifizieren(r);
		}


	public Raum loeschenRaum (Raum r){

		return rMapper.loeschen(r);
		}


	public Raum getRaumbyNummer (int nr){

		return rMapper.findeId(nr);
		}


	public Raum getRaumByBezeichnung (Raum r){

		return rMapper.findeName(r);
		}


	//public Vector getAllRaeume () //Schleife einbauen??





	//Methoden Lehrveranstaltung
	public Lehrveranstaltung anlegenLehrveranstaltung (String bezeichnung, int semester, int umfang){ //Kleinschreibung Diagramm übernehmen

		Lehrveranstaltung l = new Lehrveranstaltung ();
		l.setBezeichnung (bezeichnung);
		l.setSemester (semester);
		l.setUmfang (umfang);
		return lvMapper.anlegen(l);
		}


	public Lehrveranstaltung modifizierenLehrveranstaltung (String bezeichnung, int semester, int umfang){ //Diagramm anpassen

		Lehrveranstaltung l = new Lehrveranstaltung ();
		l.setBezeichnung (bezeichnung);
		l.setSemester (semester);
		l.setUmfang (umfang);
		return lvMapper.modifizieren(l);
		}

	public Lehrveranstaltung loeschenLehrveranstaltung (Lehrveranstaltung lv){

		return lvMapper.loeschen(lv);
		}


	public Lehrveranstaltung getLehrveranstaltungByNummer (int nr){

		return lvMapper.findeId(nr);
		}


	public Lehrveranstaltung getLehrveranstaltungByBezeichnung (String bez){

		return lvMapper.findeName(bez);
		}


	//Methoden Dozent
	public Dozent anlegenDozent (String vorname, String nachname){ //Kleinschreibung Diagramm übernehmen

		Dozent d = new Dozent ();
		d.setVorname (vorname);
		d.setNachname (nachname);
		return dMapper.anlegen(d);
		}

	public Dozent modifizierenDozent (String vorname, String nachname){ //Diagramm anpassen
		
		Dozent d = new Dozent ();
		d.setVorname (vorname);
		d.setNachname (nachname);
		return dMapper.modifizieren(d);
		}

	public Dozent loeschenDozent (Dozent d){

		return dMapper.loeschen(d);
		}
		

	public Dozent getDozentByNummer (int nr){

		return dMapper.findeId(nr);
		}


	public Dozent getDozentByName (Dozent name){

		return dMapper.findeName (name);
		}


	//Methoden LVDurchführung
	public LVDurchfuehrung anlegenDurchfuehrung (int svId, int raumId, int lvId, int zIds){

		LVDurchfuehrung lvd = new LVDurchfuehrung();
		lvd.setId (svId);
		lvd.setRaum (raumId);
		lvd.setLV(lvId);
		lvd.setZIds (zIds);
		return dfMapper.anlegen(lvd);
		}


	public LVDurchfuehrung modifizierenDurchfuehrung (int svId, int raumId, int lvId, int zIds){

		LVDurchfuehrung lvd = new LVDurchfuehrung();
		lvd.setId (svId);
		lvd.setRaum (raumId);
		lvd.setLV(lvId);
		lvd.setZIds (zIds);
		return dfMapper.modifizieren(lvd);
		}
		

	public LVDurchfuehrung loeschenDurchfuehrung (LVDurchfuehrung d){ //Diagramm anpassen
		
		return dfMapper.loeschen(d);	
		}


	public LVDurchfuehrung getDurchfuehrungByNummer (int nr){

		return dfMapper.findeId(nr);
		}


	@Override
	public Semesterverband getSemesterverbandBySemesterHalbjahr(
			String semesterHalbjahr) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Semesterverband loeschenSemesterverband(Semesterverband sv) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Zeitslot anlegenZeitslot(String wochentag, int anfangszeit) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Zeitslot modifizierenZeitslot(Zeitslot z) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Raum modifizierenRaum(Raum r) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Lehrveranstaltung modifizierenLehrveranstaltung(Lehrveranstaltung lv) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Dozent modifizierenDozent(Dozent d) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Dozent getDozentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public LVDurchfuehrung anlegenDurchfuehrung(int svId, int raumId, int lvId,
			int zIds) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public LVDurchfuehrung modifizierenDurchfuehrung(int svId, int raumId,
			int lvId, int zIds) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Raum getRaumByBezeichnung(String bez) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Vector<Raum> getAllRaeume() {
		// TODO Auto-generated method stub
		return null;
	}
}
