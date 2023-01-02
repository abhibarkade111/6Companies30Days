// Problem : Course Schedule
 
// Input/Output:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.

// Approach : Using DFS  
// If we carefully observe this problem then the problem is similar to the "Detect cycle in directed graph"
// i.e if cycle is present then return false else return true
// We know than that we can detect cycle using DFS or BFS of the graph

// Code:

class Solution {
    public boolean detect(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean dfsVis[]){
        vis[node]=  true;
        dfsVis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                if(detect(i,adj,vis,dfsVis)) return true;
            }
            else if(dfsVis[i]){
                return true;
            }
        }
        dfsVis[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : prerequisites){
            adj.get(i[0]).add(i[1]);
        }
        
        boolean vis[]= new boolean[numCourses];
        boolean dfsVis[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(detect(i,adj,vis,dfsVis)) return false;
            }
        }
        return true;
    }
}

// Time Complexity : O(V+E)
// Space Complexity : O(V+E)

