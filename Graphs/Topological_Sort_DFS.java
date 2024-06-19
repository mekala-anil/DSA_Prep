
/* Q: https://www.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort
*/

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int top[]=new int[V];
        boolean vis[]=new boolean[V];
        Stack<Integer>stack=new Stack<>();
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, adj, vis, stack);
            }
        }
        
        int i=0;
        while(!stack.isEmpty()){
            top[i]=stack.pop();
            i++;
        }
        return top;
    }
    
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], Stack<Integer>stack){
        vis[node]=true;
        for(int x:adj.get(node)){
            if(!vis[x]){
                dfs(x, adj, vis, stack);
            }
        }
        stack.push(node);
    }
}
