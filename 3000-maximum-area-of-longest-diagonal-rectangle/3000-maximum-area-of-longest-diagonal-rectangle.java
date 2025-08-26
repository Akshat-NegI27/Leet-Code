class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = -1;
        int maxArea = -1;

        for (int[] d : dimensions) {
            int l = d[0], w = d[1];
            int diag = l * l + w * w;
            int area = l * w;

            if (diag > maxDiag || (diag == maxDiag && area > maxArea)) {
                maxDiag = diag;
                maxArea = area;
            }
        }
        return maxArea;
    }
}
