class Solution {
    public String smallestPalindrome(String s) {
        if(s.length() == 1)return s;
        
        int []freq = new int[26];
        
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        char mid = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<26;i++){
            for (int j = 0; j < freq[i] / 2; j++) {
                sb.append((char)(i + 'a'));
            }

            if(freq[i]%2 != 0){
                mid = (char)(i+'a');
            }
        }
        
        StringBuilder rev = new StringBuilder(sb).reverse();
        if(mid != 0){
            return sb.toString() + mid + rev.toString();
        }
        return sb.toString() + rev.toString();
    }
}