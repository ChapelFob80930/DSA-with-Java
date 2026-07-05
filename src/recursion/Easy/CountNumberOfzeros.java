package recursion.Easy;

public class CountNumberOfzeros {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(count(n));
        System.out.println(count2(n, 0));
    }

    private static int count(int n) {
        if(n == 0){
            return 1;
        }

        if(n%10 == n){
            return 0;
        }

        else if(n%10 == 0){
            return 1 + count(n/10);
        }

        return count(n/10);
    }

    private static int count2(int n, int c) {
        if(n == 0){
            return c;
        }

        if(n%10 == 0){
            return count2(n/10, c+1);
        }

        return count2(n/10, c);
    }
}
