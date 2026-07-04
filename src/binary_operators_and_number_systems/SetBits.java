package binary_operators_and_number_systems;

public class SetBits {
    public static void main(String[] args) {
        int n = 45;

        System.out.println((Integer.toBinaryString(n)));

        System.out.println(setBits(n));
    }

    private static int setBits(int n) {
        int cnt = 0;

//        while(n!=0){
//            cnt++;
//            n = n - (n&(-n));
//        }

        while(n!=0){
            cnt++;
            n = n & (n-1);
        }

        return cnt;
    }
}
