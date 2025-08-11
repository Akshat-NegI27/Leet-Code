class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;
        final int MAX_BIT = 30;
        int[] ans = new int[queries.length];
        List<Integer> pows = new ArrayList<>();

        for (int i = 0; i < MAX_BIT; ++i) {
            if ((n >> i & 1) == 1) {
                pows.add(1 << i);
            }
        }

        long[] prefixProd = new long[pows.size() + 1];
        prefixProd[0] = 1;
        for (int i = 0; i < pows.size(); ++i) {
            prefixProd[i + 1] = (prefixProd[i] * pows.get(i)) % MOD;
        }

        for (int i = 0; i < queries.length; ++i) {
            int left = queries[i][0];
            int right = queries[i][1];

            long prod = prefixProd[right + 1];
            long inv = modularInverse(prefixProd[left], MOD);

            ans[i] = (int) ((prod * inv) % MOD);
        }

        return ans;
    }

    private long modularInverse(long n, int mod) {
        return power(n, mod - 2, mod);
    }

    private long power(long base, int exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}