class Solution {
    public String[] createGrid(int n, int m) {

        String ans[] = new String[n];
        int k = 0;
        for(int i = 0; i < n; i++){
            String s = "";
            for(int j = 0; j < m; j++){
                if(i == 0 || j == m - 1){
                    s += '.';
                }
                else{
                    s += '#';
                }
            }
            ans[k++] = s;
            s = "";
        }
        return ans;
    }
}