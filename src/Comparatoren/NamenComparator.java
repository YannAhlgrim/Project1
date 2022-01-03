package programm.Comparatoren;

import java.util.Comparator;

import programm.Person;

/**
 * Comparator fuer zum Vergleich von Personen nach Name.
 * 
 * @author Adrian Plaas-Link und Yann Ahlgrim
 * @version 0.5
 * 
 */
public class NamenComparator implements Comparator<Person> {

    @Override
    public int compare(Person a, Person b) {
        return a.compareToName(b);
    }

}
