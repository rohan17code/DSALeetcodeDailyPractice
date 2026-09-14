class Solution {
    private static void CalInDeg(int[][] prerequisites, int[] inDeg) {
        for(int i = 0; i<prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            inDeg[dest]++;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        CalInDeg(prerequisites, inDeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<inDeg.length; i++) {
            if(inDeg[i] == 0) {
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
                    inDeg[dest]--;
                    if(inDeg[dest] == 0) {
                        q.offer(dest);
                    }
                } 
            }
        }
        return cnt == numCourses;
    }
}