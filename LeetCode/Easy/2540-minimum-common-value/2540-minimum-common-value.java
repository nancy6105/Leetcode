class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer>st = new HashSet<>();
        for(int num : nums1){
            st.add(num);
        }

        for(int num : nums2){
            if(st.contains(num)){
                return num;
            }
        }
        return -1;
    }
}