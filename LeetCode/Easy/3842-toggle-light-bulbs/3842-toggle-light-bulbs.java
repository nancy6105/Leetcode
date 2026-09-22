class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> ans = new ArrayList<>();

        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int bulb : bulbs){
            mp.put(bulb, mp.getOrDefault(bulb, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() % 2 != 0){
                ans.add(entry.getKey());
            }
        }
        Collections.sort(ans);
        return ans;
    }
}