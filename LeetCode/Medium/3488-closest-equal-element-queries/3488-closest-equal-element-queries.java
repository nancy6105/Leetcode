class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i = 0;i<n;i++){
            mp.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        }
        List<Integer>res = new ArrayList<>();

        for(int q : queries){
            int element = nums[q];
            List<Integer>vec = mp.get(element); 
            int size = vec.size();

            if(size == 1){
                res.add(-1);
                continue;
            } 
            int pos = Collections.binarySearch(vec,q);
            int ans = Integer.MAX_VALUE;

            int right = vec.get((pos+1)%size);
            int d = Math.abs(right-q);
            int cirDist = n-d;
            ans = Math.min(ans,Math.min(d,cirDist));

            int left = vec.get((pos-1+size)%size);
            d = Math.abs(left-q);
            cirDist = n-d;
            ans = Math.min(ans,Math.min(d,cirDist));

            res.add(ans);
        } 
        return res;
    }
}