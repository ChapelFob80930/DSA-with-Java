package binary_operators_and_number_systems;

public class RangeXOR {
    public static void main(String[] args) {
        // range xor for a,b = xor(b) ^ xor(a-1)
        int a = 3;
        int b = 9;

        System.out.println(xor(b)^xor(a-1));
    }

    //gives xor from 0 to a
    private static int xor(int a){
        if(a%4 == 0){
            return a;
        }

        else if(a%4 == 1){
            return 1;
        }

        else if(a%4 == 2){
            return a+1;
        }

        else{ // when a%4 == 3
            return 0;
        }
    }
}
