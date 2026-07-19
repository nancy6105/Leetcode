class Solution {
    int n;
    int m;

    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        int next[] = new int[m+1];
        for(int j = 0;j<=m;j++){
            next[j] = m-j;
        }

        for(int i = n-1; i >= 0; i--){
            int curr[] = new int[m+1];
            curr[m] = n-i;
            for(int j = m-1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    curr[j] = next[j+1];
                }
                else{
                    int replace = next[j+1];
                    int del = next[j];
                    int inst = curr[j+1];

                    curr[j] = 1 + Math.min(replace,Math.min(inst,del));
                }
            }
            next = curr;
        }
        return next[0];    
    }
}