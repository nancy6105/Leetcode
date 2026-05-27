class Solution {
    int n; 
    int m;

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        
        for(int j = 0;j<m;j++){
            if(board[0][j] == 'O'){
                dfs(0,j,board);
            }
            if(board[n-1][j] == 'O'){
                dfs(n-1,j,board);
            }
        }

        for(int i = 1;i<n-1;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board);
            }
            if(board[i][m-1] == 'O'){
                dfs(i,m-1,board);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    void dfs(int i,int j,char board[][]){
        if(i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O'){
            return;
        }

        board[i][j] = '#';
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j-1,board);
        dfs(i,j+1,board);
    }
}