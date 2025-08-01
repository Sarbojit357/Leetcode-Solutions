class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n]; // we use size n instead of n+1 because numbers go from 1 to n

        for (int num : nums) {
            if (memo[num] == 1) {
                return num; // Duplicate found
            }
            memo[num] = 1;
        }

        return -1; // Should never happen if input is valid
    }
}
