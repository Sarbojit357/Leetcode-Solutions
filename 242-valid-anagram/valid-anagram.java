class Solution {
    public boolean isAnagram(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);

        if(Arrays.equals(first,second)){
            return true;
        }
        else{
            return false;
        }
    }
}