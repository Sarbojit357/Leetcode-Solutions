class Solution {
    public int lengthOfLongestSubstring(String s) {
         if (s == null || s.isEmpty()) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxans = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (map.containsKey(c)) {
                // move left pointer just after the last occurrence
                l = Math.max(l, map.get(c) + 1);
            }

            map.put(c, r);
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }
}