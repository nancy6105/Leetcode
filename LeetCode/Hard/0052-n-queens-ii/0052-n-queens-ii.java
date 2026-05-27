class Solution {
    int cnt = 0;
    public int totalNQueens(int n) {
        char [][]board = new char[n][n];
        
        for(char rows[] : board){
            Arrays.fill(rows,'.');
        }

        sol(0,board,n);
        return cnt;
    }

    void sol(int row, char [][] board,int n){
        if(row == n){
            cnt++;
            return;
        }

        for(int col = 0;col < n;col++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                sol(row + 1,board,n);
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(char[][] board,int row,int col){

        for(int i = 0;i<row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        int r = row;
        int c = col;

        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;
        int n = board.length;
        while(r >= 0 && c < n){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }
}