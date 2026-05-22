class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int nextRow[] = new int[n];
        for(int j = 0; j < n; j++){
            nextRow[j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--){
            int currRow[] = new int[n];

            for(int j = 0; j <= i; j++){

                int down = triangle.get(i).get(j) + nextRow[j];
                int diagonal = triangle.get(i).get(j) + nextRow[j+1];

                currRow[j] = Math.min(down,diagonal);
            }
            nextRow = currRow;
        }

        return nextRow[0];
    }
}