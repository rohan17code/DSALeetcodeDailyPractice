class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n + m];
        int i = 0, j = 0, idx = 0;
        while(i < n && j < m) {
            if(nums1[i] <= nums2[j]) {
                arr[idx++] = nums1[i++];
            } else {
                arr[idx++] = nums2[j++];
            }
        }
        while(i < n) {
            arr[idx++] = nums1[i++];
        }
        while(j < m) {
            arr[idx++] = nums2[j++];
        }
        int len = m + n;
        if(len % 2 == 0) {
            return ((double)arr[len/2-1] + arr[len/2]) / 2;
        }
        return arr[len/2];
    }
}