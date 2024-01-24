// https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Graph/problem/find-whether-path-exist5238

class Pair{
    int i, j;
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}

class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        Queue<Pair>q=new ArrayDeque<>();
        int m=grid.length;
        int n=grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    q.offer(new Pair(i, j));
                    break;
                }
            }
        }
        int ar[]={0,-1,0,1};
        int ac[]={-1,0,1,0};
        while(!q.isEmpty()){
            Pair tmp=q.poll();
            int r=tmp.i;
            int c=tmp.j;
            for(int i=0; i<4; i++){
                int nr=r+ar[i];
                int nc=c+ac[i];
                if(nr<m&&nr>=0&&nc<n&&nc>=0){
                    if(grid[nr][nc]==2){
                        return true;
                    }else if(grid[nr][nc]==3){
                        q.offer(new Pair(nr, nc));
                    }
                }
            }
            
        }
        return false;
    }
}
