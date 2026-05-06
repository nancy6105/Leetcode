class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        char[][] res = new char[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][n - 1 - i] = boxGrid[i][j];
            }
        }

        for(int j = 0;j<n;j++){
            for(int i = m-1;i>=0;i--){
                if(res[i][j] == '.'){
                    int next = -1;

                    for(int k = i-1;k>=0;k--){
                        if(res[k][j] == '*')break;
                        if(res[k][j] == '#'){
                            next = k;
                            break;
                        }
                    }
                    if(next != -1){
                        res[next][j] = '.';
                        res[i][j] = '#';
                    }
                }
            }
        }
        return res;
    }

    void reverse(char[] arr){
        int i = 0;
        int j = arr.length-1;

        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}