package math_for_dsa;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
//        factors1(20);
//        factors2(20);
        factors3(20);
    }

    // O(n)
    static void factors1(int n){
        System.out.print("Factors of "+n+": ");
        for(int i = 1; i<=n; i++){
            if(n % i == 0){
                System.out.print(i+" ");
            }
        }
    }

    // O(sqrt(n))
    static void factors2(int n){
        System.out.print("Factors of "+n+": ");
        for(int i = 1; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                if(n/i == i){
                    System.out.println(i+" ");
                }
                else{
                    System.out.print(i+" "+n/i+" ");
                }
            }
        }
    }

    // here both time and space will be O(sqrt(n)) as we are storing to print in sorted order
    static void factors3(int n){
        ArrayList<Integer> list = new ArrayList<>(); // here the larger factors will be stored in descending order i.e. the n/i part
        // we store sqrt(n)/2 numbers but since constants don't matter in complexity, space complexity is O(sqrt(n))
        System.out.print("Factors of "+n+": ");
        for(int i = 1; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                if(n/i == i){
                    System.out.println(i+" ");
                }
                else{
                    System.out.print(i+" ");
                    list.add(n/i);
                }
            }
        }

        for(int i = list.size()-1; i>=0; i--){
            System.out.print(list.get(i)+" ");
        }
    }
}

