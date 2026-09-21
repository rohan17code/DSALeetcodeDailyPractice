class Solution {
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length ||
        j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null || grid[0].length == 0) {
            return 0;
        }
        int cnt = 0;
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}