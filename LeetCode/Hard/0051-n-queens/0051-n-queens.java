class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];

        for(char rows[] : board){
            Arrays.fill(rows,'.');
        }

        List<List<String>> res = new ArrayList<>();
        sol(0,n,res,board);
        return res;
    }
    void sol(int row,int n,List<List<String>>res,char[][]board){
        if(row == n){
            List<String>temp = new ArrayList<>();
            for(int i = 0;i<n;i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for(int col = 0;col<n;col++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                sol(row+1,n,res,board);
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

        while( r >= 0 && c >= 0){
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