class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i<nums.length; i++) {
            sum += nums[i];
        }
        if(sum % k == 0) return 0;
        else {
            while(sum % k != 0) {
                sum -= 1;
                cnt++;
            }
        }
        return cnt;
    }
}