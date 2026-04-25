class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>res = new ArrayList<>();

        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i : nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }

        for(int key : mp.keySet()){
            if(mp.get(key) > n/3){
                res.add(key);
            }
        }
        return res;
    }
}