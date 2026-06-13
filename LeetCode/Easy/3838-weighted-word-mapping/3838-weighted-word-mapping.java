class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        StringBuilder res = new StringBuilder();
        for(String s : words){
            int len = s.length();
            int sum = 0;
            for(int i = 0;i<len;i++){
                char ch = s.charAt(i);
                sum += weights[ch - 'a'];
            }
            int mod = sum%26;
            char ch = (char)('z' - mod);
            res.append(ch);
        }
        return res.toString();
    }
}