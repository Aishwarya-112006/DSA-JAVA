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
