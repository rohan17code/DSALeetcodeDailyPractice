class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                dfs(isConnected, i, visited);
                cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int[][] graph, int curr, boolean[] visited) {
        visited[curr] = true;
        for(int i = 0; i<graph.length; i++) {
            if(graph[curr][i] == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }
}