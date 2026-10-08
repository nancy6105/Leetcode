class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int bal = 0;
        String res = "";

        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(bal > 0){
                    res+=ch;
                }
                bal++;
            }
            else if(ch == ')'){
                bal--;
                if(bal > 0){
                    res+=ch;
                }
            }
        }
        return res;
    }
}