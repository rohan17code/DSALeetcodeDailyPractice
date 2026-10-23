class Solution {
    private int func(int[] nums, int mid) {
        double sum = 0;
        for(int num : nums) {
            sum += Math.ceil((double)(num)/ (double)(mid));
        }
        return (int) sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for(int num : nums) {
            right = Math.max(right, num);
        }
        while(left <= right) {
            int mid = left +(right-left)/2;
            int sumAfterDiv = func(nums, mid);
            if(sumAfterDiv <= threshold) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return left;
    }
}