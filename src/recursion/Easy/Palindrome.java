package recursion.Easy;

public class Palindrome {
    public static void main(String[] args) {
        int n = 121;
        System.out.println(rev(n) == n);
    }

    private static int rev(int n) {
        if (n % 10 == n) {
            return n;
        }

        int digits = (int) (Math.log10(n)) + 1;

        return (n % 10) * (int) Math.pow(10, digits - 1)
                + rev(n / 10);
    }
}
