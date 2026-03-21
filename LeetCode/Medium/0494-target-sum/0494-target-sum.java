class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        for(int i : nums){
            s+=i;
        }
        int k = (target + s)/2;
        
        if(target > s)return 0;

        if((s+target)%2 != 0)return 0;

        return sol(0,0,k,nums);
    }
    int sol(int idx,int sum,int k,int a[]){
        if(idx == a.length){
            if(sum == k)return 1;
            else{
                return 0;
            }
        }

        int notpick = sol(idx+1,sum,k,a);
        int pick = 0;
        if(sum + a[idx] <= k){
            pick = sol(idx+1,sum+a[idx],k,a);
        }

        return notpick+pick;
    }
}