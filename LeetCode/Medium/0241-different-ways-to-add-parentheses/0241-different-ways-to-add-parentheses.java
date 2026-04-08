class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return sol(expression);
    }
    List<Integer> sol(String s){
        List<Integer> res = new ArrayList<>();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*'){
                List<Integer> leftRes = sol(s.substring(0,i));
                List<Integer> rightRes = sol(s.substring(i+1));

                for(int x : leftRes){
                    for(int y : rightRes){
                        if(ch == '+'){
                            res.add(x + y);
                        }
                        else if(ch == '-'){
                            res.add(x-y);
                        }
                        else{
                            res.add(x*y);
                        }
                    }
                }
            }
        }

        if(res.isEmpty()){
            res.add(Integer.parseInt(s));
        }
        return res;
    }
}