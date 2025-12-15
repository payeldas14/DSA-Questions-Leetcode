//261. Graph Valid Tree - https://leetcode.com/problems/graph-valid-tree/solutions/
//Time Complexity: O(n) and Space Complexity: O(n)
import java.util.*;

class Solution{
    public boolean validTree(int n, int[][] edges){
        //if number of edges is not equal to n-1, then it is not a valid tree, also means there is a cycle in the graph
        if(edges.length != n-1) return false; 

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]); 
            adjList.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        //only sending root node, to only check nodes connected to root
        dfs(0, visited, adjList); 

        //checking if all nodes are visited, if not then it means some nodes were disconnected
        for(boolean v : visited){
            if(!v) return false;
        }
        return true;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int neighbour : adjList.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, adjList);
            }
        }
    }
}