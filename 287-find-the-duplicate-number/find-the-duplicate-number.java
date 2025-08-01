import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return num; // Duplicate found
            }
        }

        return -1; // Should never happen if input is valid
    }
}
