class Solution {
    public int[] plusOne(int[] digits) {

        ArrayList<Integer> ans = new ArrayList<Integer>();

        int carry = 0;

        int digit = digits[digits.length - 1]+1;

        for(int i = digits.length - 1; i>=0; i--){

            System.out.println("Index:"+i);

            if(i != digits.length - 1){
                digit = digits[i] + carry;
                carry = 0;
            }

            System.out.println("digit:"+digit);

            if(digit >= 10){
                carry = digit/10;
            }
            
            System.out.println("carry:"+carry);

            ans.add(0,digit%10);

            System.out.println(ans);

        }

        if(carry!=0){
            ans.add(0,carry);
        }


        int[] finalAns = new int[ans.size()];

        for(int i=0; i<ans.size(); i++){
            finalAns[i] = ans.get(i);
        } 

        return finalAns;

    }
}