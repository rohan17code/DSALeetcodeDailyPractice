class Solution {
    static class Edge {
        int src;
        int dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    
    private static int dfs(ArrayList<Edge>[] graph) {
        int components = 0;
        boolean[] vis = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++) {
            if(!vis[i]) {
                components++;
                dfsUtil(graph, i, vis);
                
            }
        }
        return components;
    }
    private static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        for(int i = 0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) {
            return -1;
        }
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }
        int components = dfs(graph);
        return components - 1;
    }
}