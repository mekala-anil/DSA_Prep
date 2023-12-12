
// Using BFS to fill all its connected adjacent cells
// Alternate : we can also use DFS to do it
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
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        getFlood(image, sr, sc, newColor);
        return image;
    }
    private void getFlood(int img[][], int row, int col, int newCol){
        int m=img.length;
        int n=img[0].length;
        boolean vis[][]=new boolean[m][n];
        int color=img[row][col];
        img[row][col]=newCol;
        vis[row][col]=true;
        Queue<Pair>qu=new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        int ar[]={0,-1,0,1};
        int ac[]={-1,0,1,0};
        
        while(!qu.isEmpty()){
            Pair tmp=qu.poll();
            int a=tmp.first;
            int b=tmp.second;
            for(int i=0; i<4; i++){
                int p=a+ar[i];
                int q=b+ac[i];
                if(p<m&&p>=0&&q<n&&q>=0&&img[p][q]==color&&vis[p][q]==false){
                    img[p][q]=newCol;
                    vis[p][q]=true;
                    qu.offer(new Pair(p, q));
                }
            }
        }
    }
}
