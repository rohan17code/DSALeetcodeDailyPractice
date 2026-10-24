class Solution {
    private int cntSubArr(int[] nums, long maxSum) {
        int subArr = 1;
        int sum = 0;
        for(int num : nums) {
            if(num + sum <= maxSum) {
                sum += num;
            } else {
                subArr++;
                sum = num;
            }
        }
        return subArr;
    }
    public int splitArray(int[] nums, int k) {
        long left = 0, right = 0;
        for(int num : nums) {
            left = Math.max(num, left);
            right += num;
        }
        while(left<= right) {
            long mid = left+(right-left)/2;
            if(cntSubArr(nums, mid) > k) left = mid + 1;
            else right = mid - 1;
        }
        return (int) left;
    }
}