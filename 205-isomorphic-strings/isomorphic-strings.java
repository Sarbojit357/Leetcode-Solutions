class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (map.containsKey(chS)) {
                if (map.get(chS) != chT) {
                    return false;
                }
            } else {
                if (map.containsValue(chT)) {
                    return false;
                }
                map.put(chS, chT);
            }
        }
        return true;
    }
}
