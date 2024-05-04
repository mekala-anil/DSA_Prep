
// Q. Finding Number of Distinct Islands in Graph Using DFS
// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-distinct-islands

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {

    int countDistinctIslands(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       
       boolean vis[][]=new boolean[m][n];
       HashSet<ArrayList<String>>set=new HashSet<>();
       ArrayList<String>list;
       
       for(int i=0; i<m; i++){
           for(int j=0; j<n; j++){
               if(grid[i][j]==1&&vis[i][j]==false){
                   list=new ArrayList<>();
                   dfs(i,j,grid,vis,list,i,j);
                   set.add(list);
               }
           }
       }
       return set.size();
    }
    
    private void dfs(int sr, int sc, int grid[][], boolean vis[][], ArrayList<String>list, int baserow, int basecol){
        int m=grid.length;
        int n=grid[0].length;
        
        vis[sr][sc]=true;
        list.add(Integer.toString(sr-baserow)+" "+Integer.toString(sc-basecol));
        int c1[]={0,-1,0,1};
        int c2[]={-1,0,1,0};
        //char dir[]={'l','u','r','d'};
        
        for(int i=0; i<4; i++){
            int nr=sr+c1[i];
            int nc=sc+c2[i];
            
            if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]==1&&vis[nr][nc]==false){
                //list.add(dir[i]);
                dfs(nr, nc, grid, vis, list, baserow, basecol);
            }
        }
    }
}
