class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ans[] = new int[nums.length];
        Arrays.fill(ans,-1);
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = (2*n - 1); i >= 0; i--){
            int idx =  i%n;
            int curr = nums[idx];
            while(!st.empty() && st.peek() <= curr){
                st.pop();
            }
            if(i < n){
                if(!st.empty()){
                    ans[i] = st.peek();
                }
            }
            st.push(curr);
        }
        return ans;
    }
}