class Solution {
    public int findDuplicate(int[] nums) {
  
      // Step 1: Detect the cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];        // Move 1 step
            fast = nums[nums[fast]];  // Move 2 steps
              System.out.println("slow"+slow);
        System.out.println("fast"+fast);
        } while (slow != fast);
        System.out.println("slow"+slow);
        System.out.println("fast"+fast);
        // Step 2: Find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // or fast, both are at the duplicate number

    }
}