class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int i : nums) {
            total += i;
        }

        int k = (total + target) / 2;
        if (Math.abs(target) > total)
            return 0;

        if ((total + target) % 2 != 0)
            return 0;

        int dp[][] = new int[n][k + 1];

        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            if (nums[0] <= k) {
                dp[0][nums[0]] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= k; t++) {
                int notpick = dp[i - 1][t];
                int pick = 0;
                if (nums[i] <= t) {
                    pick = dp[i-1][t - nums[i]];
                }

                dp[i][t] = pick + notpick;
            }
        }

        return dp[n - 1][k];
    }
}