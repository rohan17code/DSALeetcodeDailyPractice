class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        int left = 1, right = n - 2;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) return nums[mid];
            
            // (even, odd) left half -> eleminate left bcz element is on right
            if(mid % 2 != 0 && nums[mid - 1] == nums[mid] ||
            mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                left = mid + 1;  
            } else {
                right = mid - 1;    // (odd, even) -> right half
            }
        }
        return -1;
    }
}