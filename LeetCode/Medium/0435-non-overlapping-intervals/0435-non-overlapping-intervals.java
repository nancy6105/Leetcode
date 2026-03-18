class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> (a[1]-b[1]));

        int prevEnd = intervals[0][1];
        int n = intervals.length;
        int cnt = 0;
        for(int i =1;i<n;i++){
            int start = intervals[i][0];
            if(start < prevEnd){
                cnt++;
            }
            else{
                prevEnd = intervals[i][1];
            }
        }
        return cnt;
    }
}