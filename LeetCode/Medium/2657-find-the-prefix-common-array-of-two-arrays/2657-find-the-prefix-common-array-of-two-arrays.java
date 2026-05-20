class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        Set<Integer> stA = new HashSet<>();
        Set<Integer> stB = new HashSet<>();
        for(int i = 0;i<n;i++){
            stA.add(A[i]);
            stB.add(B[i]);

            int cur = 0;
            for(int eleA : stA){
                if(stB.contains(eleA)){
                    cur++;
                }
            }

            ans[i] = cur;
        }
        return ans;
    }
}