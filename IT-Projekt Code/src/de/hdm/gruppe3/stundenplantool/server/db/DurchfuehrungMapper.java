package de.hdm.gruppe3.stundenplantool.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;

//Import Impl Klasse Dozent
//Import bo Dozent

public class DurchfuehrungMapper {
 /**
    * Die Klasse DurchfuehrungMapper wird nur eindfl instantiiert. Man spricht hierbei
    * von einem sogenannten <b>Singleton</b>.
    * <p>
    * Diese Variable ist durch den Bezeichner <code>static</code> nur eindfl für
    * sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
    * einzige Instanz dieser Klasse.
    * 
    * @see dfMapper()
    */
   private static DurchfuehrungMapper dfMapper = null;

   /**
    * Geschützter Konstruktor - verhindert die Möglichkeit, mit <code>new</code>
    * neue Instanzen dieser Klasse zu erzeugen.
    */
   protected DurchfuehrungMapper() {
   }

   /**
    * Diese statische Methode kann aufgrufen werden durch
    * <code>DurchfuehrungMapper.dfMapper()</code>. Sie stellt die
    * Singleton-Eigenschaft sicher, indem Sie dafür sorgt, dass nur eine einzige
    * Instanz von <code>DurchfuehrungMapper</code> existiert.
    * <p>
    * 
    * <b>Fazit:</b> DurchfuehrungMapper sollte nicht mittels <code>new</code>
    * instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
    * 
    * @return DAS <code>DurchfuehrungMapper</code>-Objekt.
    * @see dfMapper
    */
   public static DurchfuehrungMapper dfMapper() {
     if (dfMapper == null) {
       dfMapper = new DurchfuehrungMapper();
     }

     return dfMapper;
   }
   public Durchfuehrung anlegen(Durchfuehrung df, Raum r, Semesterverband sv, Lehrveranstaltung lv, Zeitslot z){
    Connection con = DBVerbindung.connection();

       try {
         Statement stmt = con.createStatement();

//         /*
//          * Zunächst schauen wir nach, welches der momentan höchste
//          * Primärschlüsselwert ist.
//          */
//         ResultSet rs = stmt.executeQuery("SELECT MAX(df) AS dfxdf "
//             + "FROM df ");
 //
//         // Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
//         if (rs.next()) {
//           /*
//            * a erhält den bisher dfxdfozentlen, nun um 1 inkrementierten
//            * Primärschlüssel.
//            */
//           m.setID(rs.getInt("dfxdf") + 1);
 //
//           stmt = con.createStatement();

           // Jetzt erst erfolgt die tatsächliche Einfügeoperation
           stmt.executeUpdate("INSERT INTO df (LVDNr, ZeitNr, SVNr, RaumNr, EDVNr) " + "VALUES ( "
            + "NULL,'" + df.getId() + "','" + r.getId() +"','" +sv.getId()+ "','" + lv.getId()+"','" +z.getId()+"')");
         //}
       }
       catch (SQLException e2) {
         e2.printStackTrace();
       } 

       /*
        * Rückgabe, des evtl. korrigierten Accounts.
        * 
        * HINWEIS: Da in Java nur Referenzen auf Objekte und keine physischen
        * Objekte übergeben werden, wäre die Anpassung des Durchfuehrung-Objekts auch
        * ohne diese explizite Rückgabe au�erhalb dieser Methode sichtbar. Die
        * explizite Rückgabe von a ist eher ein Stilmittel, um zu signalisieren,
        * dass sich das Objekt evtl. im Laufe der Methode verändert hat.
        */
       return m;
   
  }
  
  public Durchfuehrung modifizieren(Durchfuehrung df, Raum r, Semesterverband sv, Lehrveranstaltung lv, Zeitslot z){
      Connection con = DBVerbindung.connection();

      try {
        Statement stmt = con.createStatement();

        stmt.executeUpdate("UPDATE df " + "\" SET RaumNr=\"" + r.getId() + "\" "+ "SET ZeitNr=\"" + z.getId() + "\" "+"SET SVNr=\"" + sv.getPLZ() + "\" " + "SET EDVNr=\"" + lv.getOrt() + "\" "+ "WHERE df=" + df.getID());

      }
      catch (SQLException e2) {
        e2.printStackTrace();
      } 

      // Um Analogie zu insert(Durchfuehrung a) zu wahren, geben wir a zurück
      return df;
  }
  
  public Durchfuehrung loeschen(Durchfuehrung df){
      Connection con = DBVerbindung.connection();

      try {
        Statement stmt = con.createStatement();

        stmt.executeUpdate("DELETE FROM df " + "WHERE df=" + df.getID());

      }
      catch (SQLException e2) {
        e2.printStackTrace();
      } 
  }
  
  public Durchfuehrung findeId(Durchfuehrung df, Raum r, Semesterverband sv, Lehrveranstaltung lv, Zeitslot z){
      // DB-Verbindung holen
      Connection con = DBVerbindung.connection();

      try {
        // Leeres SQL-Statement (JDBC) anlegen
        Statement stmt = con.createStatement();

        // Statement ausfüllen und als Query an die DB schicken
        ResultSet rs = stmt.executeQuery("SELECT LVDNr, ZeitNr, SVNr, RaumNr, EDVNr FROM df "
            + "WHERE LVDNr=" + df.getId + " ORDER BY LVDNr");

        /*
         * Da df Primärschlüssel ist, kann dfx. nur ein Tupel zurückgegeben
         * werden. Prüfe, ob ein Ergebnis vorliegt.
         */
        if (rs.next()) {
          // Ergebnis-Tupel in Objekt umwandeln
       Durchfuehrung df = new Durchfuehrung();
          df.setId(rs.getInt("LVDNr"));
          r.setId(rs.getInt("RaumNr"));
          sv.setId(rs.getInt("SVNr"));
          lv.setId(rs.getInt("EDVNr"));
          z.setId(rs.getInt("ZeitNr"));

          return df;
        }
      }
      catch (SQLException e2) {
        e2.printStackTrace();
        return null;
      } 

      return null;
  }
   
}