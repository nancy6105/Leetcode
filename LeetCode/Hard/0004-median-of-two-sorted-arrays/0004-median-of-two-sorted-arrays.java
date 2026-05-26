class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int len = n+m;
        int mid = len/2;

        int merged[] = new int[len];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n && j < m){
            if((nums1[i] < nums2[j])){
                merged[k++] = nums1[i++];
            }

            else{
                merged[k++] = nums2[j++];
            }
        }

        while(i < n){
            merged[k++] = nums1[i++];
        }

        while(j < m){
            merged[k++] = nums2[j++];
        }

        if(len%2 == 1)return merged[len/2];

        return (merged[len/2] + merged[len/2-1])/2.0;
    }
}