//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph

// Using DFS


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V];
        for(int i=0; i<V; i++){
            if(vis[i]==false){
                if(detectCycle(i, -1, vis, adj)==true){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean detectCycle(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        
        for(int x:adj.get(node)){
            if(vis[x]==false){
                // return detectCycle(x, node, vis, adj);
                if(detectCycle(x, node, vis, adj)==true){
                    return true;
                }
            }
            else if(x!=parent){
                return true;
            }
        }
        
        return false;
    }
}
