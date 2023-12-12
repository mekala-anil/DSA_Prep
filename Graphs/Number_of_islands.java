class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int iLands=0;
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'&&vis[i][j]==false){
                    getLand(grid, vis, i, j);
                    iLands++;
                }
            }
        }
        return iLands;
    }
    void getLand(char[][] grid, boolean vis[][], int row, int col){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=true;
        Queue<Pair>qu=new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        while(!qu.isEmpty()){
            Pair tmp=qu.poll();
            int a=tmp.first;
            int b=tmp.second;
            for(int i=-1; i<2; i++){
                for(int j=-1; j<2; j++){
                    int p=a+i;
                    int q=b+j;
                    if(p<n&&p>=0&&q<m&&q>=0&&grid[p][q]=='1'&&vis[p][q]==false){
                        vis[p][q]=true;
                        qu.offer(new Pair(p, q));
                    }
                }
            }
        }
    }
}
