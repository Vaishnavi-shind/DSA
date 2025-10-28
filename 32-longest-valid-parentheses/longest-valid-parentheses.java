import java.util.Stack;

//DSA
class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        // The stack stores indices of characters, and an initial -1 as a base.
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Push the index of '(' onto the stack
                stack.push(i);
            } else { // s.charAt(i) == ')'
                // A ')' is found, pop the top element (which should be the matching '(' index)
                stack.pop();

                if (stack.isEmpty()) {
                    // If the stack becomes empty, the current ')' is unmatched.
                    // Push its index to be the new base for future valid substrings.
                    stack.push(i);
                } else {
                    // If the stack is not empty, a valid substring is found.
                    // Its length is current index minus the index of the new top (the base).
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}