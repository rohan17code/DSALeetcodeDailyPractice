class Solution {
    static class Pair {
        int row;
        int col;
        int time;
        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else vis[i][j] = 0;
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        int tm = 0;
        int cnt = 0;
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.time;
            tm = Math.max(tm, t);
            for(int i = 0; i<4; i++) {
            int neighRow = r + deltaRow[i];
            int neighCol = c + deltaCol[i];                
                if(neighRow >= 0 && neighRow < n && neighCol >= 0 && neighCol < m &&
                grid[neighRow][neighCol] == 1) {
                    q.offer(new Pair(neighRow, neighCol, t + 1));
                    grid[neighRow][neighCol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return tm;
    }
}