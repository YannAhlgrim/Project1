package programm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import programm.Comparatoren.AdressenComparator;
import programm.Comparatoren.AlterComparator;
import programm.Comparatoren.MaennlichComparator;
import programm.Comparatoren.NamenComparator;
import programm.Comparatoren.VersicherungsComparator;

/**
 * Friseursalon zur Verwaltung von Kundenliste und Friseurliste.
 * 
 * @author Adrian Plaas-Link und Yann Ahlgrim
 * @version 0.5
 * 
 */
public class Friseursalon {
    /**
     * Die Liste der Kunden des Friseursalons.
     */
    static ArrayList<Kunde> kunden = new ArrayList<Kunde>();
    /**
     * Die Liste der Friseure des Friseursalons.
     */
    static ArrayList<Friseur> friseure = new ArrayList<Friseur>();

    public static void loadAll() throws Exception {
        File folder = new File(NuetzlicheMethoden.absolutePathToFilesFolder());
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            String name = listOfFiles[i].getName();
            System.out.println("File " + listOfFiles[i].getName());
            if (name.startsWith("Kunde")) {
                name = name.substring("Kunde".length());
                kunden.add(new Kunde(name));
            } else if (name.startsWith("Friseur")) {
                name = name.substring("Friseur".length());
                friseure.add(new Friseur(name));
            }
            System.out.println(name);
            System.out.println(Friseursalon.toAString());
        }
    }

    public Friseursalon() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%15s %15s %15s %15s %15s %15s %15s", "HAUPTMENÜ", "FILES LADEN", "ADD KUNDE", "ADD FRISEUR", "SORTIEREN", "GET KUNDE", "GET FRISEUR");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%15s %15s %15s %15s %15s %15s %15s", 1, 2, 3, 4, 5, 6, 7);

        Scanner sc = new Scanner(System.in);
        while(true){
       try{switch(sc.nextInt()){
           
            case 2:
            loadAll();
            break;

            case 3:
            System.out.println("Geben Sie einen Kunden ein.");
            break;

            case 4:
            System.out.println("Geben Sie einen Friseur ein.");
            break;

            case 5:
            System.out.println("Nach welcher Variable wollen Sie sortieren?");
            break;

            case 6:
            getKunden();
            break;

            case 7:
            getFriseure();
            break;

            default:
            break;
        } 
            break;
        }catch(Exception e){
            System.out.println("Falsche Eingabe! Probieren Sie es erneut.");
           
        }}

    }

    public static void addKunde(Kunde kunde) {
        kunden.add(kunde);
    }

    public static void addFriseur(Friseur friseur) {
        friseure.add(friseur);
    }

    public static ArrayList<Friseur> getFriseure() {
        return friseure;
    }

    public static ArrayList<Kunde> getKunden() {
        return kunden;
    }

    public static void sortKundenByName() {
        kunden.sort(new NamenComparator());
    }

    public static void sortFriseureByName() {
        friseure.sort(new NamenComparator());
    }

    public static void sortKundenByAdresse() {
        kunden.sort(new AdressenComparator());
    }

    public static void sortFriseureByAdresse() {
        friseure.sort(new AdressenComparator());
    }

    public static void sortKundenByAlter() {
        kunden.sort(new AlterComparator());
    }

    public static void sortFriseureByAlter() {
        friseure.sort(new AlterComparator());
    }

    public static void sortKundenByMaennlich() {
        kunden.sort(new MaennlichComparator());
    }

    public static void sortFriseureByMaennlich() {
        friseure.sort(new MaennlichComparator());
    }

    public static void sortKundenByVersicherung() {
        kunden.sort(new VersicherungsComparator());
    }

    public static void sortFriseureByVersicherung() {
        friseure.sort(new VersicherungsComparator());
    }

    public static String toAString() {
        return "Kunden: " + '\n' + kunden.toString() + "Friseure: " + '\n' + friseure.toString();
    }
}
