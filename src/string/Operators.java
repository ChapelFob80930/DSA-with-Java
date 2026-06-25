package string;

import java.util.ArrayList;

public class Operators {

    public static void main(String[] args) {

        // Addition of characters (ASCII/Unicode values)
        System.out.println('a' + 'b');

        // String concatenation
        System.out.println("a" + "b");

        // Character + integer
        System.out.println('a' + 3);

        // Convert back to a character
        System.out.println((char) ('a' + 3));

        System.out.println("a" + 1);

        // Operator overloading:
        // + performs addition for numbers
        // + performs concatenation when at least one operand is a String
        // Java only supports limited built-in operator overloading
        // We cannot create our own operator overloads like in C++

        // This is the same as after a few steps: "a" + "1"

        // int is converted to a String using String.valueOf()
        System.out.println("Sarbojit" + new ArrayList<>());

        System.out.println("Sarbojit" + new Integer(56));

        String ans = new Integer(56) + "" + new ArrayList<>();

        System.out.println(ans);

        // + operator cannot concatenate two arbitrary objects

        // It works for:
        // 1. Primitive arithmetic (+)
        // 2. String concatenation

        // If at least one operand is a String,
        // Java converts the other operand using String.valueOf()
        // which internally may call toString()
    }
}