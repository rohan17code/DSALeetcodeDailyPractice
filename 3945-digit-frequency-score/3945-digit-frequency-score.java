class Solution {
    public int digitFrequencyScore(int n) {
        int ans = 0;
        while(n > 0) {
        int digit = n % 10;
        ans += digit;
        n = n/10;
        }
        return ans;
    }
}