class Solution {
    Stack<Integer> topoStack = new Stack<>();
    private boolean isCycle(ArrayList<Integer>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i = 0; i<graph[curr].size(); i++) {
            int dest = graph[curr].get(i);
            if(stack[dest]) {
                return true;
            }
            if(!vis[dest] && isCycle(graph, dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    private void topSort(ArrayList<Integer>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        for(int i = 0; i<graph[curr].size(); i++) {
            int dest = graph[curr].get(i);
            if(!vis[dest]) {
                topSort(graph, dest, vis);
            }
        }
        topoStack.push(curr);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            graph[src].add(dest);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for(int i = 0; i<numCourses; i++) {
            if(!vis[i]) {
                if(isCycle(graph, i, vis, stack)) {
                    return new int[0];
                }
            }
        }
        vis = new boolean[numCourses];
        for(int i = 0; i<numCourses; i++) {
            if(!vis[i]) {
                topSort(graph, i, vis);
            }
        }
        int[] ans = new int[numCourses];
        for(int i = 0; i<numCourses; i++) {
            ans[i] = topoStack.pop();
        }
        return ans;
    }
}