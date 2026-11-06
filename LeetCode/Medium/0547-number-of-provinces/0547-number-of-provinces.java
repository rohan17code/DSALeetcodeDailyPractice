class Solution {
    private void dfs(int[][] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        for(int i = 0; i < graph.length; i++) {
            if(graph[curr][i] == 1 && !vis[i]) {
                dfs(graph, i, vis);
            }
        }
    }
    int cnt = 0;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(!vis[i]) {
                dfs(isConnected, i, vis);
                cnt++;
            }
        }
        return cnt;
    }
}