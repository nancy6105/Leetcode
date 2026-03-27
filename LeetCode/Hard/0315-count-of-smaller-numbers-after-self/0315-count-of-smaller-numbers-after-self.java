class Solution {
    int tree[];
    int size;
    public List<Integer> countSmaller(int[] nums) {
        int sorted[] = nums.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> mp = new HashMap<>();
        int rank = 1;
        for(int i : sorted){
            if(!mp.containsKey(i)){
                mp.put(i,rank++);
            }
        }

        int n = nums.length;
        size = rank;
        tree = new int[4*size];
        List<Integer> res = new ArrayList<>();
        for(int i = n-1;i>=0;i--){
            int r = mp.get(nums[i]);
            int cnt = query(0,1,size,1,r-1);
            res.add(cnt);

            update(0,1,size,r);
        }
        Collections.reverse(res);
        return res;
    }
    private int query(int idx,int l,int r,int ql,int qr){
        if(qr < l || r < ql){
            return 0;
        }
        if(ql <= l && r <= qr){
            return tree[idx];
        }
        int mid = (l+r)/2;
        int left = query(2*idx+1,l,mid,ql,qr);
        int right = query(2*idx+2,mid+1,r,ql,qr);
        return left+right;
    }

    private void update(int idx,int l,int r,int pos){
        if(l == r){
            tree[idx] += 1;
            return;
        }
        int mid = (l+r)/2;
        if(pos <= mid){
            update(2*idx+1,l,mid,pos);
        }
        else{
            update(2*idx+2,mid+1,r,pos);
        }
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }
}