class Solution {
    private int func(int[] nums, int divisor) {
        int n = nums.length;
        double sum = 0;
        for(int num : nums) {
            sum += Math.ceil((double)num/(double)divisor);
        }
        return (int) sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for(int num : nums) {
            right = Math.max(right, num);
        }
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(func(nums, mid) <= threshold) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}