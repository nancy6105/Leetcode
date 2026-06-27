class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int len = 0;
        for(int num:map.keySet()){
            int key = num;
            int temp = 0;
            while(map.containsKey(key)){
                if(key==1){
                    if(map.get(key)%2==0){
                        temp = map.get(key)-1;
                    }else{
                        temp = map.get(key);
                    }
                    break;
                }
                int newKey = key*key;
                if(map.containsKey(newKey)){
                    if(map.get(key)>=2){
                        temp+=2;
                    }
                    else{
                        temp+=1;
                        break;
                    }
                }else{
                    temp+=1;
                }
                key = newKey;
            }
            len = Math.max(len,temp);
        }
        return len;
    }
}