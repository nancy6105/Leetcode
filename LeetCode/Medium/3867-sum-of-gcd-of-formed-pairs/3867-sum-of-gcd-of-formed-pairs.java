class Solution {
    public long gcdSum(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        long prefixGcd[] = new long[n];

        for(int i = 0;i<n;i++){
            max = Math.max(max,nums[i]);
            prefixGcd[i] = gcd(nums[i],max);
        }

        Arrays.sort(prefixGcd);
        int i = 0;
        int j = n-1;

        long ans = 0;
        while(i < j){
            long p_a = prefixGcd[i];
            long p_b = prefixGcd[j];

            ans += gcd(p_a,p_b);
            i++;
            j--;
        }
        return ans;
    }

    long gcd(long a,long b){
        while(b!=0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}