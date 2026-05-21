class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> st = new HashSet<>();

        for (int val : arr1) {
            while (!st.contains(val) && val > 0) {
                st.add(val);
                val /= 10;
            }
        }

        int len = 0;

        for (int val : arr2) {
            while (!st.contains(val) && val > 0) {
                val /= 10;
            }

            if (val > 0) {
                len = Math.max(len, (int) Math.log10(val) + 1);
            }
        }

        return len;
    }
}