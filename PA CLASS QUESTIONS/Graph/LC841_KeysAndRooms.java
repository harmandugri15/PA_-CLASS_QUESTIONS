import java.util.*;

class LC841_KeysAndRooms {
    public void dfs(int curr,List<List<Integer>> rooms,boolean[] visited){
        visited[curr]=true;
        for(int x:rooms.get(curr)){
            if(!visited[x]){
                dfs(x,rooms,visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        dfs(0,rooms,visited);

        for(boolean y:visited){
            if(!y){
                return false;
            }
        }
        return true;
    }
}