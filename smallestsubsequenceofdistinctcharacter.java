/*Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 */

class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[27];
        boolean[] seen = new boolean[27];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) & 31]++;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int x = c & 31;
            freq[x]--;

            if (seen[x])
                continue;

            while (!stack.isEmpty()) {
                if (stack.peek() <= c)
                    break;

                if (freq[stack.peek() & 31] == 0)
                    break;

                seen[stack.peek() & 31] = false;
                stack.pop();
            }

            stack.push(c);
            seen[x] = true;
        }

        StringBuilder res = new StringBuilder();

        for (char c : stack)
            res.append(c);

        return res.toString();
    }
}
