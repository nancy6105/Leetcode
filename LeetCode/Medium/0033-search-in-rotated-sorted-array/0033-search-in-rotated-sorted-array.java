class Solution {
    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        int n = nums.length-1;

        if(pivot == 0){
            return binarySearch(nums,0,n,target);
        }
        if(target >= nums[0] && target <= nums[pivot-1]){
            return binarySearch(nums,0,pivot-1,target);
        }
        return binarySearch(nums,pivot,n,target);
    }

    int binarySearch(int nums[],int low,int high,int target){
        while(low <= high){
            int mid = low+(high-low)/2;

            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

    public int getPivot(int nums[]){
        int low = 0;
        int high = nums.length-1;

        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
                low = mid+1;
            }

            else{
                high = mid;
            }
        }
        return low;
    }
}