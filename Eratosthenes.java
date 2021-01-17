/**
 * class Erastothenes is used to work with primes
 * 
 * @author Philipp Stappert 
 * @version d20201214 (v1.0)
 */

public class Eratosthenes {
    // vars
    private boolean[] numberList; // list with all numbers (in range)
    private int[] primeList; // list with only primes

    /**
     * constructor for class Erastothenes
     * 
     * @param N maximum for prime calculation
     */
    public Eratosthenes(int N){
        numberList = new boolean[N+1]; // create list object
        
        // set all numbers above 1 to true
        for (int i = 2; i <= N; i++){
            numberList[i] = true;
        }

        // sieve primes
        for(int i = 2; i*i <= N; i++){
            // if number is prime,
            if (numberList[i] == true){
                // sieve all multiples
                for (int j = i*i; j <= N; j += i){
                    numberList[j] = false;
                }
            }
        }

        // create only primes list object
        primeList = new int[numberOfPrimes()];

        // fill primes list
        int q = 0;
        for(int i = 0; i < N; i++){
            if(numberList[i] == true){
                primeList[q] = i;
                q++;
            }
        }
    }

    /**
     * main function to test class
     */
    public static void main(String[] args) {
        Eratosthenes testSieb = new Eratosthenes(50);
        System.out.println(testSieb.nthPrime(15));
        System.out.println(testSieb.isPrime(17));
    }

    /**
     * returns how many primes are in the number list (count)
     * 
     * @return prime count
     */
    public int numberOfPrimes(){
        int n = 0;

        // iterate threw list and count
        for(int i = 0; i < numberList.length; i++) {
            if(numberList[i] == true){
                n++;
            }
        }

        return n;
    }

    /**
     * function to get nth prime
     * 
     * @param n (nth prime to get)
     * @return the nth prime
     */
    public int nthPrime(int n){ 
        // set standard value (P.S.: warum eigentlich? theoretisch könnte ich das weglassen, wird ja sowieso abgefangen)
        int p = -1;

        // try to get prime out of list
        try {
            // get nth prime
            p = primeList[n-1];

        } catch (Exception e) {
            // on error: set to -1
            p = -1;
        }
        
        // return result
        return p;
    }

    /**
     * checks whether n is a prime or not
     * 
     * @param n prime to check
     * @return bool is a prime or not
     */
    public boolean isPrime(int n){
        try {
            return(numberList[n]);
        } catch (Exception e) {
            throw new ArithmeticException("The given number is out of the sieves range. Please create a new sieve instance with higher maximum.");
        }
    }
}