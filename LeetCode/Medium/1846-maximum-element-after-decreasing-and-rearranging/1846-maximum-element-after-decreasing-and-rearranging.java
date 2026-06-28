class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] >= prev+1){
                prev++;
            }
        }
        return prev;
    }
}