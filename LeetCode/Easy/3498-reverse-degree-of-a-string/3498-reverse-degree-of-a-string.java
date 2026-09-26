class Solution {
    public int reverseDegree(String s) {
        int output = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        int j = 26;
        for(char ch = 'a'; ch <= 'z'; ch++){
            mp.put(ch, j--);
        }
        
        int i = 1;
        for(char ch : s.toCharArray()){
            output += (mp.get(ch) * i++);
        }

        return output;
    }
}