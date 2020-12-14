/**
 * Beschreiben Sie hier die Klasse Eratosthenes.
 * 
 * @author Philipp Stappert 
 * @version d20201214 (v1.0)
 */
public class Eratosthenes {
    // Instanzvariablen 

    // Liste, welche den natürlichen Zahlen von 0 bis zu einer gegebenen Größe N einen Wahrheitswert bzgl. ihrer Primalität zuordnet
    private boolean[] numberList; 
    // Liste, welche die Primzahlen bis zu einer gegebenen Größe N beinhaltet
    private int[] primeList;

    /**
     * Konstruktor für Objekte der Klasse Eratosthenes
     */
    public Eratosthenes(int N){
        // Erste Instanzvariable initialisieren
        // Liste mit Einträgen für die Zahlen von 0 bis N vorbereiten
        numberList = new boolean[N+1];

        // "Sieb des Eratosthenes":
        // Alle Zahlen von 2 bis N vorläufig auf "prim" setzen
        for (int i = 0; i <= N; i++){
            numberList[i] = true;
        }

        //# AUFGABE 1a: Erstelle diesen fehlenden Teil für den Sieb-Algorithmus.

        // Die geraden Zahlen > 2 aussieben, d. h. auf "zusammengesetzt" setzen
        for (int i = 4; i <= N; i += 2){
            numberList[i] = false;
        }

        //# AUFGABE 1b: Erstelle diesen fehlenden Teil für den Sieb-Algorithmus.

        // Wähle die nächste Zahl nach 2 aus der Liste aus
        // Solange das Quadrat dieser Zahl <= N ist, siebe alle Vielfachen dieser Zahl aus der Liste
        // D. h. Setze Laufvariable k = 2 und solange das k-fache der Zahl <= N ist, siebe sie aus und erhöhe k um 1
        // Wähle die nächste in der Liste verbliebene Zahl aus.
        for (int i = 3; i <= N; ){
            System.out.println(i);
            for (int j = 2*i; j <= N; j += i){
                numberList[j] = false;
                System.out.println(j);
            }
            i = nextTrueValue(numberList, i, N);
            if (i == -1){
                break;
            }
            System.out.println("===========");
        }
        System.out.println("#################");
        for (int i = 0; i <= N; i++){
            if (numberList[i] == true){
                System.out.println(i);
            } else {
                System.out.println("no: " + i);
            }
        }

        //# AUFGABE 1c: Erstelle diesen fehlenden Teil für den Sieb-Algorithmus.

        // Zweite Instanzvariable initialisieren 
        // Die Primzahlliste hat soviel Einträge wie Primzahlen in der Liste der natürlichen Zahlen vorkommen
        // Es wird also Methode numberOfPrimes() benötigt!
        primeList = new int[numberOfPrimes()];

        // Trage die Primzahlen in die Liste ein

        //# AUFGABE 3: Erstelle diesen Teil für die Liste

    }

    public int nextTrueValue (boolean[] inpArray, int beginWith, int maxVal){
        int solution = -1;
        for (int t = beginWith; t <= maxVal; t++){
            if (inpArray[t] == true){
                System.out.println("Found solution");
                solution = t;
                break;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println("Running script...");
        new Eratosthenes(20);
    }

    /**
     * Methode, welche die Anzahl der Primzahlen in der Liste der natürlichen Zahlen ermittelt
     * 
     * @return      Anzahl der Primzahlen bis zu einer Größe N
     */

    public int numberOfPrimes(){
        int n = 0;

        //# AUFGABE 2: Erstelle diese Methode

        return n;
    }

    /**
     * Methode zur Ausgabe der n-ten Primzahl
     * 
     * @param  n    Natürliche Zahl zur Angabe des Gliedes in der Folge der Primzahlen
     * @return      n-te Primzahl
     */

    public int nthPrime(int n){ 
        int p = -1;

        //# AUFGABE 4: Erstelle diese Methode

        return p;
    }

    /**
     * Methode zum Prüfen, ob eine Zahl eine Primzahl ist
     * 
     * @param  n    Natürliche Zahl, deren Primalität überprüft wird
     * @return      Wahrheitswert, ob die Zahl prim (true) oder zusammengesetzt (false) ist
     */

    public boolean isPrime(int n){
        // Zur Ermittlung der Länge einer Liste verwende "Liste.length"

        //# AUFGABE 5: Erstelle diese Methode

        return false;
    }

}