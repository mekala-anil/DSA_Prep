// https://www.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[]=new int[V];
        for(int i=0; i<V; i++){
            color[i]=-1;
        }
        
        for(int i=0; i<V; i++){
            if(color[i]==-1){
                if(dfs(i, 0, color, adj)==false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>>adj){
        color[node]=1-col;
        for(int x:adj.get(node)){
            
            if(color[x]==-1){
                if(dfs(x, 1-col, color, adj)==false){
                    return false;
                }
            }
            else if(color[x]==color[node]){
                return false;
            }
        }
        return true;
    }
}
