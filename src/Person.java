package programm;

public abstract class Person implements Comparable<Person> {
    private Adresse adresse;
    private int alter;
    private String vorname;
    private String nachname;
    private boolean maennlich;
    private long telefonnummer;
    String versicherung;

    public Person() {
    }

    /**
     * Methode welche unter Angabe der noetigen Parameter eine Person initialisiert.
     * 
     * @param adresse
     * @param alter
     * @param vorname
     * @param nachname
     * @param maennlich
     * @param telefonnummer
     * @param versicherung
     */
    public Person(Adresse adresse, int alter, String vorname, String nachname, boolean maennlich,
            long telefonnummer, String versicherung) {
        this.adresse = adresse;
        this.alter = alter;
        this.vorname = vorname;
        this.nachname = nachname;
        this.maennlich = maennlich;
        this.telefonnummer = telefonnummer;
        this.versicherung = versicherung;
    }

    /**
     * Methode welche eine Textrepresentation des Objektes zurueckgibt.
     */
    public String toString() {
        return "Adresse: " + adresse + ", Alter: " + alter + ", vorname: " + vorname
                + ", Nachname: " + nachname + ", m�nnlich: " + maennlich + ", Telefonnummer: "
                + telefonnummer;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setMaennlich(boolean maennlich) {
        this.maennlich = maennlich;
    }

    public void setTelefonnummer(long telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setVersicherung(String versicherung) {
        this.versicherung = versicherung;
    }

    public int getAlter() {
        return alter;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public boolean getMaennlich() {
        return maennlich;
    }

    public long getTelefonnummer() {
        return telefonnummer;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getVersicherung() {
        return versicherung;
    }

    /**
     * Methode zum Vergleich der Person mit gegebener anderer Person nach Namen.
     */
    public int compareTo(Person o) {
        return compareToName(o);
    }

    /**
     * Methode zum Vergleich der Person mit gegebener anderer Person nach Namen.
     */
    public int compareToName(Person o) {
        return (getVorname() + getNachname()).compareTo(o.getVorname() + o.getNachname());
    }

    /**
     * Methode zum Vergleich der Person mit gegebener anderer Person nach Adresse.
     */
    public int compareToAdresse(Person o) {
        return adresse.compareTo(o.getAdresse());
    }

    /**
     * Methode zum Vergleich der Person mit gegebener anderer Person nach Alter.
     */
    public int compareToAlter(Person o) {
        return Integer.compare(alter, o.getAlter());
    }

    /**
     * Methode zum Vergleich der Person mit gegebener anderer Person nach
     * Versicherung.
     */
    public int compareToVersicherung(Person o) {
        return this.getVersicherung().compareTo(o.getVersicherung());
    }

    /**
     * Methode zum Vergleich der Person mit gegebener anderer Person nach
     * Maennlichkeit. Siehe Boolean.compare(Boolean a, Boolean b)
     * 
     * @return Gibt 1 zurueck wenn a wahr und b falsch ist, 0 wenn beide gleich sind
     *         und -1 wenn a falsch und b wahr ist.
     */
    public int compareToMaennlich(Person o) {
        return Boolean.compare(getMaennlich(), o.getMaennlich());
    }
}
