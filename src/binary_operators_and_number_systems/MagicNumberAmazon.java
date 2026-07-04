package binary_operators_and_number_systems;

public class MagicNumberAmazon {
    public static void main(String[] args) {
        int n = 1;
        int base = 5; // in this case we start with 5^1 and not 5^0
        int magicNumber = 0;
        String outputStatement = "%dth magic number is %d";
        int n_copy = n;

        while(n!=0){
            int  last = n & 1;
            n = n >> 1;
            magicNumber += last * base;
            base *= 5;
        }

        System.out.format(outputStatement,n_copy,magicNumber);
    }
}
