class Solution {

    public boolean checkSpeed(int[] piles, int h, int k){
        int totalTimeSpent = 0;
        for(int p: piles){
            totalTimeSpent += (p+k-1)/k;
        }

        if(totalTimeSpent > h){
            return false;
        }

        return true;
    }

    public int findMax(int[] piles){
        int max = Integer.MIN_VALUE;

        for(int p: piles){
            if(p>max){
                max = p;
            }
        }

        return max;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = findMax(piles);

        while(start<end){
            int mid = start + (end - start) / 2;

            System.out.println("start: "+start);
            System.out.println("end: "+end);
            System.out.println("mid: "+mid);
            System.out.println();

            if(checkSpeed(piles, h, mid)){
                end = mid;
            }

            else{
                start = mid + 1;
            }

        }

        return start;
    }
}