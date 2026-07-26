class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(n > 0){
            arr.add(n%10);
            n = n/10;
        }

        Collections.sort(arr);
        int m = arr.size();
        return arr.get(m-1) * arr.get(m-2);
    }
}