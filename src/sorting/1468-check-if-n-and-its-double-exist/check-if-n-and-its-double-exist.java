class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> doubles = new HashMap<>();

        for(int i = 0; i<arr.length; i++){
            doubles.put(2*arr[i],i);
        }

        for(int i = 0; i<arr.length; i++){

            var j = doubles.get(arr[i]);

            if(j!=null && j!=i)
            {
                return true;
            }
        }

        return false;
    }
}