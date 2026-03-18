class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int i = 0;
        int n = gas.length;
        int tank = 0;
        while(i < n){
            tank += gas[i]-cost[i];
            total += gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                start = i+1;
            }
            i++;
        }
        return total >= 0?start:-1;  
    }
}