class Solution {
    public long maxPairStrength(int[] nums) {
        int n = nums.length;

        long ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){

                long gcd = gcd(nums[i], nums[j]);
                ans = Math.max(ans, ((long)nums[i]*nums[j]) / (gcd * gcd));
            }
        }

        return ans;
    }

    long gcd(long x, long y){

        while(y != 0){
            long temp = x % y;
            x = y;
            y = temp;
        }

        return x;
    }
}