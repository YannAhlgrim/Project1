package programm.Comparatoren;

import java.util.Comparator;

import programm.Person;

/**
 * Comparator fuer Alter.
 * 
 * @author Adrian Plaas-Link und Yann Ahlgrim
 * @version 0.5
 * 
 */
public class AlterComparator implements Comparator<Person> {

    @Override
    public int compare(Person a, Person b) {
        return a.compareToAlter(b);
    }
}
