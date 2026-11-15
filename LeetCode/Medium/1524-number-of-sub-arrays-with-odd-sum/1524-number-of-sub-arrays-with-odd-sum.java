
class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;

        long even = 1;
        long odd = 0;
        long count = 0;

        int parity = 0;

        for (int num : arr) {
            parity = (parity + num % 2 + 2) % 2;

            if (parity == 1) {
                count = (count + even) % mod;
                odd++;
            } else {
                count = (count + odd) % mod;
                even++;
            }
        }

        return (int) count;
    }
}

