class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        int pointer = 0;

        for (int index = 0; index < length; index++) {
            while (pointer < length && (nums[pointer] != key || pointer < index - k)) {
                pointer++;
            }
            if (pointer == length) break;
            if (Math.abs(pointer - index) <= k) {
                result.add(index);
            }
        }

        return result;
    }
}