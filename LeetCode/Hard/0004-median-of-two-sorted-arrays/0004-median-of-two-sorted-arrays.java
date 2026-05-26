class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int arr[] = new int[n+m];

        int k = 0;

        for(int num : nums1){
            arr[k++] = num;
        }

        for(int num : nums2){
            arr[k++] = num;
        }

        Arrays.sort(arr);
        int len = n+m;

        if(len%2 == 1)return arr[len/2];

        return (arr[len/2]+arr[len/2 - 1])/2.0;
    }
}