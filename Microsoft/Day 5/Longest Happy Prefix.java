// Problem : Longest Happy Prefix

// Input/Output:
// Input: s = "level"
// Output: "l"
// Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".

// Approach: Using Two Pointer and KMP Algorithms

// Code:

class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int lps[] = new int[n];
        int j=0;
        for(int i=1;i<n;i++){
            while(j>0 && s.charAt(i)!=s.charAt(j)){
                j = lps[j-1];
            }
            if(s.charAt(i)==s.charAt(j)) j++;
            lps[i] = j;
        }
        return s.substring(0,lps[n-1]);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)