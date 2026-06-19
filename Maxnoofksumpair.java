/*You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.*/

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        int i=0;
        int j=nums.length-1;
        while (i<j){
            int temp=nums[i]+nums[j];
            if(temp==k){
                i++;
                j--;
                ans++;
            }
            else if(temp>k){
                    j--;
                }
            
            else{
                i++;
            }
        }
        return ans;
        
    }
}

/*Dry Run
nums=[1,2,3,4]
int i=0
int j=3
i=0 ,j=3 --> 0<3
temp=1+4=5 = 5
i=1, j=2 , 1-->1<2
temp=2+3=5=5
i=2,j=1,ans=2
j<i loop ends 
return ans ans =2

nums=[3,1,3,4,3] k=6
sorted nums=[1,3,3,3,4]
i=0
j=4
ans=0
0<4
temp=1+4=5!=6
i=1,j=4
temp=7!=6
i=1,j=3
temp=6=6
i=2,j=2 ans=1
loop ends ans =1
*/
