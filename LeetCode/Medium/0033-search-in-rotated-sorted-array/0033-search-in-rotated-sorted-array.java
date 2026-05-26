class Solution {
    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        if(pivot == 0){
            return binarySearch(nums,0,nums.length-1,target);
        }
        if(target >= nums[0] && target <= nums[pivot-1]){
            return binarySearch(nums,0,pivot-1,target);
        }
            return binarySearch(nums,pivot,nums.length-1,target);
    }

    int binarySearch(int arr[],int l,int r,int target){
        while(l <= r){
            int mid = l+(r-l)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;
    }
    int getPivot(int arr[]){
        int n = arr.length;
        int l = 0;
        int r = n-1;

        while(l < r){
            int mid = l + (r-l)/2;

            if(arr[mid] > arr[r]){
                l = mid+1;
            }
            else{

                r = mid;
            }
        }
        return l;
    }
}