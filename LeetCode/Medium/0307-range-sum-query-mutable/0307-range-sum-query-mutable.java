class NumArray {
    int tree[];
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4*n];
        build(nums,0,0,n-1);
    }
    
    private void build(int a[],int idx,int l,int r){
        if(l == r){
            tree[idx] = a[l];
            return;
        }
        int mid = (l+r)/2;
        build(a,2*idx+1,l,mid);
        build(a,2*idx+2,mid+1,r);
        tree[idx] = tree[2*idx+1]+tree[2*idx+2];
    }
    public void update(int index, int val) {
        updateHelper(0,index,val,0,n-1);
    }
    private void updateHelper(int idx,int i,int val,int l,int r){
        if(l == r){
            tree[idx] = val;
            return;
        }
        int mid = (l+r)/2;
        if(i<=mid){
            updateHelper(2*idx+1,i,val,l,mid);
        }
        else{
            updateHelper(2*idx+2,i,val,mid+1,r);
        }
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
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
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */