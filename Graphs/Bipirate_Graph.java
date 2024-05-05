// BiPirate Graph Using BFS
// We should not have adjacent node colors equal in Bipirate Graph
// https://www.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph

/*
  1. Do BFS Traversal, 
*/

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        Pair visited[]=new Pair[V];
        for(int i=0; i<V; i++){
            if(visited[i]==null){
                
                if(bfs(i, visited, adj)==false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfs(int n, Pair visited[], ArrayList<ArrayList<Integer>>adj){
        Queue<Integer>q=new ArrayDeque<>();
        visited[n]=new Pair(true, 'g');
        q.offer(n);
        
        while(!q.isEmpty()){
            int node=q.poll();
            
            for(int x:adj.get(node)){
                if(visited[x]==null){
                    visited[x]=new Pair(true, (visited[node].col=='g'?'b':'g'));
                    q.offer(x);
                }
                else if(visited[x].col==visited[node].col){
                    return false;
                }
            }
        }
        
        return true;
    }
}

class Pair{
    boolean vis;
    char col;
    
    Pair(boolean v, char c){
        vis=v;
        col=c;
    }
}
