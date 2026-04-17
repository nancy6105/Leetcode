class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        int ans = n + 1;
        for(int i = 0;i<n;i++){
            int x = nums[i];
            if(mp.containsKey(x)){
                ans = Math.min(ans,i-mp.get(x));
            }
            mp.put(reverse(x),i);
        }
        return ans == n+1 ? -1 : ans;
    }
    private int reverse(int x){
        int y = 0;
        while(x > 0){
            y = y * 10 +(x % 10);
            x = x/10; 
        }
        return y;
    }
}