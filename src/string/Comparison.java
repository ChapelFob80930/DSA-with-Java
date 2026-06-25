package string;

public class Comparison {

    public static void main(String[] args) {

        String a = "Sarbojit";
        String b = "Sarbojit";

        String c = a;
        System.out.println(a.charAt(0));
        System.out.println(c == a);

        // == checks if both references point to the same object
        System.out.println(a == b);

        String name1 = new String("Sarbojit");
        String name2 = new String("Sarbojit");

        System.out.println(name1 == name2);

        // .equals() checks the actual contents
        System.out.println(name1.equals(name2));
    }
}