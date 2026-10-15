class Solution {
    private long func(int[] piles, int mid) {
        long sum = 0;
        for(int pile : piles) {
            sum += (int) Math.ceil((double)pile/mid);
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1, right = 0;
        for(int pile : piles) {
            right = Math.max(pile, right);
        }
        while(left <= right) {
            int mid = left + (right - left)/ 2;
            long pileDivByMid = func(piles, mid);
            if(pileDivByMid > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}