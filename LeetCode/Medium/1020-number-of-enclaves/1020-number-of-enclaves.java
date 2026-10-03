class Solution {
    private void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);        
    }
    public int numEnclaves(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
       int row = grid.length;
       int col = grid[0].length;
       for(int i = 0; i<row; i++) {
        if(grid[i][0] == 1) {
            dfs(grid, i, 0);
        }
        if(grid[i][col - 1] == 1) {
            dfs(grid, i, col-1);
        }
       }
       for(int i = 0; i<col; i++) {
        if(grid[0][i] == 1) {
            dfs(grid, 0, i);
        }
        if(grid[row - 1][i] == 1) {
            dfs(grid, row-1, i);
        }
       } 
       int cnt = 0;
       for(int i = 0; i<row; i++) {
        for(int j = 0; j<col; j++) {
            if(grid[i][j] == 1) cnt++;    
        }
       }
       return cnt;
    }
}