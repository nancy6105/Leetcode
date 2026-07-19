class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = bs(nums, target, true);
        int last = bs(nums, target, false);

        return new int[]{first,last};
    }

    int bs(int arr[],int t,boolean flag){
        int l = 0;
        int n = arr.length;
        int r = n-1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(arr[mid] == t){
                ans = mid;
                if(flag){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else if(t < arr[mid]){
                r = mid-1;
            }
            else{
                l = mid+1;
            }   
        }

        return ans;
    }
}