class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        int even = 0, odd = 0;
        int balance = 0;
        int ans = 0;

        firstIndex.put(0, -1);

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            if (freq.getOrDefault(val, 0) == 0) {
                if (val % 2 == 0) even++;
                else odd++;
            }

            freq.put(val, freq.getOrDefault(val, 0) + 1);

            balance = even - odd;

            if (firstIndex.containsKey(balance)) {
                ans = Math.max(ans, i - firstIndex.get(balance));
            } else {
                firstIndex.put(balance, i);
            }
        }

        return ans;
    }
}