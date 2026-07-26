class Solution {
    public int largestInteger(int n, int s) {

        int len = (int)(Math.pow(10,n))-1;

        for(int i = len; i>=0; i--){
            if(sol(i) == s){
                return i;
            }
        }

        return -1;
    }

    int sol(int x){
        int res = 0;
        while(x > 0){
            res += x%10;
            x = x/10;
        }
        return res;
    }
}