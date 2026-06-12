class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int solRow = findRow(matrix, target);
        System.out.println(solRow);
        if(solRow == -1){
            return false;
        }
        return binarySearch(matrix[solRow], target);
    }

    public int findRow(int[][] matrix, int target){
        int top = 0;
        int bottom = matrix.length - 1;

        while(top<=bottom){
            int row = top + (bottom - top) / 2;            
            
            if(matrix[row][0] > target){
                bottom = row - 1;
            }

            else if(matrix[row][matrix[row].length - 1] < target){
                top = row + 1;
            }

            else{
                return row;
            }
        }

        return -1;
    }

    public boolean binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start<=end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return true;
            }

            else if(arr[mid] > target){
                end = mid - 1;
            }

            else{
                start = mid + 1;
            }
        }

        return false;
    }
}