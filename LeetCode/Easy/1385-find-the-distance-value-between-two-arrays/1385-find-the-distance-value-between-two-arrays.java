class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;

        for(int num : arr1){
            boolean flag = true;
            for(int num2 : arr2){
                if(Math.abs(num - num2) <= d){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }

        return ans;
    }
}