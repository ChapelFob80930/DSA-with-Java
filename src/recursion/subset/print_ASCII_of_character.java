package recursion.subset;

import java.util.ArrayList;

public class print_ASCII_of_character {
    public static void main(String[] args) {
        System.out.println(subseq("", "abc"));
    }

    static ArrayList<String> subseq(String p, String up){

        ArrayList<String> temp = new ArrayList<>();

        if(up.isEmpty()){
            temp.add(p);
            return temp;
        }

        char ch = up.charAt(0);

        temp.addAll(subseq(p+(int)ch, up.substring(1)));
        temp.addAll(subseq(p+ch, up.substring(1)));
        temp.addAll(subseq(p,up.substring(1)));

        return temp;
    }
}
