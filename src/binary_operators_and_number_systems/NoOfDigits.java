package binary_operators_and_number_systems;

public class NoOfDigits {
    public static void main(String[] args) {
        int n = 6; // number
        int b = 2; // base

        int res = (int) (Math.log(n)/Math.log(b)) + 1;

        System.out.println("Number of digits in the binary of 6: "+ res); // log part is change of base formula
    }
}
