package de.hdm.gruppe3.stundenplantool.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.thies.bankProjekt.server.db.CustomerMapper;
import de.hdm.thies.bankProjekt.server.db.DBConnection;
import de.hdm.thies.bankProjekt.shared.bo.Account;
import de.hdm.thies.bankProjekt.shared.bo.Customer;

//Import Impl Klasse Dozent
//Import bo Dozent

public class RaumMapper {
	/**
	   * Die Klasse RaumMapper wird nur einrauml instantiiert. Man spricht hierbei
	   * von einem sogenannten <b>Singleton</b>.
	   * <p>
	   * Diese Variable ist durch den Bezeichner <code>static</code> nur einrauml für
	   * sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	   * einzige Instanz dieser Klasse.
	   * 
	   * @see raumMapper()
	   */
	  private static RaumMapper raumMapper = null;

	  /**
	   * Geschützter Konstruktor - verhindert die Möglichkeit, mit <code>new</code>
	   * neue Instanzen dieser Klasse zu erzeugen.
	   */
	  protected RaumMapper() {
	  }

	  /**
	   * Diese statische Methode kann aufgrufen werden durch
	   * <code>RaumMapper.raumMapper()</code>. Sie stellt die
	   * Singleton-Eigenschaft sicher, indem Sie dafür sorgt, dass nur eine einzige
	   * Instanz von <code>RaumMapper</code> existiert.
	   * <p>
	   * 
	   * <b>Fazit:</b> RaumMapper sollte nicht mittels <code>new</code>
	   * instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
	   * 
	   * @return DAS <code>RaumMapper</code>-Objekt.
	   * @see raumMapper
	   */
	  public static RaumMapper raumMapper() {
	    if (raumMapper == null) {
	      raumMapper = new RaumMapper();
	    }

	    return raumMapper;
	  }
	  public Raum anlegen(de.itproject.project.shared.bo.Raum m ){
			 Connection con = DBVerbindung.connection();

			    try {
			      Statement stmt = con.createStatement();

//			      /*
//			       * Zunächst schauen wir nach, welches der momentan höchste
//			       * Primärschlüsselwert ist.
//			       */
//			      ResultSet rs = stmt.executeQuery("SELECT MAX(raum) AS raumxraum "
//			          + "FROM raum ");
	//
//			      // Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//			      if (rs.next()) {
//			        /*
//			         * a erhält den bisher raumxraumozentlen, nun um 1 inkrementierten
//			         * Primärschlüssel.
//			         */
//			        m.setID(rs.getInt("raumxraum") + 1);
	//
//			        stmt = con.createStatement();

			        // Jetzt erst erfolgt die tatsächliche Einfügeoperation
			        stmt.executeUpdate("INSERT INTO raum (RaumNr, Bezeichnung, Kapazitaet) " + "VALUES ( "
			        	+ "NULL,'" + m.getBezeichnung() + "','" + m.getKapazitaet() + "')");
			      //}
			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    } 

			    /*
			     * Rückgabe, des evtl. korrigierten Accounts.
			     * 
			     * HINWEIS: Da in Java nur Referenzen auf Objekte und keine physischen
			     * Objekte übergeben werden, wäre die Anpassung des Raum-Objekts auch
			     * ohne diese explizite Rückgabe au�erhalb dieser Methode sichtbar. Die
			     * explizite Rückgabe von a ist eher ein Stilmittel, um zu signalisieren,
			     * dass sich das Objekt evtl. im Laufe der Methode verändert hat.
			     */
			    return m;
			
		}
		
		public Raum modifizieren(Raum raum){
		    Connection con = DBVerbindung.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("UPDATE raum " + "SET Bezeichnung=\"" + raum.getBezeichnung() + "\" SET Kapazitaet=\"" + raum.getKapazitaet() + "WHERE RaumNr=" + raum.getID());

		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    } 

