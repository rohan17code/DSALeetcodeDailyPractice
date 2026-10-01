class Solution {
    static class Pair implements Comparable<Pair> {
        int v;
        int cost;
        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[points.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int finalCost = 0;
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
            for(int i = 0; i<n; i++) {
                int dist = Math.abs(points[curr.v][0] - points[i][0]) + Math.abs(points[curr.v][1] - points[i][1]);
                
                pq.offer(new Pair(i, dist));
                }
            }
        }
        return finalCost;
    }
} 