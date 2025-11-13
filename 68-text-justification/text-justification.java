import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int j = i;
            int lineLength = 0;

            // Find words that fit in the current line
            while (j < n && (lineLength + words[j].length() + (j - i)) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            StringBuilder line = new StringBuilder();
            int numberOfWords = j - i;
            int totalSpaces = maxWidth - lineLength;

            // Last line or single word line
            if (j == n || numberOfWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else { // Justify internal lines
                int spacesBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spacesBetweenWords; s++) {
                            line.append(" ");
                        }
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }
}