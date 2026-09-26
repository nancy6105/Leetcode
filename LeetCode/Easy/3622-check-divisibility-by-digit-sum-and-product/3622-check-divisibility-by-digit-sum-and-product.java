class Solution {
    public boolean checkDivisibility(int n) {
        int prod = 1;
        int sum = 0;

        int temp = n;
        while(temp != 0){
            int rem = temp%10;
            sum += rem;
            prod *= rem;
            temp = temp/10;
        }

        return n%(sum + prod) == 0;
    }
}