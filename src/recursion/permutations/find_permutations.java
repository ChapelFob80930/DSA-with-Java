package recursion.permutations;

import java.util.ArrayList;

public class find_permutations {
    public static void main(String[] args) {
        permutation("", "abc");
        System.out.println("\n"+permutation2("", "abc"));
    }

    static void permutation(String p, String up){
        if(up.isEmpty()) {
                System.out.print(p + ", ");
                return;
        }

        char ch = up.charAt(0);

        for(int i = 0; i<=p.length(); i++){
            String s1 = p.substring(0, i);
            String s2 = p.substring(i, p.length());
            permutation(s1 + ch + s2, up.substring(1));
        }
    }

    static ArrayList<String> permutation2(String p, String up){

        ArrayList<String> ans = new ArrayList<>();

        if(up.isEmpty()) {
            ans.add(p);
            return ans;
        }

        char ch = up.charAt(0);

        for(int i = 0; i<=p.length(); i++){
            String s1 = p.substring(0, i);
            String s2 = p.substring(i, p.length());
            ans.addAll(permutation2(s1 + ch + s2, up.substring(1)));
        }

        return ans;
    }
}
