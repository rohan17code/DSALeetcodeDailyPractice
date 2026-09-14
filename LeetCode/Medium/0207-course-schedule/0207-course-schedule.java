class Solution {
    private static void CalInDeg(int [][] prerequisites, int[] inDegree) {
        for(int i = 0; i<prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            inDegree[dest]++;
        }        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        CalInDeg(prerequisites, inDegree);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            cnt++;
            for(int i = 0; i<prerequisites.length; i++) {
                if(prerequisites[i][1] == curr) {
                int dest = prerequisites[i][0];
                inDegree[dest]--;
                if(inDegree[dest] == 0) {
                    q.offer(dest);
                }
                
            }
            }
        }
        if(cnt == numCourses) return true;
        else return false;
    }
}