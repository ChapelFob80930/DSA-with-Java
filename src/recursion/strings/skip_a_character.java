package recursion.Strings;

public class skip_a_character {
    public static void main(String[] args) {
        skip1("","baccad");
        System.out.println(skip2("baccad", 'a'));
        System.out.println(skip3("baccad", 'a'));
    }

    static void skip1(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if(ch != 'a'){
            skip1(p + ch, up.substring(1));
        }

        else{
            skip1(p, up.substring(1));
        }
    }

    static String skip2(String up, char skip){

        if(up.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        char ch = up.charAt(0);

        if(ch != skip){
            sb.append(ch);
            sb.append(skip2(up.substring(1), skip));
        }

        else{
            sb.append(skip2(up.substring(1), skip));
        }

        return sb.toString();
    }

    static String skip3(String up, char skip){

        if(up.isEmpty()){
            return "";
        }

        char ch = up.charAt(0);

        if(ch != skip){
            return ch + skip3(up.substring(1), skip);
        }

        else{
            return skip3(up.substring(1), skip);
        }
    }
}
