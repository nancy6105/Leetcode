class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer,Long> mp = new HashMap<>();
        mp.put(0,1L);
        int xor = 0;
        long cnt = 0;
        for(int i : nums){
            xor^=i;
            if(mp.containsKey(xor)){
                cnt+=mp.get(xor);
            }
            mp.put(xor,mp.getOrDefault(xor,0L)+1);
        }
        return cnt; 
    }
}