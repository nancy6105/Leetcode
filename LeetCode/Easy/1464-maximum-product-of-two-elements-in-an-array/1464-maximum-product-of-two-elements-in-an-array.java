class Solution {
    public int maxProduct(int[] nums) {
        int first = 0;
        int sec = 0;
        int max = 0;
        for(int num  : nums){
            if(num > first){
                sec = first;
                first = num;
            }
            else if(num > sec){
                sec = num;
            }
        }
        return (first - 1) * (sec - 1);
    }
}