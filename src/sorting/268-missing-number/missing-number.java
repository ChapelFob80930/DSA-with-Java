class Solution {

    public int missingNumber(int[] arr) {

        cycle_sort(arr);
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != i){
                return i;
            }
        }

        return arr.length;
    }


    public void cycle_sort(int[] arr){

        int i = 0;

        while(i < arr.length){

            if(arr[i]<arr.length)
            {
                int correct = arr[i];

                if(arr[i] != arr[correct]){

                    swap(arr, i, correct);
                }

                else{

                    i++;
                }
            }

            else{
                i++;
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}