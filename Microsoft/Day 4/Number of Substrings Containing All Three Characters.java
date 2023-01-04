// Problem : Number of Substrings Containing All Three Characters 

// Input/Output:
// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

// Approach: Using Sliding window 

// Code : 

class Solution {
    public int numberOfSubstrings(String s) {
        int ans=0;
        int ai=-1,bi=-1,ci=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                ai=i;
                if(bi>-1 && ci>-1) ans+= Math.min(bi,ci)+1;
            }
            else if(s.charAt(i)=='b'){
                bi=i;
                if(ai>-1 && ci>-1) ans+=Math.min(ai,ci)+1;
            }
            else{
                ci=i;
                if(ai>-1 && bi>-1) ans+=Math.min(ai,bi)+1;
            }
        }
        return ans;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)