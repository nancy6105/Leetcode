class Solution {
    int dp[][][][][] = new int[301][7][7][7][7];
    public int minimumDistance(String word) {

        for(int i = 0;i<301;i++){
            for(int j = 0;j<7;j++){
                for(int k = 0;k<7;k++){
                    for(int l = 0;l<7;l++){
                        Arrays.fill(dp[i][j][k][l],-1);
                    }
                }
            }
        }
        return sol(word,0,-1,-1,-1,-1);
    }
    int[] getCordinate(char ch){
        int pos = ch-'A';
        return new int[]{pos/6, pos%6};
    }
    
    int getDist(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
    int sol(String s,int i,int x1,int y1,int x2,int y2){
        if(i == s.length()){
            return 0;
        }

        if(dp[i][x1+1][y1+1][x2+1][y2+1] != -1){
            return dp[i][x1+1][y1+1][x2+1][y2+1];
        }
        int cord[] = getCordinate(s.charAt(i));
        int x = cord[0];
        int y = cord[1];
        //f1 and f2 both not used
        if(x1 == -1 && y1 == -1 && x2 == -1 && y2 == -1){
            return dp[i][x1+1][y1+1][x2+1][y2+1] = sol(s,i+1,x,y,x2,y2);
        }

        //f1 used and f2 not
        if(x2 == -1 && y2 == -1){
            int move2 = 0 + sol(s,i+1,x1,y1,x,y);
            int move1 = sol(s,i+1,x,y,x2,y2) + getDist(x,y,x1,y1);

            return dp[i][x1+1][y1+1][x2+1][y2+1] = Math.min(move1,move2);
        }

        int move1 = sol(s,i+1,x,y,x2,y2) + getDist(x,y,x1,y1);
        int move2 = sol(s,i+1,x1,y1,x,y) + getDist(x,y,x2,y2);

        return dp[i][x1+1][y1+1][x2+1][y2+1] = Math.min(move1,move2);
    }
}