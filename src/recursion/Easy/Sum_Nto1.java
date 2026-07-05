package recursion.Easy;

public class Sum_Nto1 {
    public static void main(String[] args) {
        System.out.println(fun(5));
        System.out.println(fun2(5));
    }

    private static int fun(int n) {
        if(n==1){
            return 1;
        }
        return n + fun(n-1);
    }

    private static int fun2(int n) {
        return n * (n + 1) / 2;
    }

}
