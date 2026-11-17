class Solution {
    public int titleToNumber(String columnTitle) {
        int num = 0;
        int n = columnTitle.length()-1;


        for(char s : columnTitle.toCharArray()){
            num += (s - 'A' + 1) * (int) Math.pow(26, n--);
        }

        return num;
    }
}