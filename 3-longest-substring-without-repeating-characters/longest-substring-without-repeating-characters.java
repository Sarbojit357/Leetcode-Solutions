class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int maxAns = Integer.MIN_VALUE;
        Set <Character> set = new HashSet<>();
        int l = 0;
        for(int r = 0; r<s.length(); r++){
            if(set.contains(s.charAt(r))){
                while(l<r && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            maxAns = Math.max(maxAns, r - l + 1);
        }
        return maxAns;   
    }
}