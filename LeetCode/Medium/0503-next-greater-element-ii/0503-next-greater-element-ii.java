class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int []ans = new int[nums.length];

        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,-1);
        int n = nums.length;
        for(int i = (2*n-1); i >= 0; i--){
            int idx = i%n;
            int curr = nums[idx];

            while(!st.isEmpty() && st.peek() <= curr){
                st.pop();
            }

            if(i < n){
                if(!st.isEmpty()){
                    ans[i] = st.peek();
                }
            }
            st.push(curr);
        }

        return ans;
    }
}