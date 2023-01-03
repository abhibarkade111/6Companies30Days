// Problem : Minimum Deletions to Make Array Divisible

Input/Output:
// Input: nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]
// Output: 2
// Explanation: 
// The smallest element in [2,3,2,4,3] is 2, which does not divide all the elements of numsDivide.
// We use 2 deletions to delete the elements in nums that are equal to 2 which makes nums = [3,4,3].
// The smallest element in [3,4,3] is 3, which divides all the elements of numsDivide.
// It can be shown that 2 is the minimum number of deletions needed.

// Approach : Using GCD and Sorting
// Step 1) Find the GCD of the numsDivide 
//      2) Now sort the array nums 
//      3) Now travrse the nums array and check whether nums[i]==gcd || gcd%nums[i]==0 ? break loop and return the count : increse the point and also count
//      4) return count==n?-1 : count

// Code:

class Solution {
    public int gcdf(int a, int b) {
     if (b==0) return a;
     return gcdf(b,a%b);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for(int i=0;i<numsDivide.length;i++){
            gcd = gcdf(gcd,numsDivide[i]);
        }
        Arrays.sort(nums);
        int count=0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==gcd){
                break;
            }
            if(gcd%nums[i]==0){
                break;
            }
            if(nums[i]!=gcd){
                count+=1;
            }
        }
        if(count==n){
            return -1;
        }
        else{
            return count;
        }
    }
}

// Time Complexity : O(nlogn)
// Space Complexity : O(1)


