class Solution {
    private boolean canWePlace(int[] position, int dist, int ball) {
        int cntBall = 1, lastPlacedBall = position[0];
        for(int i = 1; i<position.length; i++) {
            if(position[i] - lastPlacedBall >= dist) {
                cntBall++;
                lastPlacedBall = position[i];
            }
            if(cntBall >= ball) return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1, right = position[n-1] - position[0];
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(canWePlace(position, mid, m) == true) {
                left = mid + 1;
            } else right = mid -1;
        }
        return right;
    }
}