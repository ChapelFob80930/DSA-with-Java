package recursion.Strings;

public class skip_a_string {
    public static void main(String[] args) {
        System.out.println(skip("bdapplefg", "apple"));
    }

    static String skip(String up, String skip){

        if(up.isEmpty()){
            return "";
        }

        if(!up.startsWith(skip)){
            return up.charAt(0) + skip(up.substring(1), skip);
        }

        else{
            return skip(up.substring(skip.length()), skip);
        }
    }
}
