class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int n = s.length();
        int last = s.charAt(0)-'0';
        for(int i = 1;i<n;i++){
            char ch = s.charAt(i);
            int num = ch-'0';

            if(Math.abs(num-last) > 2){
                return false;
            }

            last = num;
        }
        return true;
    }
}