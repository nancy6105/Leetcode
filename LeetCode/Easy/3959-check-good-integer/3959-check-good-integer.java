class Solution {
    public boolean checkGoodInteger(int n) {
        int sum = 0;
        int sqr = 0;

        while(n != 0){
            int rem = n%10;
            sum += rem;
            sqr = sqr + (rem*rem);
            n = n/10;
        }

       if(sqr - sum >= 50){
        return true;
       }
       return false;
    }
}