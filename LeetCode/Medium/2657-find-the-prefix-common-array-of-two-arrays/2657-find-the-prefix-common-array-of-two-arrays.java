class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        for(int i = 0; i<n; i++){
            int cur = 0;
            for(int a = 0; a <= i; a++){
                for(int b = 0; b <= i; b++){
                    if(A[a] == B[b]){
                        cur++;
                    }
                }
            }
            ans[i] = cur;
        }
        return ans;
    }
}