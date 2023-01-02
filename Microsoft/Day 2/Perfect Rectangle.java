// Problem : Perfect Rectangle

// Input/Output:
// Input: rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
// Output: true
// Explanation: All 5 rectangles together form an exact cover of a rectangular region.

// Approach: Using Set and Maths 

// Code:

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int area=0;
        Set<String> set = new HashSet<>();
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int ret[] : rectangles){
            int x = ret[0];
            int y = ret[1];
            int a = ret[2];
            int b = ret[3];

            maxA = Math.max(maxA,a);
            maxB = Math.max(maxB,b);
            minX = Math.min(minX,x);
            minY = Math.min(minY,y);

            area+=(x-a)*(y-b);

            String p1 = x+","+y;
            String p2 = x+","+b;
            String p3 = a+","+y;
            String p4 = a+","+b;

            check(set,p1);
            check(set,p2);
            check(set,p3);
            check(set,p4);
        }
        String bleft= minX+","+minY;
        String bright = maxA+","+minY;
        String tleft = minX+","+maxB;
        String tright = maxA+","+maxB;
        if(set.size()!=4 || !set.contains(bleft) || !set.contains(bright) || !set.contains(tleft) || !set.contains(tright)){
            return false;
        }
        int marea = (minX-maxA)*(minY-maxB);
        if(area==marea) return true;
        return false;
    }
    public static void check(Set<String> set, String p){
        if(set.contains(p)) set.remove(p);
        else set.add(p);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
