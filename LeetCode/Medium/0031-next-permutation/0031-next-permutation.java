class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n-1;i>0;i--){
            if(nums[i-1] < nums[i]){
                idx = i-1;
                break;
            }
        }

        if(idx != -1){
            int swapIdx = idx;
            for(int j = n-1;j>idx;j--){
                if(nums[j] > nums[idx]){
                   swapIdx = j;
                    break;
                }
            }
            swap(nums,idx,swapIdx);
        }

        reverse(nums,idx);
    }

    void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int nums[],int idx){
        int n = nums.length;
        int i = idx+1;
        int j = n-1;
        while(i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}