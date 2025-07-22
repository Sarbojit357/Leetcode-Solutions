class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int i = 0, j = n -1;
        Arrays.sort(nums);
        int result = 0;
        while(i<j){
            int sum = nums[i] + nums[j];
            result = Math.max(result, sum);
            i++;
            j--;
        }
        return result;
    }
}