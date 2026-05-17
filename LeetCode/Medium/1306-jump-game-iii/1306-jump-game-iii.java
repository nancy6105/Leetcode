class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean visi[] = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visi[start] = true;

        while(!q.isEmpty()){
            int i = q.poll();
            if(arr[i] == 0){
                return true;
            }
            int forw = i+arr[i];
            int back = i-arr[i];

            if(forw < n && !visi[forw]){
                q.offer(forw);
                visi[forw] = true;
            }

            if(back >= 0 && !visi[back]){
                q.offer(back);
                visi[back] = true;
            }
        }
        return false;
    }
}