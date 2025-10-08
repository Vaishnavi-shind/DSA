import java.util.HashSet;
import java.util.Set;

class Solution {
    //DSA
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> charSet = new HashSet<>();
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            
            charSet.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}