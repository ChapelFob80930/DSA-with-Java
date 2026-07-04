package math_for_dsa;

public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println("gcd = "+gcd(2, 7));
        System.out.println("lcm = "+lcm(2, 7));
    }

    static int gcd(int a, int b){
        // by Euclidean Algorithm gcd(a,b) = gcd(remainder(b/a) , a)
        a = Math.abs(a);
        b = Math.abs(b);

        if(a==0){
            return b;
        }

        return gcd(b%a, a);
    }

    static int lcm(int a, int b){
        // lcm(a,b) = (a * b) / gcd(a,b)
        return (a*b)/gcd(a,b);
    }
}
