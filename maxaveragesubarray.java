/*You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75*/
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int s=0;
        for(int i=0;i<k;i++){
            s+=nums[i];

        }
        int maxsum=s;
        for(int i=k;i<n;i++){
            s=s-nums[i-k]+nums[i];
            if(s>maxsum){
                maxsum=s;
            }
        }        
        return (double) maxsum/k;
    }
}
/*Dry Run
nums=[1,12,-5,-6,50,3]
k=4
n=6
s=0
i--> 0 to 3
s=1
s=13
s=8
s=2
maxsum=2
i-->=4 to 5
arr[4]=50
s=2-1(arr[0]) + 50=51
51>2 
maxsum=51
arr[5]=3
s=51-12+3=42

12.00 ans*/
