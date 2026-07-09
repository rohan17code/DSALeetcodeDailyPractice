class Solution {
    public boolean isPowerOfFour(int n) {
        return(((n-1) % 3 == 0) && (n > 0) && ((n & (n-1)) == 0));
    }
}