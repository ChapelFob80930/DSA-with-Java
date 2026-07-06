package recursion.Easy;

public class ProductOfDigits {
    public static void main(String[] args) {
        System.out.println(fun(1342));;
    }

    private static int fun(int n) {
        if(n%10 == n){
            return n;
        }
        return (n%10) * fun(n/10);
    }
}
