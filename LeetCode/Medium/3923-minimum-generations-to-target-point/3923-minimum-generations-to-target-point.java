class Solution {
    public int minGenerations(int[][] points, int[] target) {
        int n = points.length;

        Set<String> st = new HashSet<>();
        List<int[]> lst = new ArrayList<>();

        for (int p[] : points) {
            String str = p[0] + "," + p[1] + "," + p[2];
            st.add(str);
            lst.add(p);

            if (p[0] == target[0] && p[1] == target[1] && p[2] == target[2]) {
                return 0;
            }
        }
        int k = 0;
        while (st.size() > 0) {
            k++;
            List<int[]> newLst = new ArrayList<>();
            int size = lst.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int a[] = lst.get(i);
                    int b[] = lst.get(j);

                    if (a[0] == b[0] && a[1] == b[1] && a[2] == b[2]) {
                        continue;
                    }

                    int x = (a[0] + b[0]) / 2;
                    int y = (a[1] + b[1]) / 2;
                    int z = (a[2] + b[2]) / 2;

                    String str = x + "," + y + "," + z;

                    if (!st.contains(str)) {
                        st.add(str);
                        int arr[] = new int[] { x, y, z };
                        if (x == target[0] && y == target[1] && z == target[2]) {
                            return k;
                        }
                        newLst.add(arr);
                    }
                }
            }
            if(newLst.isEmpty()){
                return -1;
            }
            lst.addAll(newLst);
        }
        return -1;
    }
}