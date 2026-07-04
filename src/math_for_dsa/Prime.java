package math_for_dsa;

// see Sieve of Eratosthenes for more advanced problems

public class Prime {
    public static void main(String[] args) {
        int n = 20;

        String outputString = "%d is %s\n";

        for(int i = 1; i<=n; i++){
            System.out.format(outputString, i, isPrime(i) ? "Prime" : "Not Prime");
        }

    }

    static boolean isPrime(int n){
        if (n<=1){
            return false;
        }

        int c = 2;

        while(c * c <= n){ // c <= sqrt(n)
            if(n%c == 0){
                return false;
            }
            c++;
        }

        return true;
    }
}
