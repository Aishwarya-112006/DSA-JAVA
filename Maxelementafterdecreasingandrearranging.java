/*You are given an array of positive integers arr. Perform some operations (possibly none) on arr so that it satisfies these conditions:

The value of the first element in arr must be 1.
The absolute difference between any 2 adjacent elements must be less than or equal to 1. In other words, abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed). abs(x) is the absolute value of x.
There are 2 types of operations that you can perform any number of times:

Decrease the value of any element of arr to a smaller positive integer.
Rearrange the elements of arr to be in any order.
Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.*/
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) 
    {
        Arrays.sort(arr);
        int n=arr.length;
        arr[0]=1;
        for(int i=1;i<n;i++){
            arr[i]=Math.min(arr[i],arr[i-1]+1);
        }        
        return arr[n-1];

        
    }
}
/* Dry Run
arr = [2,2,1,2,1]
arr.sort=[1,1,2,2,2]
n=5
arr[0]=1
i--> 1 to  4 (n-1)
i=1 arr[1] = 1
arr=[1,1,2,2,2]
i=2 arr[2]=2
 n-1=2 ans*/
