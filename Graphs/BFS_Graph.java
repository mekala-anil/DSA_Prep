// BFS of a Directed Graph in AdjacencyList Representation

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer>ans=new ArrayList<>();
        Queue<Integer>q=new ArrayDeque<>();
        boolean[] vis=new boolean[V];
        q.offer(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int tmp=q.poll();
            ans.add(tmp);
            for(int x:adj.get(tmp)){
                if(vis[x]==false){
                    q.offer(x);
                    vis[x]=true;
                }
            }
        }
        return ans;
    }
}
