class Solution {
    public String sortVowels(String s) {
        int[] freq = new int[26];
        int[] idx = new int[26];
        Arrays.fill(idx,-1);

        int n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                int val = ch-'a';
                freq[val]++;
                if(idx[val] == -1){
                    idx[val] = i;
                }
            }
        }

        List<Character> vow = new ArrayList<>();
        for(char ch : "aeiou".toCharArray()){
            if(freq[ch-'a'] != 0){
                vow.add(ch);
            }
        }

        vow.sort((a,b) -> {
            if(freq[a-'a'] != freq[b-'a']){
                return freq[b-'a'] - freq[a-'a'];
            }
            else{
                return idx[a-'a']-idx[b-'a'];
            }
        });

        List<Character> sort = new ArrayList<>();
        for(char ch : vow){
            int cnt = freq[ch-'a'];
            while(cnt > 0){
                sort.add(ch);
                cnt--;
            }
        } 

        StringBuilder sb = new StringBuilder(s);
        int j = 0;

        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                sb.setCharAt(i,sort.get(j++));
            }
        }

        return sb.toString();
    }
    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}