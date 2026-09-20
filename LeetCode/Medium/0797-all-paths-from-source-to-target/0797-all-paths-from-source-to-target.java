class Solution {
    private void allPathSrc(int[][] graph, int src, int destination, List<Integer> path, List<List<Integer>> ans) {
        path.add(src);
        if(src == destination) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for(int i = 0; i<graph[src].length; i++) {
            int dest = graph[src][i];
            allPathSrc(graph, dest, destination, path, ans);
        }
        path.remove(path.size() - 1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        allPathSrc(graph, 0, graph.length - 1, path, ans);
        return ans;
    }
}