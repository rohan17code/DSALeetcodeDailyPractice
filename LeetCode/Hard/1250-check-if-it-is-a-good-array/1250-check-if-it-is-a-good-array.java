class Solution {
    public static int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }    
    public boolean isGoodArray(int[] nums) {
        int n = nums[0];
        for(int num : nums) {
            n = gcd(n, num);
            if(n == 1) return true;
        }
        return false;
    }
}