/*You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.

The score of a path between two cities is defined as the minimum distance of a road in this path.

Return the minimum possible score of a path between cities 1 and n.

Note:

A path is a sequence of roads between two cities.
It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
The test cases are generated such that there is at least one path between 1 and n.
 

Example 1:


Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
Output: 5
Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
It can be shown that no other path has less score.*/

class Solution {
    int find(int[] root,int i){
        if(root[i]==i){
            return i;
        }
        return root[i]=find(root,root[i]);
    }
    public int minScore(int n, int[][] roads) {
        int [] root=new int [n+1];
        
        for (int i=0;i<=n;i++){
            root[i]=i;
        }
        for(int[]r:roads){
            root[find(root,r[0])]=find(root,r[1]);
        }
        int res=10001;
        for(int[]r:roads){
            if(find(root,r[0])==find(root,1)){
                res=Math.min(res,r[2]);
            }
        }
        return res;

      /*dry run
      n = 4

roads = {
    {1,2,9},
    {2,3,6},
    {2,4,5},
    {1,4,7}
}

The roads represent:

1 ----9---- 2
|            |\
7            6 5
|            | \
4------------3

We want the minimum edge distance in the connected component containing city 1.

Step 1: Initialize root array
int[] root = new int[n+1];

Since n=4

Index : 0 1 2 3 4
root  : 0 1 2 3 4

Every node is its own parent.

Step 2: Union all roads
Road 1
{1,2,9}
find(root,1)
root[1]=1

Returns 1

find(root,2)
root[2]=2

Returns 2

Union

root[1]=2;

Now

root

0 2 2 3 4
Road 2
{2,3,6}
find(root,2)
root[2]=2

Returns 2

find(root,3)

Returns 3

Union

root[2]=3;

Now

root

0 2 3 3 4

Current chain

1 → 2 → 3
Road 3
{2,4,5}
find(root,2)
root[2]=3

Need recursion.

find(3)

returns 3

Path compression

root[2]=3

returns 3

find(root,4)

returns 4

Union

root[3]=4

Now

root

0 2 3 4 4

Chain

1 → 2 → 3 → 4
Road 4
{1,4,7}
find(root,1)
root[1]=2

Need recursion

find(2)

root[2]=3

find(3)

root[3]=4

find(4)

returns 4

Now path compression happens.

root[3]=4
root[2]=4
root[1]=4

So

find(1)=4
find(root,4)

returns 4

Union

root[4]=4

Nothing changes.

Final root array

Index : 0 1 2 3 4
root  : 0 4 4 4 4

All cities belong to the same component.

Step 3: Find minimum score

Initially

res = 10001
Road {1,2,9}
find(1)=4
find(1)=4

Same component

res=min(10001,9)=9
Road {2,3,6}
find(2)=4
find(1)=4

Same component

res=min(9,6)=6
Road {2,4,5}
find(2)=4
find(1)=4

Same component

res=min(6,5)=5
Road {1,4,7}
find(1)=4
find(1)=4

Same component

res=min(5,7)=5
Final Answer
return 5;
How find() Works (Path Compression)

Suppose before compression:

root

1 → 2 → 3 → 4

Calling

find(root,1)

Execution:

find(1)
    ↓
find(2)
    ↓
find(3)
    ↓
find(4)

Since

root[4]==4

Return 4.

Now recursion unwinds:

root[3]=4
root[2]=4
root[1]=4

After compression:

1
 \
2
  \
3
   \
    4

becomes

1 ─┐
2 ─┤
3 ─┤→ 4
4 ─┘

Every future find() on 1, 2, or 3 takes O(1) time.*/

    }
}
