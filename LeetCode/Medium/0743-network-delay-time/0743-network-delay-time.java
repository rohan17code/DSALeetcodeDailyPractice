class Solution {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        }
        static class Pair implements Comparable<Pair> {
            int m;
            int path;
            public Pair(int m, int p) {
                this.m = m;
                this.path = p;
            }
            @Override
            public int compareTo(Pair p2) {
                return this.path - p2.path;
            }
        }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for(int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            graph[u].add(new Edge(u, v, wt));
        }
        int[] dist = new int[n + 1];
        for(int i = 1; i<=n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        boolean[] vis = new boolean[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[k] = 0;
        pq.offer(new Pair(k, 0));
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            if(!vis[curr.m]) {
                vis[curr.m] = true;
                for(int i = 0; i<graph[curr.m].size(); i++) {
                    Edge e = graph[curr.m].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.offer(new Pair(v, dist[v]));
                    }
                }
            }
        }
        int max = 0;
        for(int i = 1; i<=n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                return - 1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}