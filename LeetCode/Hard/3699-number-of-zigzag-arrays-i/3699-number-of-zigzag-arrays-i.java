class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2
        for (int x = 0; x < m; x++) {
            up[x] = x;               // count of values smaller than x
            down[x] = m - 1 - x;     // count of values greater than x
        }

        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            // Prefix sums of down
            long[] pref = new long[m];
            pref[0] = down[0];
            for (int i = 1; i < m; i++) {
                pref[i] = (pref[i - 1] + down[i]) % MOD;
            }

            // Suffix sums of up
            long[] suff = new long[m];
            suff[m - 1] = up[m - 1];
            for (int i = m - 2; i >= 0; i--) {
                suff[i] = (suff[i + 1] + up[i]) % MOD;
            }

            for (int x = 0; x < m; x++) {

                // up[len][x] = sum(down[len-1][y]) for y < x
                if (x > 0)
                    newUp[x] = pref[x - 1];

                // down[len][x] = sum(up[len-1][y]) for y > x
                if (x < m - 1)
                    newDown[x] = suff[x + 1];
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        if (n == 2) {
            for (int i = 0; i < m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
        } else {
            for (int i = 0; i < m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
        }

        return (int) ans;
    }
}