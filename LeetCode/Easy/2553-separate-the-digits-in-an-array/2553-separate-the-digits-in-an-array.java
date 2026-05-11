class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int n : nums){
            int x = n;
            ArrayList<Integer> temp = new ArrayList<>();
            while(x > 0){
                temp.add(x%10);
                x = x/10;
            }
            Collections.reverse(temp);
            for(int i = 0;i<temp.size();i++){
                res.add(temp.get(i));
            }
        }

        int ans[] = new int[res.size()];

        for(int i = 0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}