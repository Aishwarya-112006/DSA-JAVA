/*Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.*/

class Solution {
    public int numberOfSubstrings(String s) {
        int res=0;
        int [] p={-1,-1,-1};
        for(int i=0;i<s.length();i++){
            p[(s.charAt(i)&31)-1]=i;
            res+=Math.min(p[0],Math.min(p[1],p[2]))+1;
        }
        return  res;
    }
}

/*Dry Run 
int[] p={-1,-1,-1} gives the last pccurence of a,b,c
initially p[0]=-1 p[1]=-1 p[2]=-1
(s.charAt(i) & 31) - 1

This is a clever ASCII trick.

ASCII values:

'a' = 97
'b' = 98
'c' = 99

Binary:

97 = 1100001
31 = 0011111
----------------
97 & 31 = 1

98 & 31 = 2

99 & 31 = 3

Then

'a' -> 1-1 = 0

'b' -> 2-1 = 1

'c' -> 3-1 = 2

So

p[(s.charAt(i)&31)-1]=i;

is equivalent to

if(ch=='a') p[0]=i;
if(ch=='b') p[1]=i;
if(ch=='c') p[2]=i;

just much shorter.

Step 3: Why
Math.min(p[0], Math.min(p[1], p[2])) + 1

Suppose

last a = 7
last b = 4
last c = 6

The minimum is

4

Any substring ending at the current index and starting anywhere from

0...4

will contain all three letters.

Number of such starting positions

4+1 = 5

Hence

min(lastA,lastB,lastC)+1

new valid substrings end at the current index.

Dry Run

Take

s = "abcabc"

Initial

p = [-1,-1,-1]
res = 0
i = 0

Character

a

Update

p = [0,-1,-1]

Minimum

min = -1

Contribution

-1+1=0
res = 0
i = 1

Character

b

Update

p=[0,1,-1]

Minimum

-1

Contribution

0
res=0
i = 2

Character

c

Update

p=[0,1,2]

Minimum

0

Contribution

1

Valid substring:

abc
res=1
i = 3

Character

a

Update

p=[3,1,2]

Minimum

1

Contribution

2

Substrings ending at index 3:

abca
bca

Both contain a,b,c.

res=3
i = 4

Character

b

Update

p=[3,4,2]

Minimum

2

Contribution

3

Substrings:

abcab
bcab
cab
res=6
i = 5

Character

c

Update

p=[3,4,5]

Minimum

3

Contribution

4

Substrings:

abcabc
bcabc
cabc
abc
res=10
Final Table
i	Character	p (a,b,c)	min	Added	res
0	a	[0,-1,-1]	-1	0	0
1	b	[0,1,-1]	-1	0	0
2	c	[0,1,2]	0	1	1
3	a	[3,1,2]	1	2	3
4	b	[3,4,2]	2	3	6
5	c	[3,4,5]	3	4	10

Final answer:

10*/
