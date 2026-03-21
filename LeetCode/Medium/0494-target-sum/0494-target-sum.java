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

        //int dp[][] = new int[n][k + 1];
        int prev[] = new int[k+1];
        if (nums[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;
            if (nums[0] <= k) {
                prev[nums[0]] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            int cur[] = new int[k+1];
            for (int t = 0; t <= k; t++) {
                int notpick = prev[t];
                int pick = 0;
                if (nums[i] <= t) {
                    pick = prev[t - nums[i]];
                }

                cur[t] = pick + notpick;
            }
            prev = cur;
        }

        return prev[k];
    }
}