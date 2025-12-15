//323. Number of Connected Components in an Undirected Graph - https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
//Time Complexity: O(V + E) and Space Complexity: O(V + E) for adjacency list + O(V) for visited array
import java.util.*;

class Solution{
    public int countComponents(int n, int[][] edges){
        int count = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(adjList, visited, i);
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> adjList, boolean[] visited, int node){
        visited[node] = true;

        for(int neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                dfs(adjList, visited, neighbor);
            }
        }
    }
}