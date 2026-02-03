/* You are given a 0-indexed array of integers nums of length n, and two positive integers k and dist.

The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.

You need to divide nums into k disjoint contiguous subarrays, such that the difference between the starting index of the second subarray and the starting index of the kth subarray should be less than or equal to dist. In other words, if you divide nums into the subarrays nums[0..(i1 - 1)], nums[i1..(i2 - 1)], ..., nums[ik-1..(n - 1)], then ik-1 - i1 <= dist.

Return the minimum possible sum of the cost of these subarrays.

 

Example 1:

Input: nums = [1,3,2,6,4,2], k = 3, dist = 3
Output: 5
Explanation: The best possible way to divide nums into 3 subarrays is: [1,3], [2,6,4], and [2]. This choice is valid because ik-1 - i1 is 5 - 2 = 3 which is equal to dist. The total cost is nums[0] + nums[2] + nums[5] which is 1 + 2 + 2 = 5.
It can be shown that there is no possible way to divide nums into 3 subarrays at a cost lower than 5.*/
class Solution {

    public long minimumCost(int[] nums, int k, int dist) {

        int n = nums.length;
      /*Stores smallest k-1 elements
      //Stores smallest k-1 elements
      //Sorted by:
      //value (a[0])
      //index (a[1]) to avoid duplicates
      These elements contribute to the current sum*/
        TreeSet<int[]> left = new TreeSet<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
      /*Stores remaining elements in the window

      Used as a backup when an element leaves left*/

        
        TreeSet<int[]> right = new TreeSet<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
      

        long sum = 0;//sum of element in left
        long ans = Long.MAX_VALUE;// minimum sum found so far

        
        for (int i = 1; i <= dist + 1 && i < n; i++) {// window start from index 1--> end at dist+1
            int[] curr = new int[]{nums[i], i};//creates a pair of value and index
            // adds element to the left
            //updates sum
            left.add(curr);
            sum += nums[i];

            if (left.size() > k - 1) {//ensures left contain atmost k-1 element
                int[] move = left.pollLast();//removes largest element from left
              // removes its value from sum
              //stores it in right
                sum -= move[0];
                right.add(move);
            }
        }

        ans = sum;

     
        for (int i = dist + 2; i < n; i++) {

            int[] add = new int[]{nums[i], i};
            left.add(add);
            sum += add[0];

            if (left.size() > k - 1) {
                int[] move = left.pollLast();
                sum -= move[0];
                right.add(move);
            }

            int removeIdx = i - (dist + 1);
            int[] rem = new int[]{nums[removeIdx], removeIdx};

            if (left.remove(rem)) {
                sum -= rem[0];
                if (!right.isEmpty()) {
                    int[] promote = right.pollFirst();
                    left.add(promote);
                    sum += promote[0];
                }
            } else {
                right.remove(rem);
            }

            ans = Math.min(ans, sum);
        }

        return nums[0] + ans;
    }
}
