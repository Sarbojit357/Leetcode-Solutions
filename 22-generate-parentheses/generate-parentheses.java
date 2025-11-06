import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start the backtracking process with an empty string
        backtrack(result, "", 0, 0, n);
        return result;
    }

    /**
     * A recursive helper function to generate parenthesis combinations.
     *
     * @param result      The list to store valid combinations.
     * @param currentStr  The string being built in the current recursive path.
     * @param openCount   The number of open parentheses '(' used so far.
     * @param closeCount  The number of close parentheses ')' used so far.
     * @param maxPairs    The target number of parenthesis pairs (n).
     */
    private void backtrack(List<String> result, String currentStr, int openCount, int closeCount, int maxPairs) {
        // Base case: if the string has reached the desired length (2 * n),
        // it's a valid combination, so add it to the list and return.
        if (currentStr.length() == maxPairs * 2) {
            result.add(currentStr);
            return;
        }

        // --- Recursive steps ---

        // 1. If we can still add an open parenthesis, do it and recurse.
        // Condition: The number of open parentheses used is less than the maximum allowed.
        if (openCount < maxPairs) {
            backtrack(result, currentStr + "(", openCount + 1, closeCount, maxPairs);
        }

        // 2. If we can add a closing parenthesis, do it and recurse.
        // Condition: The number of closing parentheses is less than the number of open ones.
        // This ensures the parentheses are always well-formed.
        if (closeCount < openCount) {
            backtrack(result, currentStr + ")", openCount, closeCount + 1, maxPairs);
        }
    }
}