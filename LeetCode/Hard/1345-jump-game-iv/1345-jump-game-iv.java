class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if(n == 1){
            return 0;
        }
        HashMap<Integer,List<Integer>> mp = new HashMap<>();


        for(int i = 0;i<n;i++){
            mp.putIfAbsent(arr[i],new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        boolean visi[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visi[0] = true;
        int step = 0;


        while(!q.isEmpty()){
            int size = q.size();

            while(size--> 0){
                int idx = q.poll();
                if(idx == n-1){
                    return step;
                }

                int left = idx-1;
                int right = idx+1;

                if(left >= 0 && !visi[left]){
                    q.offer(left);
                    visi[left] = true;
                }

                if(right < n && !visi[right]){
                    q.offer(right);
                    visi[right] = true;
                }

                if(mp.containsKey(arr[idx])){
                    for(int i : mp.get(arr[idx])){
                    if(!visi[i]){
                        q.offer(i);
                        visi[i] = true;
                    }
                }

                mp.remove(arr[idx]);
                }
            }

            step++;
        }

        return -1;
    }
}