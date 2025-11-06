class Solution {
    public int rob(int[] nums) {
        // Edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int rob_prev_prev = nums[0];
        int rob_prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
 
            int current_rob_max = Math.max(nums[i] + rob_prev_prev, rob_prev);

            rob_prev_prev = rob_prev;
            rob_prev = current_rob_max;
        }
        return rob_prev;
    }
}