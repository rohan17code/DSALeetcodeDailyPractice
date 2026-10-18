class Solution {
    private double func(int[] piles, int mid) {
        double sum = 0;
        for(int pile : piles) {
            sum += Math.ceil((double)pile/mid);
        }
        return (int) sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0, right = 0;
        for(int pile : piles) {
            right = Math.max(right, pile);
        }
        while(left <= right) {
            int mid = left + (right - left) /2;
            if(func(piles, mid) > h) left = mid +1;
            else right = mid - 1;
        }
        return left;
    }
}