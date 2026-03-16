class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int max = 0;
        HashSet<Character> st = new HashSet<>();
        while(j < n){
            while(st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
            }
            st.add(s.charAt(j));
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}