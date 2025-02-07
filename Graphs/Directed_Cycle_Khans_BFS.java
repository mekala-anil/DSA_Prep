
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int indeg[]=new int[adj.size()];
        for(int i=0; i<adj.size();i++){
            for(int x:adj.get(i)){
                indeg[x]++;
            }
        }
        Queue<Integer>queue=new ArrayDeque<>();
        for(int i=0; i<adj.size(); i++){
            if(indeg[i]==0){
                queue.offer(i);
            }
        }
        ArrayList<Integer>topo=new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.poll();
            topo.add(node);
            for(int x:adj.get(node)){
                indeg[x]--;
                if(indeg[x]==0){
                    queue.offer(x);
                }
            }
            
        }
        if(topo.size()<adj.size()){
            return true;
        }else{
            
            return false;
        }
            
    }
}
