package binary_operators_and_number_systems;

public class OddEven {
    public static void main(String[] args) {
        int n = 68;
        System.out.println(isOdd(n));
    }

    private static boolean isOdd(int n) {
        // internally converted to binary
        return (n & 1) == 1;
    }
}
