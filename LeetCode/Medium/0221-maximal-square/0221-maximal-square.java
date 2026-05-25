class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int next[] = new int[m + 1];

        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            int curr[] = new int[m + 1];

            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    int right = curr[j + 1];
                    int down = next[j];
                    int diagonal = next[j + 1];

                    int ans = 1 + Math.min(right, Math.min(down, diagonal));
                    curr[j] = ans;
                    max = Math.max(ans, max);
                }
            }
            next = curr;
        }
        return max * max;
    }
}