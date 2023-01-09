// Problem : Factorial Trailing Zeroes

// Input/Output:
// Input: n = 3
// Output: 0
// Explanation: 3! = 6, no trailing zero.

// Approach : Using Maths
// Here Value of N is too big so we are unable to find the factorial of int because it goes out of range 
// So we here use maths approach
// As we know that the factorial of 5 having one leading zero ans same for 10 having two leading zeroes 
// Now for calculating the leading zeroe we know that zero will be ocuured when any even number is multiplied by the 5 and any number is multiplied 10 
// So we calculate
// p=5 and ans=0 and ans+=(n/p) and p=p*5

// Code : 

class Solution {
    public int trailingZeroes(int n) {
        int ans=0;
        int p = 5;
        while((n/p)>0){
            ans+=(n/p);
            p=p*5;
        }
        return ans;
    }
}

// Time Complexity : O(log5)
// Space Complexity :  O(1)


