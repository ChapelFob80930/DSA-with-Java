class Solution {
    public boolean checkIfPangram(String sentence) {
        char[] charArray = sentence.toCharArray();
        char[] foundArray = new char[charArray.length];
        int uniqueCount = 0;
        int i= 0;
        

        for(char c: charArray){
            boolean seen = false;
            for(char d: foundArray){
                if(d == c)
                {
                    seen = true;
                    break;
                }
            }
            if(!seen){
                foundArray[i] = c;
                uniqueCount++;
                i++;
            }
        }

        if(uniqueCount < 26){
            return false;
        }

        return true;
    }
}