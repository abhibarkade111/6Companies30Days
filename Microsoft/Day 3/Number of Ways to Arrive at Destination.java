// Problem : Number of Ways to Arrive at Destination

// Input/Output:
// Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
// Output: 4
// Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
// The four ways to get there in 7 minutes are:
// - 0 ➝ 6
// - 0 ➝ 4 ➝ 6
// - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
// - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6

// Approach: Djkstra Algorithm

// Code:

class Solution {
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int r[] : roads){
            adj.get(r[0]).add(new int[]{r[1],r[2]});
            adj.get(r[1]).add(new int[]{r[0],r[2]});
        }

        long dist[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        q.offer(new int[]{0,0});
        long mod = 1000000007;
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int distance = q.poll()[1];
            for(int i[] : adj.get(node)){
                if(i[1]+distance<dist[i[0]]){
                    dist[i[0]] = i[1]+distance;
                    ways[i[0]] = ways[node];
                    q.offer(new int[]{i[0], i[1]+distance});
                }
                else if(i[1]+distance==dist[i[0]]){
                    ways[i[0]] = (ways[i[0]]+ways[node])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}

// Time Complexity : O(V+E)
// Space Complexity :