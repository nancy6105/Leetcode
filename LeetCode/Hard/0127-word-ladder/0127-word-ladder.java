class Solution {
    class Pair{
        String str;
        int n;
        public Pair(String str,int n){
            this.str = str;
            this.n = n;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>st = new HashSet<>();

        for(int i = 0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }

        Queue<Pair>q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.str;
            int ans = p.n;
            if(s.equals(endWord))return ans;
            int len = s.length();

            for(int i = 0;i<len;i++){
                for(char ch = 'a';ch <= 'z';ch++){
                    char charArray[] = s.toCharArray();
                    charArray[i] = ch;
                    String newWord = new String(charArray);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.offer(new Pair(newWord,ans+1));
                    }
                }
            }
        }
        return 0;
    }
}