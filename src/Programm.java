package programm;

import java.net.URL;
import java.nio.file.Paths;

/**
 * Hauptklasse zum Ausfuehren und Testen des Programmes.
 * 
 * @author Adrian Plaas-Link und Yann Ahlgrim
 * @version 0.5
 * 
 */
public class Programm {

    public static void main(String[] args) throws Exception {

        Friseursalon FS = new Friseursalon();
        FS.loadAll();


        System.out.println("Nicht sortiert: " + '\n' + Friseursalon.toAString());
        FS.sortKundenByName();
        System.out.println("Sortiert nach Name: " + '\n' + Friseursalon.toAString());
        FS.sortKundenByAlter();
        System.out.println("Sortiert nach Alter: " + '\n' + Friseursalon.toAString());
        FS.sortKundenByAdresse();
        System.out.println("Sortiert nach Adresse: " + '\n' + Friseursalon.toAString());
        FS.sortKundenByMaennlich();
        System.out.println("Sortiert nach Maennlich: " + '\n' + Friseursalon.toAString());
        FS.sortKundenByVersicherung();
        System.out.println("Sortiert nach Versicherung: " + '\n' + Friseursalon.toAString());

        
        /*
         * Kunde test = new Kunde(); test.writeKundeToFile(); System.out.println(test);
         * Kunde test2 = new Kunde(
         * "C:\\Users\\adria\\eclipse-workspace\\Programmierprojekt/src/programm/" +
         * "Kunde" + test.getVorname() + test.getNachname() + ".txt");
         * System.out.println(test2);
         */

         
    }

}
