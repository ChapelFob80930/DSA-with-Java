class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, 0, 0, "", n);
        return res; 
    }

    public void generate(List<String> res, int left, int right, String s, int n){
        if(s.length() == n * 2){
            res.add(s);
        }

        if(left < n){
            generate(res, left+1, right, s+"(", n);
        }

        if(right < left){
            generate(res, left, right+1, s+")", n);
        }
    }
}