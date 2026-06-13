class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] A = nums1;
        int[] B = nums2;

        if(nums1.length > nums2.length){
            int[] temp = A;
            A = B;
            B = temp;
        }

        int half = total / 2;

        int l = -1;
        int r = A.length - 1;

        while(l<=r){
            int i = l + (r-l+1) / 2;

            int j = half - i - 2;
        
            int Aleft  = (i >= 0) ? A[i] : Integer.MIN_VALUE;
            int Aright = (i + 1 < A.length) ? A[i + 1] : Integer.MAX_VALUE;
            int Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
            int Bright = (j + 1 < B.length) ? B[j + 1] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                //odd
                if(total%2 == 1){
                    return Math.min(Aright, Bright);
                }

                //even
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2.0;
            }

            else if(Aleft > Bright){
                r = i - 1;
            }

            else{
                l = i + 1;
            }  
        }
        return -1;
    }
}