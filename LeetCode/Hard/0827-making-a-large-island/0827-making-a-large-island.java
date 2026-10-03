class Solution {
    static int[] par;
    static int[] size;
    private static void init(int n) {
        for(int i = 0; i<n; i++) {
            par[i] = i;
            size[i] = 1;
        }
    }
    private static int find(int x) {
        if(x == par[x]) return x;
        return par[x] = find(par[x]);
    }
    private static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if(parA == parB) return;
        if(size[parA] < size[parB]) {
            par[parA] = parB;
            size[parB] += size[parA];
        } else {
            par[parB] = parA;
            size[parA] += size[parB];
        }
    }    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        par = new int[n*n];
        size = new int[n*n];
        init(n*n);
        int[] deltaRow = {-1,0,1,0};
        int[] deltaCol = {0,1,0,-1};
        for(int row = 0; row<n; row++) {
            for(int col = 0; col<n; col++) {
                if(grid[row][col] == 0) continue;
                int nodeNum = row * n + col;
                for(int i = 0; i<4; i++) {
                    int newRow = row + deltaRow[i];
                    int newCol = col + deltaCol[i];
                    if(newRow >= 0 && newRow<n && newCol >= 0 && newCol <n && 
                    grid[newRow][newCol] == 1) {
                        int adjNodeNum = newRow * n + newCol;
                        union(nodeNum, adjNodeNum);
                    }
                }
            }
        }
        int max = 0;
        for(int row = 0; row<n; row++) {
            for(int col = 0; col<n; col++) {
               if(grid[row][col] == 1) continue;
               Set<Integer> components = new HashSet<>();
               for(int i =0; i<4; i++) {
                    int newRow = row + deltaRow[i];
                    int newCol = col + deltaCol[i];
                    if(newRow >= 0 && newRow<n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        int adjNodeNum = newRow * n + newCol;
                        components.add(find(adjNodeNum));
                    }
               } 
               int sizeTotal = 1;
               for(int parent : components) {
                sizeTotal += size[parent];
               }
               max = Math.max(max, sizeTotal);
            }
        }
        for(int i = 0; i<n*n; i++) {
            max = Math.max(max, size[find(i)]);
        }
        return max;
    }
}