package recursion;

public class FibonacciNumbers {
    public static void main(String[] args) {
        printFibonacciNumbers(0, 1, 8);
        System.out.println("\n"+findFibonacciNumber(4));
    }

    private static void printFibonacciNumbers(int n1, int n2, int n) {
        if(n==0){
            System.out.println(n1);
        }
        else{
            System.out.println(n1);
            printFibonacciNumbers(n2,n1+n2,n-1);
        }
    }

    private static int findFibonacciNumber(int n) {
        if(n<2){
            return n;
        }
        else{
            return findFibonacciNumber(n-1) + findFibonacciNumber(n-2);
        }
    }
}
