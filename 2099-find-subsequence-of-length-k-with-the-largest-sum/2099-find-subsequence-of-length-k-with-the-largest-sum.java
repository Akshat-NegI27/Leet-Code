class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        int[] arr = nums.clone();
        Arrays.sort(arr);
        final int threshold = arr[arr.length - k];
        final int larger = (int) Arrays.stream(nums).filter(num -> num > threshold).count();
        int equal = k - larger;

        int i = 0;
        for (final int num : nums)
            if (num > threshold) {
                ans[i++] = num;
            } else if (num == threshold && equal > 0) {
                ans[i++] = num;
                --equal;
            }

        return ans;
    }
}