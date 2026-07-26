package recursion.subset;

import java.util.ArrayList;

public class subsequences {
    public static void main(String[] args) {
        subseq("", "abc");
        ArrayList<String> ans = subseq2("", "abc");
        ans.sort((a,b) -> a.compareTo(b));
        ans.sort((a, b) -> a.length()-b.length());
        System.out.println(ans);
    }

    static void subseq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p+", ");
            return;
        }

        char ch = up.charAt(0);

        subseq(p+ch, up.substring(1));

        subseq(p,up.substring(1));
    }

    static ArrayList<String> subseq2(String p, String up){

        ArrayList<String> temp = new ArrayList<>();

        if(up.isEmpty()){
            temp.add(p);
            return temp;
        }

        char ch = up.charAt(0);

        temp.addAll(subseq2(p+ch, up.substring(1)));

        temp.addAll(subseq2(p,up.substring(1)));

        return temp;
    }
}
