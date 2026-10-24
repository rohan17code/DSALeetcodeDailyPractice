class Solution {
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left +(right - left)/2;
            if(nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    private int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left +(right - left)/2;
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }    
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        int second = upperBound(nums, target);
        if(first == nums.length || nums[first] != target) {
            return new int[]{-1,-1};
        }
        return new int[]{first, second - 1};
    }
}