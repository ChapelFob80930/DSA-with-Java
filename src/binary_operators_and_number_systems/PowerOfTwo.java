package binary_operators_and_number_systems;

import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n != 0){
            boolean ans = (n & (n-1)) == 0;
            System.out.println(ans);
        }

        else{
            System.out.println(false);
        }

    }
}
