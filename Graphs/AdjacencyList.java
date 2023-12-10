class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>>list=new ArrayList<>();
        
        for(int i=0; i<V; i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int k=0; k<edges.length; k++){
            list.get(edges[k][0]).add(edges[k][1]);
            list.get(edges[k][1]).add(edges[k][0]);
        }
        
        return list;
        
    }
}
