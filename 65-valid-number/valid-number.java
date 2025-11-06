class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasDot = false;
        boolean hasE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (c == '+' || c == '-') {
           
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == 'e' || c == 'E') {

                if (hasE || !hasDigit) {
                    return false;
                }
                hasE = true;
                hasDigit = false; // Reset hasDigit for the exponent part
            } else {
                return false; // Any other character is invalid
            }
        }
        return hasDigit; // Must have at least one digit
    }
}