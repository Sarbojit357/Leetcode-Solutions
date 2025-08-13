

class Solution {
     public static int[] frequencySort(int[] nums) {
        // Step 1: Find min and max value
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // Step 2: Create frequency array with offset
        int offset = -min; // to shift negatives to >= 0 index
        int[] freq = new int[max + offset + 1];

        // Step 3: Count frequencies
        for (int num : nums) {
            freq[num + offset]++;
        }

        // Step 4: Bubble sort based on frequency asc, value desc
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                int freqA = freq[nums[j] + offset];
                int freqB = freq[nums[j + 1] + offset];
                if (freqA > freqB || (freqA == freqB && nums[j] < nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }
}