package programm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Friseur als Unterklasse von Person, welches diese um IBAN, BIC und eine
 * Terminliste erweitert.
 * 
 * @author Adrian Plaas-Link und Yann Ahlgrim
 * @version 0.5
 * 
 */
public class Friseur extends Person {

    /**
     * Die IBAN des Friseurs.
     */
    long iban;

    /**
     * BIC des Friseurs.
     */
    String bic;

    /**
     * Die Liste der Termine des Friseurs.
     */
    List<Termin> termine = new ArrayList<Termin>();

    Comparator <Termin> comparator = new TerminComp();

    /**
     * Methode zum Initialisieren eines Objektes vom Typ Friseur unter Angabe eines
     * Dateipfads einer Textdatei der Form:
     * 
     * @param path Dateipfad
     * @throws Exception
     */
    public Friseur(String path) throws Exception {
        String projektPfad = NuetzlicheMethoden.absolutePathToFilesFolder()+"Friseur";
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
                case "IBAN":
                    this.iban = Long.parseLong(lineArray[1]);
                    break;
                case "BIC":
                    this.bic = lineArray[1];
                }
                
            }

            buffreader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gibt den IBAN zurueck.
     * 
     * @return Gibt den IBAN zueruck.
     */
    public long getIBAN() {
        return iban;
    }

    /**
     * Setzt den IBAN.
     * 
     * @param iban
     */
    public void setIBAN(long iban) {
        this.iban = iban;
    }

    /**
     * Gibt den BIC zur�ck.
     * 
     * @param bic
     */
    public String getBIC() {
        return bic;
    }

    /**
     * Setzt den BIC.
     * 
     * @param bic
     */
    public void setBIC(String bic) {
        this.bic = bic;
    }

    /**
     * Methode zum sortieren der Termine.
     */
    public void TerminEinfuegen(Termin t) {
        /*
         * m�ssen eine globale Instanz TerminComp() machen damit nicht immer eine h�neue
         * erstellt wird
         */
        // Arrays.sort(termine, new TerminComp());
        for(int i = 0; i<termine.size(); i++){
           if (comparator.compare(t, termine.get(i))>0) {
               continue;
           }else{
               termine.add(i, t);
               return;
           }
    }
        termine.add(t);
}
    /**
     * Methode zum hinzufuegen eines Termins.
     * 
     * @param t
     */
    public void TerminAnlegen(Termin t) {

        for (int i = 0; i < termine.size(); i++) {
            if (t == termine.get(i)) {
                System.out.println("Es gibt schon einen Termin.");
            } else {
                TerminEinfuegen(t);
                System.out.println("Der Termin wurde erfolgreich hinzugef�gt.");
            }
        }
    }

    /**
     * Methode zur darstellung der Termine ueber die Konsole.
     */
    public void TermineAnzeigen() {
        System.out.println("---------------------------------------------");
        System.out.printf("%20s 20s", "ZEIT", "KUNDE");
        System.out.println("---------------------------------------------");
        for (Termin t : termine) {
            System.out.format("%20s 20%s", t, t.getKunde().getVorname() + " " + t.getKunde().getNachname());
        }
        System.out.println("---------------------------------------------");

    }

}
