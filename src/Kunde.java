package programm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Kunde als Unterklasse von Person.
 * 
 * @author Adrian Plaas-Link und Yann Ahlgrim
 * @version 0.5
 * 
 */
public class Kunde extends Person {

    /**
     * Konstruktor welcher unter Angabe von Vor- und Nachname ein Objekt vom Typ
     * Person initialisiert.
     * 
     * @param vorname  Vorname der Person.
     * @param nachname Nachname der Person.
     */
    public Kunde(String vorname, String nachname) {
        this.setVorname(vorname);
        this.setNachname(nachname);
        askForMissingData();
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Ist der Kunde männlich oder weiblich? Bitte antworten sie mit ja oder nein.");
        this.setMaennlich(sc.nextLine().equals("ja") ? true : false);
        sc.close();
    }

    /**
     * Konstruktor welcher anhand eines Pfades eine Datei einliest und mittels
     * dieser alle nötigen Variablen initialisert. Das Textfile ist formatiert in
     * der Form:
     * 
     * 
     * \\Hier Beispieldatei einfuegen.//
     * 
     * @throws Exception Falls das Textfile falsch formiert wurde.
     */
    public Kunde(String path) throws Exception {
        String projektPfad = NuetzlicheMethoden.absolutePathToFilesFolder()+"Kunde";
        try {
            BufferedReader buffreader = new BufferedReader(new FileReader(projektPfad + path));
            String nextLine;
            while ((nextLine = buffreader.readLine()) != null) {
                String[] lineArray = nextLine.split(": ");
                switch (lineArray[0]) {
                case "Vorname":
                    super.setVorname(lineArray[1]);
                    break;
                case "Nachname":
                    super.setNachname(lineArray[1]);
                    break;
                case "Versicherung":
                    super.setVersicherung(lineArray[1]);
                    break;
                case "Adresse":
                    super.setAdresse(new Adresse(lineArray[1]));
                    break;
                case "Alter":
                    super.setAlter((Integer.parseInt(lineArray[1])));
                    break;
                case "maennlich":
                    super.setMaennlich(lineArray[1].equals("ja") ? true : false);
                    break;
                }
            }
            buffreader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Kunstruktor welcher es erlaubt interaktiv mit der Console einen Kunden zu
     * erzeugen.
     */
    public Kunde() {
        askForMissingData();
    }

    /**
     * Methode welcher die Gleichheit dieses Kunden mit einem angegebenen Anderen
     * überprüft und bei Gleichheit wahr zurueckgibt.
     * 
     * @param kunde Mit welchem dieser Kunde zu vergleichen ist.
     * @return Gibt wahr zurueck wenn beide die gleichen Namen enthalten und
     *         ansonsten falsch.
     */
    public boolean equals(Kunde kunde) {
        if (kunde.toString().equals(this.toString())) {
            return true;
        }
        return false;
    }

    /**
     * Methode welche interaktiv alle fehldenden Variablen initialisiert.
     */
    private void askForMissingData() {
        Scanner sc = new Scanner(System.in);
        // Vorname
        if (this.getVorname().isBlank()) {
            System.out.println("Bitte geben sie den Vornamen an:");
            this.setVorname(sc.nextLine());
        }
        // Nachname
        if (this.getNachname().isBlank()) {
            System.out.println("Bitte geben sie den Nachnamen ein:");
            this.setNachname(sc.nextLine());
        }
        // Alter
        if (this.getAlter() == 0) {
            System.out.println("Bitte geben sie das Alter an");
            String temp = sc.nextLine();
            while (!NuetzlicheMethoden.onlyDigits(temp, temp.length())) {
                System.out.println("Bitte verwenden sie nur Zahlen");
                temp = sc.nextLine();
            }
            this.setAlter(Integer.parseInt(temp));
        }
        // Versicherung
        if (this.getVersicherung().isBlank()) {
            System.out.println("Bitte geben sie Namen der Versicherung an");
            this.setVersicherung(sc.nextLine());
        }
        // Adresse
        if (this.getAdresse().isBlank()) {
            System.out.println("Bitte geben sie die Adressdaten ein");
            this.setAdresse(new Adresse());
        }
        sc.close();
    }

    /**
     * Methode welche die im Kunden gesetzten Variablen in einem .txt File ablegt.
     * 
     * @throws IOException
     */
    public void writeKundeToFile() throws IOException {
        // Pfad finden
        String s = NuetzlicheMethoden.absolutePathToFilesFolder();
        String path = s + "Kunde" + getVorname() + getNachname() + ".txt";

        // Daten schreiben
        BufferedWriter bf = new BufferedWriter(new FileWriter(path, true));
        bf.write("Vorname: " + getVorname() + '\n');
        bf.write("Nachname: " + getNachname() + '\n');
        bf.write("Adresse: " + getAdresse() + '\n');
        bf.write("Versicherung: " + getVersicherung() + '\n');
        bf.write("Alter: " + getAlter() + '\n');
        bf.write("private: " + getAlter() + '\n');
        bf.write("maennlich: " + getMaennlich() + '\n');
        bf.close();
    }

    /**
     * Methode welche eine Textrepresentation der Klasseninstanz als String
     * zurueckgibt.
     */
    public String toString() throws NullPointerException {
        return "[Adresse: " + super.getAdresse().toString() + ", Alter: " + super.getAlter()
                + ", Versicherung: " + versicherung + ", Vorname: " + super.getVorname()
                + ", Nachname: " + super.getNachname() + "]" + '\n';
    }

}
