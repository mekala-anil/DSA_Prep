/* Distance of a nearest cell having 1
Used BFS Approach to mark all adjacent cells
*/
class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution
{
    
    public int[][] nearest(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        
        int ans[][]=new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0){
                    getNearest(grid, ans, i, j);
                }else{
                    ans[i][j]=0;
                }
            }
        }
        return ans;
    }
    
    void getNearest(int grid[][], int ans[][], int r, int c){
        int n=grid.length;
        int m=grid[0].length;
        
        Queue<Pair>qu=new ArrayDeque<>();
        qu.offer(new Pair(r, c));
        int ar[]={-1,0,0,1};
        int ac[]={0,-1,1,0};
        while(!qu.isEmpty()){
            Pair tmp=qu.poll();
            int a=tmp.first;
            int b=tmp.second;
            for(int i=0; i<4; i++){
                int p=a+ar[i];
                int q=b+ac[i];
                if(p<n&&p>=0&&q<m&&q>=0){
                    if(grid[p][q]==1){
                        int dr=r-p;
                        int dc=c-q;
                        dr=(dr<0)?(dr*(-1)):dr;
                        dc=(dc<0)?(dc*(-1)):dc;
                        ans[r][c]=dr+dc;
                        return;
                    }else{
                        qu.offer(new Pair(p,q));
                    }
                }
            }
        }
    }
}
