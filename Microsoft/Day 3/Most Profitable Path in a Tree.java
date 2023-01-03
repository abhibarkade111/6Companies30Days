// Problem : Most Profitable Path in a Tree

// Input/Output:
// Input: edges = [[0,1],[1,2],[1,3],[3,4]], bob = 3, amount = [-2,4,2,-4,6]
// Output: 6
// Explanation: 
// The above diagram represents the given tree. The game goes as follows:
// - Alice is initially on node 0, Bob on node 3. They open the gates of their respective nodes.
//   Alice's net income is now -2.
// - Both Alice and Bob move to node 1. 
//   Since they reach here simultaneously, they open the gate together and share the reward.
//   Alice's net income becomes -2 + (4 / 2) = 0.
// - Alice moves on to node 3. Since Bob already opened its gate, Alice's income remains unchanged.
//   Bob moves on to node 0, and stops moving.
// - Alice moves on to node 4 and opens the gate there. Her net income becomes 0 + 6 = 6.
// Now, neither Alice nor Bob can make any further moves, and the game ends.
// It is not possible for Alice to get a higher net income.

// Approach: Using DFS and BFS 
// Intially create a adjancy list of graph
// Now do DFS to find the path of the bob and time for reaching the node
// Ṇow Do BFS and find the income according who reach first and other conditions given in the question

// Code:

class Solution {
    static class Edge{
        int vtc;
        int nbr;
        int amt;
        Edge(int vtc, int nbr, int amt){
            this.vtc=  vtc;
            this.nbr = nbr;
            this.amt = amt;
        }
    }

    static class Pair{
        int node;
        int time;
        int income;
        Pair(int node, int time, int income){
            this.node = node;
            this.time = time;
            this.income = income;
        }
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0;i<amount.length;i++){
            graph.add(new ArrayList<>());
        }

        for(int e[] : edges){
            graph.get(e[0]).add(new Edge(e[0],e[1],amount[e[0]]));
            graph.get(e[1]).add(new Edge(e[1],e[0],amount[e[1]]));
        }

        boolean vis[] = new boolean[amount.length];

        HashMap<Integer,Integer> hm = new HashMap<>();
        dfs(graph, bob, 0, hm, 0, vis);

        int ans = Integer.MIN_VALUE;

        vis = new boolean[amount.length];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            vis[node] = true;
            int time = p.time;
            int income = p.income;
            if(hm.get(node)==null){
                income+=amount[node];
            }
            else{
                if(time<hm.get(node)){
                    income+=amount[node];
                }
                else if(time==hm.get(node)){
                    income+=(amount[node]/2);
                }
                else{
                    income+=0;
                }
            }
            if(node!=0 && graph.get(node).size()==1){
                ans = Math.max(ans,income);
            }

            for(Edge e : graph.get(node)){
                if(!vis[e.nbr]) q.offer(new Pair(e.nbr, time+1, income));
            }
        }
        return ans;
    }

    public boolean dfs(ArrayList<ArrayList<Edge>> graph, int src, int dest, HashMap<Integer,Integer> hm, int time, boolean vis[]){
        hm.put(src,time);
        if(src==dest) return true;
        vis[src] = true;
        for(Edge e : graph.get(src)){
            if(!vis[e.nbr]){
                if(dfs(graph,e.nbr, dest, hm, time+1,vis)){
                    return true;
                }
            }
        }
        hm.remove(src);
        return false;
    }
} 

// Time Complexity: O(2(V+E))
// Space Complexyty: 