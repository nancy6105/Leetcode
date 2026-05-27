class Solution {
    public List<String> generateParenthesis(int n) {
        n = 2*n;
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        sol(n,0,0,curr,res);
        return res;
    }

    void sol(int n,int ob,int cb,StringBuilder curr,List<String>res){
        if(ob+cb == n){
            res.add(curr.toString());
            return;
        }

        if(ob < n/2){
            curr.append('(');
            sol(n,ob+1,cb,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }

        if(cb < ob){
            curr.append(')');
            sol(n,ob,cb+1,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}