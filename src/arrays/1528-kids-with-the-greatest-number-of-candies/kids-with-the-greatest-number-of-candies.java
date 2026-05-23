class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max_value = maximum(candies);
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i<candies.length; i++){
            if(candies[i] + extraCandies >= max_value){
                ans.add(i,true);
            }

            else{
                ans.add(i, false);
            }
        }  

        return ans;
    }

    public int maximum(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>maxi){
                maxi = arr[i];
            }
        }
        return maxi;
    }
}