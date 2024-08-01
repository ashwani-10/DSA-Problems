class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int deletions = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                stack.push(c);
            } else if (c == 'a') {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop(); // Remove the 'b' which makes the string unbalanced
                    deletions++; // We consider this as a deletion of 'b'
                }
            }
        }
        
        return deletions;
    }
}