/*You are given a binary string s of length n, where:

'1' represents an active section.
'0' represents an inactive section.
You can perform at most one trade to maximize the number of active sections in s. In a trade, you:

Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
Return the maximum number of active sections in s after making the optimal trade.

Note: Treat s as if it is augmented with a '1' at both ends, forming t = '1' + s + '1'. The augmented '1's do not contribute to the final count.

 

Example 1:

Input: s = "01"

Output: 1

Explanation:

Because there is no block of '1's surrounded by '0's, no valid trade is possible. The maximum number of active sections is 1.

Example 2:

Input: s = "0100"

Output: 4

Explanation:

String "0100" → Augmented to "101001".
Choose "0100", convert "101001" → "100001" → "111111".
The final string without augmentation is "1111". The maximum number of active sections is 4.
Example 3:

Input: s = "1000100"

Output: 7

Explanation:

String "1000100" → Augmented to "110001001".
Choose "000100", convert "110001001" → "110000001" → "111111111".
The final string without augmentation is "1111111". The maximum number of active sections is 7.
*/


class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char [] arr=s.toCharArray();
        int n=arr.length;
        int c1=0;
        int b1=0;
        int b2=0;
        int maxx=0;
        int i=0;
        while(i<n){
            char ch=arr[i];
            if (ch == '0'){
                b1++;
                i++;

            }
            else{
                while(i<n && arr[i]=='1'){
                    i++;
                    c1++;

                }
                while (i<n && arr[i]=='0'){
                    i++;
                    b2++;
                }
                if (b1!=0 && b2!=0) maxx=Math.max(maxx,b1+b2);
                b1=b2;
                b2=0;
            }
        }
        return c1+maxx;
        
    }
}
