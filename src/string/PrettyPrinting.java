package string;

public class PrettyPrinting {
    public static void main(String[] args) {
        float a =453.1234f;
        System.out.printf("Formatted number is %.2f", a);

        float b =453.1266f;
        System.out.printf("\nFormatted number is %.2f\n", b);

        System.out.println(Math.PI);

        System.out.printf("\nPie: %.3f\n",Math.PI);

        System.out.printf("Hello my name is %s and I am %s", "Sarbojit", "mentally ill");
    }
}
