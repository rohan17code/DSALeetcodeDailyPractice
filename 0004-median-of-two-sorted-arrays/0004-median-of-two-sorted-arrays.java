class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int idx = 0;
        for(int num : nums1) {
            arr[idx] = num;
            idx++;
        }
        for(int num2 : nums2) {
            arr[idx] = num2;
            idx++;
        }
        Arrays.sort(arr);
        double median;
        if ((arr.length % 2) == 0) {
            int mid1 = arr[arr.length / 2 - 1];
            int mid2 = arr[arr.length / 2];
            median = (mid1 + mid2) / 2.0;
        } else {
            return arr[arr.length / 2];
        }
        return median;
    }
}