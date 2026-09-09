class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int mid = n/2;

        long total = 0;

        for(int i = 0;i<n;i++){
            total += nums[i];
        }

        long first = 0;
        for(int i = 0;i<n/2;i++){
            first += nums[i];
        }

        int ans = 0;

        if(first > total - first){
            ans++;
        }

        for(int i = 1;i<n;i++){
            first += nums[(i + mid - 1)%n];
            first -= nums[i-1];

            if(2*first > total){
                ans++;
            }
        }

        return ans;
    }
}