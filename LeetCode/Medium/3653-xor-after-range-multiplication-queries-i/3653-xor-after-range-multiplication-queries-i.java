class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {

        for(int q[] : queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            int idx = l;
            while(idx <= r){
                nums[idx] = (int)((nums[idx]*1L*v)%(1000000007));
                idx += k;
            }
        }

        int res = 0;
        for(int i : nums){
            res ^= i;
        }
        return res;
    }
}