package programm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 
 * @author adria
 *
 */
public class Termin implements Comparable<Termin> {

    LocalDateTime zeit;
    Kunde kunde;
    Friseur friseur;

    Termin(Kunde kunde, Friseur friseur) {
        this.kunde = kunde;
        this.friseur = friseur;
    }

    public Termin(String path) {
        try {
            BufferedReader buffreader = new BufferedReader(new FileReader(path));
            String nextLine;
            while ((nextLine = buffreader.readLine()) != null) {
                System.out.println(nextLine);
                String[] inputs = nextLine.split(": ");
                switch (inputs[0]) {
                case "Datum":
                    this.zeit = LocalDateTime.of(Integer.parseInt(inputs[1]),
                            Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]),
                            Integer.parseInt(inputs[4]), Integer.parseInt(inputs[5]));
                    break;
                case "Kunde":
                    if (Friseursalon.getKunden().contains(new Kunde("inputs[1]", inputs[2]))) {
                        this.kunde = Friseursalon.getKunden().get(Friseursalon.getKunden()
                                .indexOf(new Kunde("inputs[1]", inputs[2])));
                    } else {
                        kunde = new Kunde();
                    }
                    break;
                case "Friseur":

                }
            }
            buffreader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * public Termin(String input) { try { String[] inputs = input.split(", ");
     * String[] time = inputs[1].split(":");
     * 
     * /* LocalDate muss so "jjjj-mm-dd" angegeben werden (fürs erste) und LocalTime
     * "h:m" so
     **/
    /*
     * this.datum = LocalDate.parse(inputs[0]); this.zeit =
     * LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1])); } catch
     * (Exception e) { System.out.println("Sie haben das falsche Format"); }
     * 
     * }
     **/

    public LocalDateTime getZeit() {
        return zeit;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Friseur getFriseur() {
        return friseur;
    }

    public void setZeit(LocalDateTime ldt) {
        this.zeit = ldt;
    }

    public void setKunde(Kunde k) {
        this.kunde = k;
    }

    public void setFriseur(Friseur f) {
        this.friseur = f;
    }

    public String toString() {
        return zeit.toString();
    }

    @Override
    public int compareTo(Termin o) {
        // TODO Automatisch generierter Methodenstub
        return 0;
    }

}
