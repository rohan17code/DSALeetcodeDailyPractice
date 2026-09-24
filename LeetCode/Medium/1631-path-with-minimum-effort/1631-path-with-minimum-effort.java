class Solution {
    static class Pair implements Comparable<Pair> {
        int effort;
        int row;
        int col;
        public Pair(int e, int r, int c) {
            this.effort = e;
            this.row = r;
            this.col = c;
        }
        @Override
        public int compareTo(Pair p2) {
            return Integer.compare(this.effort, p2.effort);
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.offer(new Pair(0,0,0));
        
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int effort = curr.effort;
            int row = curr.row;
            int col = curr.col;

            // destination
            if(row == n - 1 && col == m - 1) {
                return effort;
            }
            // checking 4 neighbours
            for(int i = 0; i<4; i++) {
                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol <m) {
                    int diff = Math.abs(heights[row][col] - heights[newRow][newCol]);
                    int newEffort = Math.max(effort, diff);
                    if(newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.offer(new Pair(newEffort, newRow, newCol));
                    }
                }
            }
        }
        return 0;
    }
}