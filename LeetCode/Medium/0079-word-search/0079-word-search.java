class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int idx = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0; j< m;j++){
                if(board[i][j] == word.charAt(idx)){
                    if(sol(idx,i,j,board,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean sol(int idx,int i,int j,char[][]board,String s){
        if(idx == s.length()){
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        if(i < 0 || j < 0 || i == n || j == m || board[i][j] == '*' || s.charAt(idx) != board[i][j]){
            return false;
        }
        char c = board[i][j];
        board[i][j] = '*';
        boolean top = sol(idx+1,i-1,j,board,s);
        boolean down = sol(idx+1,i+1,j,board,s);
        boolean right = sol(idx+1,i,j+1,board,s);
        boolean left =  sol(idx+1,i,j-1,board,s);

        board[i][j] = c;
        return top || down || right || left;
    }
}