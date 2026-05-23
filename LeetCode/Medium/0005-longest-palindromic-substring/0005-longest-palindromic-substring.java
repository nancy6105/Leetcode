class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        int max = 0;
        int start = -1;
        int end = -1;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(sol(i,j,s)){
                    if(max < j-i+1){
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
    boolean checkPalindrome(String s){
        int i = 0;
        int n = s.length();
        int j = n-1;

        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    boolean sol(int i,int j,String s){
        if(i >= j){
            return true;
        }
        if(s.charAt(i) == s.charAt(j)){
            return sol(i+1, j-1, s);
        }
        else{
            return false;
        }
    }
}