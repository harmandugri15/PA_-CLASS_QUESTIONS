class LC695_MaxAreaOfIsland {
    public static int dfs(int[][] grid,int row,int col){
        int n=grid.length;
        int k=grid[0].length;
        if(row>=n || col>=k || row<0 || col<0 || grid[row][col]==0){
            return 0;
        }
        grid[row][col]=0;
        return 1+dfs(grid,row+1,col) + dfs(grid,row-1,col)+ dfs(grid,row,col+1)+ dfs(grid,row,col-1); 

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int k=grid[0].length;
        int currArea=0;
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                if(grid[i][j]==1){
                    currArea=dfs(grid,i,j);
                    maxArea=Math.max(currArea,maxArea);
                }
            }
        }
        return maxArea;
    }
}