/*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).*/
 

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int  i=1;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i-1]){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
        
    }
}

/*DryRun
nums=[0,0,1,1,1,2,2,3,3,4]
i=1
j--> 1 to 9
j=1 
j	nums[j]	nums[i-1]	Equal?	Action	i	Array
1	0	0	Yes	Skip	1	[0,0,1,1,1,2,2,3,3,4]
2	1	0	No	nums[1]=1	2	[0,1,1,1,1,2,2,3,3,4]
3	1	1	Yes	Skip	2	[0,1,1,1,1,2,2,3,3,4]
4	1	1	Yes	Skip	2	[0,1,1,1,1,2,2,3,3,4]
5	2	1	No	nums[2]=2	3	[0,1,2,1,1,2,2,3,3,4]
6	2	2	Yes	Skip	3	[0,1,2,1,1,2,2,3,3,4]
7	3	2	No	nums[3]=3	4	[0,1,2,3,1,2,2,3,3,4]
8	3	3	Yes	Skip	4	[0,1,2,3,1,2,2,3,3,4]
9	4	3	No	nums[4]=4	5	[0,1,2,3,4,2,2,3,3,4]
Final Array
nums = [0,1,2,3,4,2,2,3,3,4]

Only the first i elements are considered valid:*/
