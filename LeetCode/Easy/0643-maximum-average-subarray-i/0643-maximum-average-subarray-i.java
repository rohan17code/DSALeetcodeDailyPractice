class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i<k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        int stIdx = 0;
        int endIdx = k;
        while(endIdx < nums.length) {
            sum -= nums[stIdx];   // removing previous element
            stIdx++;
            sum += nums[endIdx];  // adding next element
            endIdx++;
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum/k;
    }
}