/*You are given an integer n.

Define its mirror distance as: abs(n - reverse(n))​​​​​​​ where reverse(n) is the integer formed by reversing the digits of n.

Return an integer denoting the mirror distance of n​​​​​​​.

abs(x) denotes the absolute value of x.

 

Example 1:

Input: n = 25

Output: 27

Explanation:

reverse(25) = 52.
Thus, the answer is abs(25 - 52) = 27.*/
class Solution {
    public int mirrorDistance(int n) {
        int rev=0;
        for (int i=n;i>0;i/=10){
            rev=10*rev+i%10;
        }
        return Math.abs(rev-n);
        
    }
}
