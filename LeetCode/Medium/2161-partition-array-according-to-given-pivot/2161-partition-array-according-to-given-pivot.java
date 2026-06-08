class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for(int n : nums){
            if(n < pivot){
                less.add(n);
            }
            else if(n > pivot){
                greater.add(n);
            }
            else{
                equal.add(n);
            }
        }
        int res[] = new int[nums.length];
        int k = 0;

        for(int i = 0;i<less.size();i++){
            res[k++] = less.get(i);
        }

        for(int i = 0;i<equal.size();i++){
            res[k++] = equal.get(i);
        }

        for(int i = 0;i<greater.size();i++){
            res[k++] = greater.get(i);
        }

        return res;

    }
}