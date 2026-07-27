package recursion;

import java.util.ArrayList;

public class phonePad {
    public static void main(String[] args) {
        System.out.println(padList("", "12"));
        pad("", "12");
        System.out.println(padCount("", "12"));
    }

    static void pad(String p, String up){


        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            pad(p + (char)('a' + i), up.substring(1));
        }

    }
    static ArrayList<String> padList(String p, String up){

        ArrayList<String> ans =new ArrayList<>();

        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }

        int digit = up.charAt(0) - '0';

        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            ans.addAll(padList(p + (char)('a' + i), up.substring(1)));
        }

        return ans;
    }

    static int padCount(String p, String up){

        if(up.isEmpty()){
            return 1;
        }

        int digit = up.charAt(0) - '0';
        int cnt = 0;

        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            cnt += padCount(p + (char)('a' + i), up.substring(1));
        }

        return cnt;
    }
}
