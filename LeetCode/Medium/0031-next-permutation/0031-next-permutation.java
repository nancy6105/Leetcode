class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n-1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                idx = i-1;
                break;
            }
        }
        if(idx != -1){
            int swapIdx = idx;
            for(int j = n-1; j >= idx; j--){
                if(nums[j] > nums[idx]){
                    swapIdx = j;
                    break;
                }
            }
            swap(nums,swapIdx,idx);
        }
        reverse(nums,idx+1);
    }

    void swap(int nums[],int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    void reverse(int nums[],int j){
        int n = nums.length;
        while(j < n){
            swap(nums,j,n-1);
            j++;
            n--;
        }
    }
}