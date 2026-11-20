import java.util.*;

class LC1971_FindIfPathExistsInGraph {
    public void dfs(List<List<Integer>> graph,int source,int destination,boolean[] visited){
        if(source==destination){
            visited[destination]=true;
            return;
        }
        visited[source]=true;
        for(int i:graph.get(source)){
            if(!visited[i]){
                dfs(graph,i,destination,visited);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // Undirected: add both ways
        }

        boolean[] visited=new boolean[n];
        dfs(graph,source,destination,visited);

        
        return visited[destination];
    }
}