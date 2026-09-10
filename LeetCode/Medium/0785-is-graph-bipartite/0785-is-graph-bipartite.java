class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i<graph.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<graph.length; i++) {
            if(color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()) {
                    int curr = q.poll();
                for(int j = 0; j<graph[curr].length; j++) {
                    int dest = graph[curr][j];
                    if(color[dest] == -1) {
                        int nxtColor = color[curr] == 0 ? 1 : 0;
                        color[dest] = nxtColor;
                        q.add(dest);
                    } else if(color[dest] == color[curr]) {
                        return false;
                    }
                }
            }
        }
        }
        return true;
    }
}