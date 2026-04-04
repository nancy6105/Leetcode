class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols = len/rows;

        StringBuilder ans = new StringBuilder();
        for(int col = 0; col<cols; col++){
            for(int j = col; j<len; j += (cols+1)){
                ans.append(encodedText.charAt(j));
            }
        }
        return ans.toString().stripTrailing();
    }
}