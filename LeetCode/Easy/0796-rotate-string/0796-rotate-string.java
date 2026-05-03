class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length()!=goal.length()){
            return false;
        }
        String text = s+s;
        return text.contains(goal);
    }
}