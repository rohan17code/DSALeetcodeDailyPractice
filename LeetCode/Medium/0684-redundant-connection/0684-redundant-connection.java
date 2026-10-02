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
        } else {
            par[parB] = par[parA];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];
        rank = new int[n + 1];
        init(n);
        for(int i = 0; i<n; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if(find(a) == find(b)) return new int[]{a,b};
            else union(a,b);
        }
        return new int[]{};
    }
}