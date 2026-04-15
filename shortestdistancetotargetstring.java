/*You are given a 0-indexed circular string array words and a string target. A circular array means that the array's end connects to the array's beginning.

Formally, the next element of words[i] is words[(i + 1) % n] and the previous element of words[i] is words[(i - 1 + n) % n], where n is the length of words.
Starting from startIndex, you can move to either the next word or the previous word with 1 step at a time.

Return the shortest distance needed to reach the string target. If the string target does not exist in words, return -1.

 */
class Solution {
    public int closestTarget(String[] words, String target, int start) {
        int n = words.length;
        for (int i = 0; i <= n >> 1; i++)
            if (words[(start + i) % n].equals(target) |
                words[(start - i + n) % n].equals(target))
                return i;

        return -1;
    }
}
