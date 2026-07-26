package recursion.Strings;

public class skip_string_if_not_required_string {
    public static void main(String[] args) {
        System.out.println(skip("bdapplefappg", "app", "apple"));
    }

    static String skip(String up, String skip, String notSkip){

        if(up.isEmpty()){
            return "";
        }

        if(up.startsWith(skip) && !up.startsWith(notSkip)){
            return skip(up.substring(skip.length()), skip, notSkip);
        }

        else{
            return up.charAt(0) + skip(up.substring(1), skip, notSkip);
        }
    }
}
