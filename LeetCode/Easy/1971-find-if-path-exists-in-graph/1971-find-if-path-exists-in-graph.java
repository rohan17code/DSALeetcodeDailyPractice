class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] vis = new boolean[n];
        return dfs(graph, source, destination, vis);
    }
    private boolean dfs(List<Integer>[] graph, int source, int destination, boolean[] vis) {
        if(source == destination) return true;
        vis[source] = true;
        for(int i = 0; i<graph[source].size(); i++) {
            int neigh = graph[source].get(i);
            if(!vis[neigh] && dfs(graph, neigh, destination, vis)) return true;
        }
        return false;
    }
}