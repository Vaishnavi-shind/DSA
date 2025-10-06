class Solution {
    private int longestPalindromeStart = 0;
    private int longestPalindromeLength = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        // Iterate through all possible centers
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (center is s.charAt(i))
            expandAroundCenter(s, i, i);
            
            // Case 2: Even length palindrome (center is s.charAt(i) and s.charAt(i+1))
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(longestPalindromeStart, longestPalindromeStart + longestPalindromeLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        // Expand as long as the indices are valid and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // After the loop, the current palindrome is s[left+1...right-1]
        // Its length is (right - 1) - (left + 1) + 1 = right - left - 1
        int currentLength = right - left - 1;

        if (currentLength > longestPalindromeLength) {
            longestPalindromeLength = currentLength;
            // The starting index is one step to the right of the failed 'left' expansion
            longestPalindromeStart = left + 1;
        }
    }
}