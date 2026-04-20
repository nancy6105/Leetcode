class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int l1 = 0;
        int r1 = n-1;

        int l2 = 0;
        int r2 = n-1;
        int max = 0;
        while(l1 < r1){
            if(colors[l1] != colors[r1]){
                max = Math.max(max,r1-l1);
                break;
            }
            else{
                l1++;
            }
        }

        while(l2 < r2){
            if(colors[l2] != colors[r2]){
                max = Math.max(max,r2-l2);
                break;
            }
            else{
                r2--;
            }
        }
        return max;
    }
}