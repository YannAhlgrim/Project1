package programm;

public class NuetzlicheMethoden {

    /**
     * Methode welche ueberprueft ob ein String nur Zahlen enthaelt.
     * 
     * @param str Eingabewort.
     * @param n   Zahl der Stellen welche ueberprueft werden sollen.
     * @return Gibt ja aus wenn das Wort nur aus Zahlen besteht und falsch wenn
     *         nicht.
     */
    public static boolean onlyDigits(String str, int n) {
        for (int i = 0; i < n; i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Methode welche den absoluten Pfad zum Folder 'Files' des Projekts auf der
     * verwendeten Maschine ausgibt.
     * 
     * @return Absoluten Pfad als String.
     */
    public static String absolutePathToFilesFolder() {
        return System.getProperty("user.dir") + "\\src\\programm\\Files\\";
    }
}
