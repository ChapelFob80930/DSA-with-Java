class Solution {
    public int countNegatives(int[][] grid) {
        int r = 0;
        int c = grid[r].length - 1;
        int cnt = 0;

        while(r<grid.length && c >= 0){
            int ub = grid[r][0];
            int lb = grid[r][c];

            if(lb<0){
                cnt+=grid.length-r;
                c--;
            }

            else{
                r++;
            }            
        }
        return cnt; 
    }
}