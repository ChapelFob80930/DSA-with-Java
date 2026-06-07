class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        HashSet<Integer> newBobSizes = new HashSet<>();

        for(int i:bobSizes){
            newBobSizes.add(i);
        }

        int diff = (sum(bobSizes) - sum(aliceSizes)) / 2;

        for(int x: aliceSizes){
            int y = x+diff;
            if(newBobSizes.contains(y))
            {
                return new int[] {x,y};
            }
        }

        return new int[] {-1, -1};
    }

    public int sum(int arr[]){ 
        int sum = 0; 
        for(int i:arr){
            sum+=i; 
        } 
            return sum; 
    }    
}