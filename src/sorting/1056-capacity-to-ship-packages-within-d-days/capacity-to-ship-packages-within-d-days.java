class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = sum(weights);
        
        int start = max(weights);
        int end = totalWeight;

        while(start<end){
            int mid = start + (end - start)/2;

            System.out.println("Start: "+start);
            System.out.println("mid: "+mid);
            System.out.println("end: "+end);


            if(checkIfValidWeightOfShip(weights, mid, totalWeight, days)){
                end = mid;
            }

            else{
                start = mid + 1;
            }
        }

        return start;
    }

    public int sum(int[] weights){
        int sum = 0;
        for(int w : weights){
            sum += w;
        }
        return sum;
    }

    public int max(int[] weights){
        int max = Integer.MIN_VALUE;
        for(int w : weights){
            if(w>max){
                max = w;
            }
        }
        return max;
    }

    public boolean checkIfValidWeightOfShip(int[] weights, int shipCapacity, int totalWeight, int days){

        int currentLoad = 0;
        int daysUsed = 1;
        int loaded = 0;
        
        for(int w: weights){
            if(currentLoad + w <= shipCapacity){
                currentLoad+=w;
            }
            else{
                loaded += currentLoad; 
                daysUsed ++;
                currentLoad = w;
            }

        }

        if(daysUsed <= days){
            return true;
        }

        return false;
    }
}