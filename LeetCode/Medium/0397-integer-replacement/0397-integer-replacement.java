import java.util.*;

class Solution {
    Map<Long, Integer> memo = new HashMap<>();

    public int integerReplacement(int n) {
        return sol((long)n);
    }

    int sol(long n) {
        // ✅ Base case
        if (n == 1) return 0;

        // ✅ Already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int ans;

        if (n % 2 == 0) {
            ans = 1 + sol(n / 2);
        } else {
            ans = 1 + Math.min(
                sol(n - 1),
                sol(n + 1)
            );
        }

        // ✅ Store result
        memo.put(n, ans);

        return ans;
    }
}