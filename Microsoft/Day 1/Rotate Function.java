// Problem : Rotate Function

// Input/Output:
// Input: nums = [4,3,2,6]
// Output: 26
// Explanation:
// F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
// F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
// F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
// F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
// So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

// Approach : Using Math
// step 1: calculate sum and also find F(0)
// Now traverse from back and calculate f(i) and maintain max
// f(i) = f(i) + sum - len*nums[i];

// Code:

class Solution {
    public int maxRotateFunction(int[] nums) {
        int ans=0;
        int sum=0,len = nums.length;
        for(int i=0;i<len;i++){
            sum+=nums[i];
            ans+=(nums[i]*i);
        }
        int max=ans;
        for(int i=len-1;i>=1;i--){
            ans = ans + sum - len*nums[i];
            max = Math.max(ans,max);
        }
        return max;
    }
}


// Time Complexity - O(n)
// Space Complexity - O(1)