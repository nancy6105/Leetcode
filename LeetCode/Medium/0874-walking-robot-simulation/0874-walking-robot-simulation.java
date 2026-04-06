class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> st = new HashSet<>();
        for(int i = 0;i<obstacles.length;i++){
            st.add(obstacles[i][0] + "_" + obstacles[i][1]);
        }
        int x = 0;
        int y = 0;
        int max = 0;

        int dir[] = {0,1};
        for(int i = 0;i<commands.length;i++){
            if(commands[i] == -2){
                dir = new int[]{-dir[1],dir[0]};
            }
            else if(commands[i] == -1){
                dir = new int[]{dir[1],-dir[0]};
            }
            else{
                for(int step = 0;step < commands[i];step++){
                    int newx = x + dir[0];
                    int newy = y + dir[1];


                    String newKey = newx +"_"+ newy;
                    if(st.contains(newKey)){
                        break;
                    }

                    x = newx;
                    y = newy;
                }
            }
            max = Math.max(max,x*x + y*y);
        }
        return max;
    }
}   