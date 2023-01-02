// Problem : Largest Divisible Subset

// Input/Output:
// Input: nums = [1,2,3]
// Output: [1,2]
// Explanation: [1,3] is also accepted.

// Approach: Dynamic Programming  
// If we sort the array now the problem is converted to the Longest Increasing subsequence patterni.e LIS
// step 1: We initialize dp array of n size and filled with 1 and initialize hash array of size n for trackig the elements back
//      2: Sort the array and Now we using two loops outer from 0 to n and inner o to curent outer and check whether nums[outer]%nums[ineer]==0 if it is then check is values of dp is incersed if it is then we incerse dp value and also add in hash 
//      3: Maintain lastIndex for backtrack 
//      4: Now using hash add it to ans list
//      5: Now sort ans list and return 

// Code:

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int hash[] = new int[n];
        int lastIndex = 0,maxi=1;
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int prev = 0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && dp[prev]+1>dp[i]){
                    dp[i] = dp[prev]+1;
                    hash[i] = prev;
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }
        ans.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        Collections.sort(ans);
        return ans;
    }
}

// Time Complexity : O(n*n)
// Space Complexity : O(n)
