// Problem : Shortest Unsorted Continuous Subarray

// Input/Output:
// Input: nums = [2,6,4,8,10,9,15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

// Approach: Copy Array in another array and sort it now check with from starting and ending of array and return the remaining middle elements size

// Code:

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int dm[] = nums.clone();
        Arrays.sort(dm);
        int i=0, j= nums.length-1;
        while(i<j){
            if(nums[i]==dm[i] && nums[j]==dm[j]){
                i++;
                j--;
            }
            else if(nums[i]==dm[i]){
                i++;
            }
            else if(nums[j]==dm[j]){
                j--;
            }
            else{
                return j-i+1;
            }
        }
        return 0;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)

