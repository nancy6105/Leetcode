class Solution {
    public List<String> generateParenthesis(int n) {
        n = 2*n;
        List<String> res = new ArrayList<>();
        sol(n,0,0,"",res);
        return res;
    }

    void sol(int n,int ob,int cb,String curr,List<String>res){
        if(cb > ob){
            return;
        }
        if(ob > n/2){
            return;
        }
        if(ob+cb == n){
            res.add(curr);
            return;
        }

        sol(n,ob+1,cb,curr+"(",res);
        sol(n,ob,cb+1,curr+")",res);
    }
}