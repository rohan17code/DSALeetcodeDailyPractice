class Solution {
    private int sumByD(int[] nums, int div) {
        double sum = 0;
        int n = nums.length;
        for(int i = 0; i<n; i++) {
            sum += Math.ceil((double)(nums[i]) / (double)(div));
        }
        return (int) sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1, right = 0;
        for(int num : nums) {
            right = Math.max(num, right);
        }
        while(left <= right) {
            int mid = left +(right - left)/2;
            if(sumByD(nums, mid) <= threshold) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}