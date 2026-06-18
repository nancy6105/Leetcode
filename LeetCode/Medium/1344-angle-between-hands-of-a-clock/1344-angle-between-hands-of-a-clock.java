class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteDegree = minutes*6;
        double hoursDegree = 30 * (hour % 12) + 0.5 * minutes;
        double ans = Math.abs(minuteDegree - hoursDegree);
        return Math.min(ans,360-ans);
    }
}