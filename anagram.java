/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> counter=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            counter.put(c,counter.getOrDefault(c,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!counter.containsKey(ch)|| counter.get(ch)==0){
                return false;
            }
            counter.put(ch,counter.get(ch)-1);
        }
        return true;
        
    }
}
