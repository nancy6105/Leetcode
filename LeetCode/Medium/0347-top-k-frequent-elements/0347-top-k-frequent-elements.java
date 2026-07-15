class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());


        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            pq.offer(entry);
        }

        int ans[] = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}