		    // Um Analogie zu insert(Raum a) zu wahren, geben wir a zurück
		    return raum;
		}
		
		public Raum loeschen(Raum raum){
		    Connection con = DBVerbindung.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("DELETE FROM raum " + "WHERE RaumNr=" + raum.getID());

		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    } 
		}
		
		public Raum findeName(Raum raum){
		    // DB-Verbindung holen
		    Connection con = DBVerbindung.connection();

		    try {
		      // Leeres SQL-Statement (JDBC) anlegen
		      Statement stmt = con.createStatement();

		      // Statement ausfüllen und als Query an die DB schicken
		      ResultSet rs = stmt.executeQuery("SELECT RaumNr, Bezeichnung, KapazitaetFROM raum "
		          + "WHERE Bezeichnung=" + raum.Bezeichnung + " ORDER BY Bezeichnung");

		      /*
		       * Da raum Primärschlüssel ist, kann raumx. nur ein Tupel zurückgegeben
		       * werden. Prüfe, ob ein Ergebnis vorliegt.
		       */
		      if (rs.next()) {
		        // Ergebnis-Tupel in Objekt umwandeln
		    	Raum raum = new Raum();
		        raum.setID(rs.getInt("RaumNr"));
		        raum.setBezeichnung(rs.getString("Bezeichnung"));
				raum.setKapazitaet(rs.getString("Kapazitaet"));

		        return raum;
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		      return null;
		    } 

		    return null;
		}
	  

		public Raum findeId(Raum raum){
		    // DB-Verbindung holen
		    Connection con = DBVerbindung.connection();

		    try {
		      // Leeres SQL-Statement (JDBC) anlegen
		      Statement stmt = con.createStatement();

		      // Statement ausfüllen und als Query an die DB schicken
		      ResultSet rs = stmt.executeQuery("SELECT RaumNr, Bezeichnung, Kapazitaet FROM raum "
		          + "WHERE RaumNr=" + raum.id + " ORDER BY Bezeichnung");

		      /*
		       * Da raum Primärschlüssel ist, kann raumx. nur ein Tupel zurückgegeben
		       * werden. Prüfe, ob ein Ergebnis vorliegt.
		       */
		      if (rs.next()) {
		        // Ergebnis-Tupel in Objekt umwandeln
		    	Raum raum = new Raum();
		        raum.setID(rs.getInt("RaumNr"));
		        raum.setBezeichnung(rs.getString("Bezeichnung"));
				raum.setKapazitaet(rs.getString("Kapazitaet"));

		        return raum;
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		      return null;
		    } 
		    return null;
		}
		
		public Vector<Raum> findeAlle(){
			 Connection con = DBVerbindung.connection();

			    // Ergebnisvektor vorbereiten
			    Vector<Raum> result = new Vector<Raum>();

			    try {
			      Statement stmt = con.createStatement();

			      ResultSet rs = stmt.executeQuery("SELECT RaumNr, Bezeichnung FROM raum "
			          + " ORDER BY RaumNr");

			      // F�r jeden Eintrag im Suchergebnis wird nun ein Account-Objekt erstellt.
			      while (rs.next()) {
			        Raum r = new Raum();
//			        r.setId(rs.getInt("id"));
//			        r.setOwnerID(rs.getInt("owner"));

			        // Hinzuf�gen des neuen Objekts zum Ergebnisvektor
			        result.addElement(r);
			      }
			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }

			 // Ergebnisvektor zur�ckgeben
			 return result;
		}
		
		public Lehrveranstaltung findeVL(Raum raum) {
		    /*
		     * Wir bedienen uns hier einfach des CustomerMapper. Diesem geben wir
		     * einfach den in dem Account-Objekt enthaltenen Fremdschl�ssel f�r den
		     * Kontoinhaber. Der CustomerMapper l�sst uns dann diese ID in ein Objekt
		     * auf.
		     */
		    return LehrveranstaltungMapper.lvMapper().findeId(raum.getRaum());
		  }
		
	
		
		public Zeitslot belegt(Raum raum) {
		    /*
		     * Wir bedienen uns hier einfach des CustomerMapper. Diesem geben wir
		     * einfach den in dem Account-Objekt enthaltenen Fremdschl�ssel f�r den
		     * Kontoinhaber. Der CustomerMapper l�sst uns dann diese ID in ein Objekt
		     * auf.
		     */
		    return ZeitslotMapper.zeitslotMapper().findeId(raum.getRaum());
		  }
		
}
