//Graph BFS & DFS - https://leetcode.com/problems/graph-bfs-dfs/
// BFS Time Complexity: O(V + E) and Space Complexity: O(V + E) for adjacency list, O(V) for visited array
// DFS Time Complexity: O(V + E) and Space Complexity: O(V + E) for adjacency list, O(V) for visited array

import java.util.*;

class Graph{
    int V;
    List<List<Integer>> adj;

    Graph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0; i < V; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        // undirected graph
        adj.get(v).add(u);
    }

    public static void BFS(Graph graph, int start){
        boolean[] visited = new boolean[graph.V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");

            for(int neighbor : graph.adj.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void DFS(Graph graph, int start){
        boolean[] visited = new boolean[graph.V];
        dfsHelper(graph, visited, start);
    }

    private static void dfsHelper(Graph graph, boolean[] visited, int node){
        visited[node] = true;

        System.out.print(node + " ");

        for(int neighbor : graph.adj.get(node)){
            if(!visited[neighbor]){
                dfsHelper(graph, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("BFS Traversal: ");
        BFS(graph, 0);
        System.out.println();

        System.out.println("DFS Traversal: ");
        DFS(graph, 0);
        System.out.println();
    }
}

//OUTPUT
//BFS Traversal: 0 1 2 3 4
//DFS Traversal: 0 1 3 4 2

//Graph Structure
//        0
//       / \
//      1   2
//     / \ /
//    3  4