class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;
            if(sq <= x)  left = mid + 1;
            else right = mid - 1;
        }
        return (int) right;
    }
}