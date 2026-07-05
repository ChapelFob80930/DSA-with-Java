package recursion.Easy;

public class ConceptPassingNumbers {
        public static void main(String[] args) {
           concept(5);
        }

        private static void concept(int n) {
            if(n == 0){
                return;
            }
            System.out.println(n);
            concept(--n);

            // n-- passes value of n first and then subtracts it afterward
            // --n subtracts the value of n first and then passes it
        }
}
