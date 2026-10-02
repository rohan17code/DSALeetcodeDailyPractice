class Solution {
    static int[] par;
    static int[] rank;
    private static void init(int n) {
        for(int i = 0; i<=n; i++) {
            par[i] = i;
        }
    }
    private static int find(int x) {
        if(x == par[x]) return x;
        return par[x] = find(par[x]);
    }
    private static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else par[parB] = parA;
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        par = new int[n + 1];
        rank = new int[n + 1];
        int components = n;
        init(n);
        for(int i = 0; i<connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            if(find(a) != find(b)) {
                union(a,b);
                components--;
            }
        }
        return components - 1;
    }
}