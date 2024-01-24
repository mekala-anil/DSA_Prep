// Q: https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Graph/problem/rotten-oranges2536

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
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        Queue<Pair>q=new ArrayDeque<>();
        int m=grid.length;
        int n=grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }
            }
        }
        
        int ar[]={0,-1,0,1};
        int ac[]={-1,0,1,0};
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                Pair tmp=q.poll();
                int r=tmp.first;
                int c=tmp.second;
                
                for(int p=0; p<4; p++){
                    int nr=r+ar[p];
                    int nc=c+ac[p];
                    if(nr<m&&nr>=0&&nc<n&&nc>=0&&grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.offer(new Pair(nr, nc));
                    }
                }
            }
            // If existing oranges rottens any orange then it will keep in queue and if queue empty then existed oranges didn't rotten any orange
            if(!q.isEmpty()){            
                count++;
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        
        
        return count;
    }
}
