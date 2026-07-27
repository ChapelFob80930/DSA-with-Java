package recursion.permutations;

public class find_number_of_permutations {
    public static void main(String[] args) {
        System.out.print(permutationCount("", "abc"));
    }

    static int permutationCount(String p, String up){

        if(up.isEmpty()) {
            return 1;
        }

        char ch = up.charAt(0);
        int cnt = 0;

        for(int i = 0; i<=p.length(); i++){
            String s1 = p.substring(0, i);
            String s2 = p.substring(i, p.length());
            cnt = cnt + permutationCount(s1 + ch + s2, up.substring(1));
        }


        return cnt;
    }

}
