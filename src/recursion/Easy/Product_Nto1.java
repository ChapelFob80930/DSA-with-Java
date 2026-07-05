package recursion.Easy;

public class Product_Nto1 {
    public static void main(String[] args) {
        System.out.println(fun(5));;
    }

    private static int fun(int n) {
        if(n==1){
            return 1;
        }
        return n * fun(n-1);
    }
}
