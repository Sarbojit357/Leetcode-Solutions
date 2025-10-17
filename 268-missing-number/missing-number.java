class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalsum = n*(n+1)/2;
        int arraysum = 0;
        for(int i = 0; i<nums.length; i++){
            arraysum = arraysum + nums[i];
        }
        int result = totalsum - arraysum;
        return result;
    }
}