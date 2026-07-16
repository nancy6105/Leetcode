class Solution {
    public int minimumCost(int[] nums, int k) {
        long sum = 0;
        for(int num : nums){
            sum+=num;
        }
        long temp = sum/k;
        if(sum%k == 0){
            temp--;
        }
        long mod = 1000000007;
        long a = temp%mod;
        long b = (temp+1)%mod;


        long ans = ((a*b)/2) % mod;
        return (int)ans;
    }
}