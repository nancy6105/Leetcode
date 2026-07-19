class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxlen = 1;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(check(i,j,s)){
                    if(j-i+1 > maxlen){
                        maxlen = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start+maxlen);
    }
    boolean check(int i,int j,String str){
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}