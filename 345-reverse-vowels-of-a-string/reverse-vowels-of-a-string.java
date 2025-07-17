import java.util.*;
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(j>i){
            if(!isVowel(chars[i])){
                i++;
            }else if(!isVowel(chars[j])){
                j--;
            } else{
                char temp  = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }
    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
        ch == 'A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        else
            return false;    
    }
}