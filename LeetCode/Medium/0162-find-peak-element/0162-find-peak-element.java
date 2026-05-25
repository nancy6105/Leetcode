class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1)return 0;
        if(nums[0] > nums[1])return 0;
        if(nums[n-1] > nums[n-2])return n-1;
        return binarySearch(nums);
    }
    int binarySearch(int arr[]){
        int l = 1;
        int n = arr.length;
        int r = n-2;

        while(l <= r){
            int mid = l+(r-l)/2;

            if(arr[mid] > arr[mid-1] && arr[mid+1] < arr[mid]){
                return mid;
            }
            else if(arr[mid] > arr[mid-1]){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;
    }
}