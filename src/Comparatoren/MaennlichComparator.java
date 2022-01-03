package programm.Comparatoren;

import java.util.Comparator;

import programm.Person;

/**
 * Comparator fuer zum Vergleich von Personen nach Maennlichkeit.
 * 
 * @author Adrian Plaas-Link und Yann Ahlgrim
 * @version 0.5
 * 
 */
public class MaennlichComparator implements Comparator<Person> {

    @Override
    public int compare(Person a, Person b) {
        return a.compareToMaennlich(b);
    }

}
