class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int [] freq = new int[n];

        for(int i : nums){
            if(i >= n)return false;

            if(i < n-1 && freq[i] > 0)return false;
            if(i == n-1 && freq[i] > 1)return false;

            freq[i]++;
        }

        return true;
    }
}