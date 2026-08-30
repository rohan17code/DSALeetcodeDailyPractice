class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int min = 0, max = 0;
        for(int i = 0; i<n; i++) {
            if(nums[i] > nums[max]) max = i;
            if(nums[i] < nums[min]) min = i;
        }
        int l = Math.min(min, max);
        int r = Math.max(min, max);

        int opt1 = r + 1;
        int opt2 = n - l;
        int opt3 = (l + 1) + (n - r);
        return Math.min(opt1, Math.min(opt2, opt3));
    }
}