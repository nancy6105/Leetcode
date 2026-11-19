class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String arr[] = s.split(" ");

        if(pattern.length() != arr.length)return false;
        
        Set<String>st = new HashSet<>();
        HashMap<Character, String> mp = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            String w = arr[i];

            if(mp.containsKey(ch)){
                if(!mp.get(ch).equals(w)){
                    return false;
                }
            }
            else{
                if(st.contains(w)){
                    return false;
                }
                mp.put(ch, w);
                st.add(w);
            }

        }
        return true;
    }
}