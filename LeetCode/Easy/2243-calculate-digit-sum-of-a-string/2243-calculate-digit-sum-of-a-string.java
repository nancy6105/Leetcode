class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length() > k){
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < s.length(); i+=k){
                int num = 0;
                for(int j = i; j < Math.min(i + k, s.length()); j++){
                    num += s.charAt(j) - '0';
                }

                str.append(num);
            }

            s = str.toString();
        }

        return s;
    }
}