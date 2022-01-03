package programm.Comparatoren;

import java.util.Comparator;

import programm.Adresse;
import programm.Person;

/**
 * Comparator für Adressen.
 * 
 * @author Adrian Plaas-Link und Yann Ahlgrim
 * @version 0.5
 * 
 */
public class AdressenComparator implements Comparator<Person> {

    @Override
    public int compare(Person a, Person b) {
        return a.compareToAdresse(b);
    }

    public int compare(Adresse a, Adresse b) {
        return a.compareTo(b);
    }
}
