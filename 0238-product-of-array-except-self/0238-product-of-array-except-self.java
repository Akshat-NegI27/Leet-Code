class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] left = new int [n];
        int [] right = new int [n];
        int [] ans = new int [n];
        int pdt = 1;
        for(int i = 0; i < n; i++)
        {
            left[i] = pdt;
            pdt *= nums[i];
        }
        pdt = 1;
        for(int i = n-1; i>=0; i--){
            right[i] = pdt;
            pdt *= nums[i];
        }
        for(int i =0; i<n; i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}