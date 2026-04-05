class Solution {
    public boolean judgeCircle(String moves) {
        int cnt1 = 0, cnt2 = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'U'){
                cnt1++;
            }
            else if(ch == 'D'){
                cnt1--;
            }
            else if(ch == 'L'){
                cnt2++;
            }
            else if(ch == 'R'){
                cnt2--;
            }
        }

        return cnt1 == 0 && cnt2 == 0;
    }
}