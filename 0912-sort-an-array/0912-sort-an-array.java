class Solution {
    static void divide(int[] nums, int si, int ei) {
        if(si >= ei) return;
        int mid = si + (ei - si) / 2;
        divide(nums, si, mid);
        divide(nums, mid + 1, ei);
        conquer(nums, si, mid, ei);
    }
    static void conquer(int[] nums, int si, int mid, int ei) {
        int[] merge = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;
        while(idx1 <= mid && idx2 <= ei) {
            if(nums[idx1] <= nums[idx2]) {
                merge[x] = nums[idx1];
                x++;
                idx1++;
            } else {
                merge[x] = nums[idx2];
                x++;
                idx2++;
            }
        }
        while(idx1 <= mid) {
            merge[x] = nums[idx1];
            x++;
            idx1++;
        }
        while(idx2 <= ei) {
            merge[x] = nums[idx2];
            x++;
            idx2++;
        }
        for(int i = 0, j = si; i<merge.length; i++, j++) {
            nums[j] = merge[i];
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        divide(nums, 0, n-1);
        return nums;
    }
}