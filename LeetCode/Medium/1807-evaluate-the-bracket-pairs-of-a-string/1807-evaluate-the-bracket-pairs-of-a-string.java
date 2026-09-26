class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder output = new StringBuilder();

        HashMap<String, String>mp = new HashMap<>();
        
        for(List<String> val : knowledge){
            mp.put(val.get(0), val.get(1));
        }

        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                int j = i + 1;

                while(s.charAt(j) != ')'){
                    j++;
                }

                String key = s.substring(i+1, j);
                output.append(mp.getOrDefault(key, "?"));
                i = j;
            }

            else{
                output.append(s.charAt(i));
            }
        }

        return output.toString();
    }
}