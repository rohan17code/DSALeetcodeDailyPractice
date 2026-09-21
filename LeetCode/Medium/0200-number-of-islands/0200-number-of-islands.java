class Solution {
    private void dfs(char[][] grid, int i, int j) {
        // checking if 0 or visited then do nothing
        if(i < 0 || i >= grid.length ||   
        j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0'; // making visited

        // explore all four direction
        dfs(grid, i+1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
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