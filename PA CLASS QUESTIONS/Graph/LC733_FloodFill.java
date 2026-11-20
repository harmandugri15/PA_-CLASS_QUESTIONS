class LC733_FloodFill {
    public static void dfs(int[][] image,int row,int col,int c,int changedcolor){
        if(row<0 || row>=image.length || col<0|| col>=image[0].length || image[row][col]!=c){
            return;
        }
        image[row][col]=changedcolor;
        dfs(image,row+1,col,c,changedcolor);
        dfs(image,row-1,col,c,changedcolor);
        dfs(image,row,col+1,c,changedcolor);
        dfs(image,row,col-1,c,changedcolor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        else{
            dfs(image,sr,sc,image[sr][sc],color);
            return image;
        }
    }
}