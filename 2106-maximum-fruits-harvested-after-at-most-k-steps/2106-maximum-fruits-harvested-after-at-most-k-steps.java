class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;

        long[] prefixFruits = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixFruits[i + 1] = prefixFruits[i] + fruits[i][1];
        }

        int maxFruits = 0;

        int left = 0;
        for (int right = 0; right < n; right++) {
            long rightPos = fruits[right][0];

            while (left <= right) {
                long leftPos = fruits[left][0];
                long steps;

                if (startPos >= leftPos && startPos <= rightPos) {
                    long distToLeft = startPos - leftPos;
                    long distToRight = rightPos - startPos;
                    steps = 2 * Math.min(distToLeft, distToRight) + Math.max(distToLeft, distToRight);
                } else if (startPos < leftPos) {
                    steps = rightPos - startPos;
                } else { 
                    steps = startPos - leftPos;
                }

                if (steps <= k) {
                    break;
                }

                left++;
            }

            if (left <= right) {
                maxFruits = Math.max(maxFruits, (int) (prefixFruits[right + 1] - prefixFruits[left]));
            }
        }

        return maxFruits;
    }
}