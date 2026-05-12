class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;

        Arrays.sort(tasks,(task1, task2) -> {
            int diff1 = task1[1]-task1[0];
            int diff2 = task2[1]-task2[0];

            return diff2 - diff1;
        });

        int l = 0;
        int r = (int)1e9;

        int res = Integer.MAX_VALUE;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(isPossible(tasks, mid)){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return res;
    }

    boolean isPossible(int [][]tasks, int mid){
        for(int task[] : tasks){
            int acc = task[0];
            int min = task[1];

            if(min > mid){
                return false;
            }

            mid = mid-acc;
        }

        return true;
    }
}