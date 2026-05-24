class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<Integer>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(top<=bottom && left<=right){
            // System.out.println("Top before: "+top);
            for(int i = left; i<=right; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            // System.out.println("Top after: "+top);
            // System.out.println("right before: "+right);
            for(int i = top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                // System.out.println("right after: "+right);
                // System.out.println("bottom before: "+bottom);
                for(int i = right; i>=left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
                // System.out.println("bottom after: "+bottom);
                // System.out.println("Left before: "+left);
            if(left<=right){
                for(int i = bottom; i>=top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
                // System.out.println("Left after: "+left);
            }
                
        }
        

        
        
        // while(j!=n){
        //     ans.add(matrix[i][j]);
        // }
        // while(i!=m){
        //     ans.add(matrix[i][j]);
        // }
        // while(j>=0){
        //     ans.add(matrix[i][j]);
        // }
        // while(i>0){
        //     ans.add(matrix[i][j]);
        // }
        // while(j!=n-1){
        //     ans.add(matrix[i][j]);
        // }

        return ans;
    }
}