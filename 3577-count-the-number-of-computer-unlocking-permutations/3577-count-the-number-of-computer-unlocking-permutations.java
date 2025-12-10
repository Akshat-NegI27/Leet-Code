class Solution {
    
    // Constant for the modulo operation: 10^9 + 7
    private static final int MOD = 1_000_000_007;

    /**
     * Calculates the number of permutations based on the input 'complexity' array.
     * The logic is:
     * 1. Count elements strictly greater than the first element (complexity[0]). Let this be 'cnt'.
     * 2. If 'cnt' is not equal to (array length - 1), return 0.
     * 3. Otherwise, return (cnt! % MOD).
     *
     * @param complexity An array of integers.
     * @return The calculated number of permutations modulo (10^9 + 7).
     */
    public int countPermutations(int[] complexity) {
        // Handle edge case of an empty array
        if (complexity == null || complexity.length == 0) {
            return 0;
        }

        int n = complexity.length;
        int minVal = complexity[0]; // The first element
        int cnt = 0; // Counter for elements strictly greater than minVal

        // 1. Count elements strictly greater than the first element
        // Start loop from the second element (index 1) or iterate through all and skip the first element's comparison
        for (int com : complexity) {
            if (com > minVal) {
                cnt++;
            }
        }
        
        // Note: The logic from the Python code iterates through all elements
        // including complexity[0], but since complexity[0] > complexity[0] is false,
        // it only effectively counts elements strictly greater than the first element
        // in the *rest* of the array. The implementation above reflects this.
        
        // 2. Check the condition from the original Python code:
        // if cnt != len(complexity) - 1: return 0
        if (cnt != n - 1) {
            return 0;
        }

        // 3. Otherwise, return math.factorial(cnt) % MOD
        // We use a safe factorial calculation helper method
        return (int) (factorial(cnt) % MOD);
    }
    
    /**
     * Helper method to calculate n! % MOD.
     * We use a long for intermediate calculations to prevent overflow 
     * before the modulo operation.
     * * @param n The number to calculate the factorial of.
     * @return (n! % MOD).
     */
    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            // Apply modulo at each multiplication to prevent overflow
            result = (result * i) % MOD;
        }
        return result;
    }
}