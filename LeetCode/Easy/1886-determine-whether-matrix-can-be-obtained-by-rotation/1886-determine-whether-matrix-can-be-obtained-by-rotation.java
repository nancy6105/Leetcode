class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;

        for (int k = 0; k < 4; k++) {
            boolean flag = true;

            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(mat[i][j] != target[i][j]){
                        flag = false;
                        break;
                    }
                }

                if(!flag)break;
            }
            if(flag)return true;

            for (int i = 0; i < n; i++) {
                for (int j = i; j < m; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }

            for (int i = 0; i < n; i++) {
                reverse(mat[i]);
            }
        }

        return false;
    }


    void reverse(int mat[]){
        int i = 0;
        int j = mat.length-1;

        while(i < j){
            int temp = mat[i];
            mat[i] = mat[j];
            mat[j] = temp;
            i++;
            j--;
        }
    }
}