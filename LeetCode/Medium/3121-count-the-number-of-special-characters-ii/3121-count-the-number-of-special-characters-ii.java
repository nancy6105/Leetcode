class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        int lastLow[] = new int[26];
        int firstUp[] = new int[26];

        Arrays.fill(lastLow,-1);
        Arrays.fill(firstUp,-1);

        for(int i = 0;i<n;i++){

            if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z'){
                lastLow[word.charAt(i) - 'a'] = i;
            }

            else{
                if(firstUp[word.charAt(i) - 'A'] == -1){
                    firstUp[word.charAt(i) - 'A'] = i;
                }
            }
        }

        int cnt = 0;
        for(int i = 0;i<26;i++){
            if(lastLow[i] != -1 && firstUp[i] != -1 && lastLow[i] < firstUp[i]){
                cnt++;
            }
        }
        return cnt;
    }
}