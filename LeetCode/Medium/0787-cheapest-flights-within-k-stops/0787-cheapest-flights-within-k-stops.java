class Solution {
    static class Edge {
        int dest;
        int wt;
        public Edge(int d, int w) {
            this.dest = d;
            this.wt = w;
        }
    }
    static class Pair {
        int stops;
        int node;
        int cost;
        public Pair(int s, int n, int c) {
            this.stops = s;
            this.node = n;
            this.cost = c;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            graph[u].add(new Edge(v, wt));
        }
        int[] dist = new int[n];
        for(int i = 0; i<n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, src, 0));
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.cost;
            if(stops > k) {
                continue;
            }
            for(int i = 0; i<graph[node].size(); i++) {
                Edge e = graph[node].get(i);
                int adjNode = e.dest;
                int wt = e.wt;
                if(cost + wt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + wt;
                    q.offer(new Pair(stops + 1, adjNode, cost + wt));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}