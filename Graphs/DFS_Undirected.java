class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer>ans=new ArrayList<>();
        boolean vis[]=new boolean[V];
        dfs(0, adj, ans, vis);
        return ans;
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean vis[]){
        ans.add(node);
        vis[node]=true;
        for(int x:adj.get(node)){
            if(vis[x]==false){
                dfs(x, adj, ans, vis);
            }
        }
    }
}
