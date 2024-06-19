// Q:https://www.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int indegree[]=new int[V];
        int top[]=new int[V];
        Queue<Integer>queue=new ArrayDeque<>();
        
        for(int i=0; i<V; i++){
            
            for(int x:adj.get(i)){
                indegree[x]++;
            }
        }
        
        for(int i=0; i<V; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int i=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            top[i++]=node;
            for(int x:adj.get(node)){
                indegree[x]--;
                if(indegree[x]==0){
                    queue.offer(x);
                }
            }
        }
        
        return top;
        
    }
}
