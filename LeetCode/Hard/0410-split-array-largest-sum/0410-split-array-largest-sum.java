class Solution {
    private int countSubarrays(int[] nums, long maxSum) {
        int subArray = 1, currentSum = 0;
        for(int i = 0; i<nums.length; i++) {
            if(currentSum + nums[i] <= maxSum) {
                currentSum += nums[i];
            } else {
                subArray++;
                currentSum = nums[i];
            }
        }
        return subArray;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        long left = 0, right = 0;
        for(int x: nums) {
            left = Math.max(left, x);
            right += x;
        }
        while(left <= right) {
            long mid = left + (right - left)/2;
            int subArray = countSubarrays(nums, mid);
            if(subArray > k) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return (int) left;
    }
}