class Solution {
    private int func(int[] piles, int mid) {
        double sum = 0;
        for(int pile : piles) {
            sum += Math.ceil((double)(pile) / (double)(mid));
        }
        return (int) sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for(int pile : piles) {
            right = Math.max(right, pile);
        }
        while(left <= right) {
            int mid = left + (right-left)/2;
            int sumAfterDiv = func(piles, mid);
            if(sumAfterDiv <= h) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return left;
    }
}