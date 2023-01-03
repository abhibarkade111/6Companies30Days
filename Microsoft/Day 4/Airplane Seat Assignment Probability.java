// Problem : Airplane Seat Assignment Probability

// Input/Output:
// Input: n = 2
// Output: 0.50000
// Explanation: The second person has a probability of 0.5 to get the second seat (when first person gets the first seat).

// Approach:
// The probability that the nth person gets his own seat is 1/2 because nth person will randomly sit on any seat(say 3) and the seat 3 person will only find nth seat empty bacause others will sit on their respective places.So there are 2 choices for nth person
// Sit on nth seat in which case 3rd person will surely sit on his seat.
// Sit on 3rd seat in which case 3rd person will surely not sit on his seat.

// Code:

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        return n==1?1:0.5;
    }
}

// Time Complexity : O(1)
// Space Complexity : O(1)