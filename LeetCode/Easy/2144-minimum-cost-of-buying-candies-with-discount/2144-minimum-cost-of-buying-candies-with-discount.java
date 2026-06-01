class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int n = cost.length;
        int total = 0;
        int cnt = 0;

        for(int i = n-1;i>=0;i--){
            if(cnt < 2){
                total += cost[i];
                cnt++;
            }

            else{
                cnt = 0;
            }
        }
        return total;
    }
}