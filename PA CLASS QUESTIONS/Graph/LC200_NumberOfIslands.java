class LC200_NumberOfIslands {
    public static void dfs(char[][] grid,int row,int col){
        int n=grid.length;
        int k=grid[0].length;
        if(row<0 || col<0 || row>=n || col>=k || grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);

    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int n=grid.length;
        int k=grid[0].length;
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                if(grid[i][j]=='1'){
                    island++;
                    dfs(grid,i,j);
                }
            }
        }
        return island;
    }
}