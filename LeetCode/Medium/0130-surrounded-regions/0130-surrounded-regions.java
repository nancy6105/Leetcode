class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean visited[][] = new boolean[n][m];
        for(int i = 0;i<m;i++){
            if(board[0][i] == 'O' && !visited[0][i]){
                dfs(board,0,i,visited);
            }
        }

        for(int i = 1;i<n-1;i++){
            if(board[i][m-1] == 'O' && !visited[i][m-1]){
                dfs(board,i,m-1,visited);
            }
        }

        for(int i = m-1;i>=0;i--){
            if(board[n-1][i] == 'O' && !visited[n-1][i]){
                dfs(board,n-1,i,visited);
            }
        }

        for(int i = n-2;i>0;i--){
            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(board,i,0,visited);
            }
        }


        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(char[][] b,int i,int j,boolean visited[][]){
        int n = b.length;
        int m = b[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m || b[i][j] == 'X' || visited[i][j])return;

        visited[i][j] = true;
        dfs(b,i-1,j,visited);
        dfs(b,i+1,j,visited);
        dfs(b,i,j-1,visited);
        dfs(b,i,j+1,visited);
    }
}