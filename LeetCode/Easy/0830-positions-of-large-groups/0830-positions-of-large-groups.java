class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> arr = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while(i<n){
            char ch = s.charAt(i);
            int j = i+1;
            while(j < n && ch == s.charAt(j)){
                j++;
            }
            if(j-i >= 3){
                arr.add(Arrays.asList(i,j-1));
            }
            i = j;
        }
        return arr;
    }
}