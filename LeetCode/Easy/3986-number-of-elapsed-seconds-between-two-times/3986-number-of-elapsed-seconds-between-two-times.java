class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String start[] = startTime.split(":");
        String end[] = endTime.split(":");

        return sol(end) - sol(start);
    }

    int sol(String [] arr){
        int cnt = 0;

        cnt += (Integer.parseInt(arr[0]) * 3600);
        cnt += (Integer.parseInt(arr[1]) * 60);
        cnt += (Integer.parseInt(arr[2]));

        return cnt;
    }
}