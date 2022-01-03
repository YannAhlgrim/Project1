package programm;

import java.util.Scanner;

/**
 * Adresse mit Strasse, Hausnummer, Stadt und Postleitzahl.
 * 
 * @author Adrian Plaas-Link und Yann Ahlgrim
 * @version 0.5
 * 
 */
public class Adresse implements Comparable<Adresse> {

    /**
     * Name der in der Adresse enthaltenen Strasse.
     */
    String strasse;
    /**
     * Die in der Adresse enthaltene Hausnummer.
     */
    int nummer;
    /**
     * Name der Stadt.
     */
    String stadt;
    /**
     * Die Postleitzahl der Adresse.
     */
    String postleitzahl;

    /**
     * Konstruktor welcher die Klasse unter Angabe der Werte initialisiert.
     * 
     * 
     * @param strasse      Strassenname
     * @param nummer       Hausnummer
     * @param stadt        Stadtname
     * @param postleitzahl Die Postleitzahl
     */
    Adresse(String strasse, int nummer, String stadt, String postleitzahl) {
        this.strasse = strasse;
        this.nummer = nummer;
        this.stadt = stadt;
        this.postleitzahl = postleitzahl;
    }

    /**
     * Konstruktor ohne Parameter zur interaktiven Initialisierung einer Adresse
     * mittels Commandozeile.
     */
    public Adresse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben sie den Strassennamen an.");
        strasse = sc.nextLine();
        System.out.println("Bitte geben sie die Hausnummer an.");
        String temp = sc.nextLine();
        while (!NuetzlicheMethoden.onlyDigits(temp, temp.length())) {
            System.out.println("Bitte verwenden sie nur Zahlen");
            temp = sc.nextLine();
        }
        nummer = Integer.parseInt(temp);
        System.out.println("Bitte geben sie den Namen der Stadt an.");
        stadt = sc.nextLine();
        System.out.println("Bitte geben sie die Postleitzahl an.");
        temp = sc.nextLine();
        while (!NuetzlicheMethoden.onlyDigits(temp, temp.length())) {
            System.out.println("Bitte verwenden sie nur Zahlen");
            temp = sc.nextLine();
        }
        postleitzahl = temp;
        sc.close();
    }

    /**
     * Konstruktor welcher einen String-Input an den ", " splitted und dann die
     * Klasse mit den dazwischenliegenden Werten initialisiert. Die Werte müssen der
     * Form 'Strassenname', 'Hausnummer', 'Stadtname', 'Plz' hinterlegt sein.
     * 
     * @param input String welcher die zu initialierenden Werte enthält.
     * @throws Exception Falls einer der Integerwerte im Input mit zahlen gemischt
     *                   wurde.
     */
    public Adresse(String input) throws Exception {
        String[] inputs = input.split(", ");
        strasse = inputs[0];
        if (NuetzlicheMethoden.onlyDigits(inputs[1], inputs[1].length())) {
            System.out.println(inputs[1]);
            nummer = Integer.parseInt(inputs[1]);
        } else {
            throw new Exception("Hausnummer in Adresse hat das falsche Format");
        }
        stadt = inputs[2];
        if (NuetzlicheMethoden.onlyDigits(inputs[3], inputs[3].length())) {
            postleitzahl = inputs[3];
        } else {
            throw new Exception("Plz in Adresse hat das falsche Format");
        }
    }

    /**
     * Methode welche nur wahr zurueckgibt wenn das Objekt eine vollstaendige
     * Adresse enthaelt.
     * 
     * @return Wahr wenn alle variablen des Objektes mit validen Werten
     *         initialisiert wurden, ansonsten falsch.
     */
    public boolean isBlank() {
        if (strasse.isBlank() || nummer == 0 || stadt.isBlank() || postleitzahl.isBlank()) {
            return true;
        }
        return false;
    }

    /**
     * Methode zur Rückgabe der Werte der Klasseninstanz als String.
     * 
     * @return Gibt eine Textrepresentation der Klasse aus.
     */
    public String toString() {
        return strasse + ", " + nummer + ", " + stadt + ", " + postleitzahl;
    }

    /**
     * Methode welche die toString()-Wert dieser Adresse mit gegebener anderer
     * Adresse vergleicht.
     * 
     * @return Gibt int für alphabetisches sortieren aus.
     */
    @Override
    public int compareTo(Adresse o) {
        return toString().compareTo(o.toString());
    }
}
