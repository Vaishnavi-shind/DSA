class Solution {
    
     //DSA
    public String removeOuterParentheses(String s) {
        // Use a StringBuilder for efficient string concatenation
        StringBuilder result = new StringBuilder();
        int balance = 0;

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // For an opening parenthesis '(':
                // If the balance is already >= 1, it means this '(' 
                // is NOT the *first* '(' of a new primitive string (i.e., it's an inner one).
                // If balance is 0, this is the outermost '(', and we don't append it yet.
                if (balance > 0) {
                    result.append(c);
                }
                // Always increment the balance for an opening parenthesis
                balance++;
            } else { // c == ')'
                // For a closing parenthesis ')':
                // Decrement the balance first, as we have closed a parenthesis.
                balance--;
                
                // If the balance is still >= 1, it means this ')' 
                // is NOT the *last* ')' of the current primitive string (i.e., it's an inner one).
                // If balance is 0, this is the outermost ')', and we don't append it.
                if (balance >= 1) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}