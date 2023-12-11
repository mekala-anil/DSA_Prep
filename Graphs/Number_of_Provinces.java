// Finding No. of provinces in a Graph
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> ad, int V) {
        int provinces=0;
        // Created Empty Adjacency List
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<Integer>());
        }
        // Converted Matrix to List
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(ad.get(i).get(j)==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        boolean vis[]=new boolean[V];
        
        for(int i=0; i<V; i++){
            if(vis[i]==false){
                dfs(i, adj, vis);
                provinces++;
            }
        }
        return provinces;
    }
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        vis[node]=true;
        for(int x:adj.get(node)){
            if(vis[x]==false){
                dfs(x, adj, vis);
            }
            
        }
    }
}
