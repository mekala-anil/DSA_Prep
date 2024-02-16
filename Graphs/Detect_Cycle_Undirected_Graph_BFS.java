class Pair{
    int node;
    int parent;
    
    Pair(int n, int p){
        node=n;
        parent=p;
    }
}

class Solution {
    
    private boolean checkCyclic(int src, int V, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        Queue<Pair>q=new ArrayDeque<>();
        q.offer(new Pair(src, -1));
        vis[src]=true;
        while(!q.isEmpty()){
            int node=q.peek().node;
            int parent=q.peek().parent;
            q.poll();
            
            for(int x:adj.get(node)){
                
                if(vis[x]==false){
                    vis[x]=true;
                    q.offer(new Pair(x, node));
                }
                else if(x!=parent)
                {
                    return true;
                }
            }
        }
        return false;
        
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V];
        for(int i=0; i<V; i++){
            if(vis[i]==false){
                if(checkCyclic(i, V, vis, adj)==true){
                return true;
                }
            }
            
        }
        
        return false;
        
    }
}
