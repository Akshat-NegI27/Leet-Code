class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String a = String.valueOf(start);
        String b = String.valueOf(finish);
        while (a.length() < b.length())
            a = "0" + a;
        long[][][] mem = new long[b.length()][2][2];
        for (long[][] m : mem)
            for (long[] mm : m)
                Arrays.fill(mm, -1);
        return count(a, b, 0, limit, s, true, true, mem);
    }

    private long count(String a, String b, int i, int limit, String s, boolean tight1, boolean tight2, long[][][] mem) {
        if (i + s.length() == b.length()) {
            String aMinSuffix = tight1 ? a.substring(a.length() - s.length()) : "0".repeat(s.length());
            String bMaxSuffix = tight2 ? b.substring(b.length() - s.length()) : "9".repeat(s.length());
            long suffix = Long.parseLong(s);
            return Long.parseLong(aMinSuffix) <= suffix && suffix <= Long.parseLong(bMaxSuffix) ? 1 : 0;
        }

        if (mem[i][tight1 ? 1 : 0][tight2 ? 1 : 0] != -1)
            return mem[i][tight1 ? 1 : 0][tight2 ? 1 : 0];

        long res = 0;
        int minDigit = tight1 ? a.charAt(i) - '0' : 0;
        int maxDigit = tight2 ? b.charAt(i) - '0' : 9;

        for (int d = minDigit; d <= maxDigit; ++d) {
            if (d > limit)
                continue;
            res += count(a, b, i + 1, limit, s, tight1 && d == minDigit, tight2 && d == maxDigit, mem);
        }

        return mem[i][tight1 ? 1 : 0][tight2 ? 1 : 0] = res;
    }
}
