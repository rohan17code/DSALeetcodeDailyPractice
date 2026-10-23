class Solution {
    public int mySqrt(int x) {
        long left = 1, right = x;
        while(left <= right) {
            long mid = left + (right - left)/2;
            long sqr = mid * mid;
            if(sqr <= x) left = mid + 1;
            else right = mid - 1;
        }
        return (int) right;
        
    }
}