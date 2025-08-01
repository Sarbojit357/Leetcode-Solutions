import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            if (countMap.containsKey(num)) {
                return num; // Duplicate found
            }
            countMap.put(num, 1);
        }

        return -1; // Should never happen if input is valid
    }
}
