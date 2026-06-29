/*Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: patterns = ["a","abc","bc","d"], word = "abc"
Output: 3
Explanation:
- "a" appears as a substring in "abc".
- "abc" appears as a substring in "abc".
- "bc" appears as a substring in "abc".
- "d" does not appear as a substring in "abc".
3 of the strings in patterns appear as a substring in word.
Example 2:

Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
Output: 2
Explanation:
- "a" appears as a substring in "aaaaabbbbb".
- "b" appears as a substring in "aaaaabbbbb".
- "c" does not appear as a substring in "aaaaabbbbb".
2 of the strings in patterns appear as a substring in word.
Example 3:

Input: patterns = ["a","a","a"], word = "ab"
Output: 3
Explanation: Each of the patterns appears as a substring in word "ab".
 */
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans=0;
        for(String str : patterns){
            if(word.indexOf(str)!=-1){
                ans++;
            }
        }
        return ans;
        
    }
}
/*Dry Run
patterns = ["a","abc","bc","d"], word = "abc"
ans =0
word='abc'
str--> a to d (element pf pattern)
str=a
word.indexof(a)--> 0 !=-1
ans=1
str=abc
word.indexof(abc)-->0!=-1
ans=2
str=bc
word.indexof(bc)-->0!=-1
ans=3 ans
*/
