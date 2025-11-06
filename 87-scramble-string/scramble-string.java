import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();
        boolean scrambled = false;

        for (int i = 1; i < n; i++) {
            // No swap case
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                scrambled = true;
                break;
            }
            // With swap case
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                scrambled = true;
                break;
            }
        }

        memo.put(key, scrambled);
        return scrambled;
    }
}