class LC130_SurroundedRegions {
    public static void dfs(char[][] board,int row,int col){
        int n=board.length;
        int k=board[0].length;
        if(row<0 || col<0 || row>=n || col>=k || board[row][col]!='O'){
            return;
        }
        board[row][col]='#';
        dfs(board,row+1,col);
        dfs(board,row-1,col);
        dfs(board,row,col+1);
        dfs(board,row,col-1);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int k=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
               boolean onBoundary=(i==0 || j==0 || i==n-1 || j==k-1);
               if(onBoundary && board[i][j]=='O'){
                    dfs(board,i,j);
               }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
}