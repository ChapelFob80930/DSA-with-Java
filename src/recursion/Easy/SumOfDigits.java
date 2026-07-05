package recursion.Easy;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(fun(1342));;
    }

    private static int fun(int n) {
        if(n == 0){
            return 0;
        }
        return (n%10) + fun(n/10);
    }
}
