// Q. Find Cycle in Directed Graph
//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph
/* Algo
  1. Use DFS Traversal but cant find cycle as undirected graph, we need to store path
  2. Use a HashSet to store Path of directed graph and maintain visited array bcz we may have components
  3. Traverse for 0 to V, as component wise using visited array
  4. Store node in hashset and do DFS of its child nodes
  5. if we find any node which is available in path(HashSet) then return as true and cycle detected
  6. if not available in path then repeated DFS of its child nodes and check for visited or not as well bcz no need to check again
  **7. Make sure while returning from path, delete that node from path
  8. if we dont find any cycle then return false

  Note: we can also use pathVisited[] array as well, Instead of hashset
  
  
*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        HashSet<Integer>hs=new HashSet<>();
        
        boolean vis[]=new boolean[V];
        
        for(int i=0; i<V; i++){
            if(vis[i]==false){
                if(getCycle(i, adj, hs, vis)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    private boolean getCycle(int node, ArrayList<ArrayList<Integer>> adj, HashSet<Integer>hs, boolean vis[]){
        hs.add(node);
        vis[node]=true;
        
        for(int x:adj.get(node)){
            
            if(hs.contains(x)){
                return true;
            }else{
                if(vis[x]==false&&getCycle(x, adj, hs, vis)){
                    return true;
                }
            }
        }
        hs.remove(node);
        return false;
    }
}
