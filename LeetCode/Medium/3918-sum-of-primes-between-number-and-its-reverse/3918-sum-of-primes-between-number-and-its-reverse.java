class Solution {
    public int sumOfPrimesInRange(int n) {
        int org = n;
        int rev = 0;
        while(n > 0){
            int rem = n%10;
            rev = rev*10+rem;
            n = n/10;
        }

        int start = Math.min(org,rev);
        int end = Math.max(org,rev);
        int sum = 0;
        for(int i = start;i<=end;i++){
            if(isPrime(i)){
                sum += i;
            }
        }

        return sum;
    }

    boolean isPrime(int n){

        if(n < 2){
            return false;
        }
        for(int i = 2;i<n;i++){
            if(n%i == 0){
                return false;
            }
        }

        return true;
    }
}