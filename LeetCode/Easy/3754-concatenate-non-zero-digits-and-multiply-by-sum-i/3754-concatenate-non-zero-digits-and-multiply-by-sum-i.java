class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0, mul = 0;

        for(char ch : String.valueOf(n).toCharArray()){
            if(ch != '0'){
                ans = ans * 10 + ch -'0';
                mul += ch-'0';
            }
        }
        return ans * mul;
    }
}