//210. Course Schedule II - https://leetcode.com/problems/course-schedule-ii/description/
//Time Complexity: O(V + E) and Space Complexity: O(V + E)
import java.util.*;

class Solution {
    HashMap<Integer, List<Integer>> graph;
    HashSet<Integer> visited;      // recursion stack
    List<Integer> order;           // NEW → to store the topological order

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        graph = new HashMap<>();
        visited = new HashSet<>();
        order = new ArrayList<>();

        // build adjacency list exactly like your version
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
        }

        // run DFS for all courses
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course))
                return new int[0];     // cycle found → no valid order
        }

        // reverse because DFS adds post-order
        Collections.reverse(order);

        // convert to array
        int[] result = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    private boolean dfs(int course) {

        // if course already explored completely → safe to use
        if (graph.get(course) == null) {
            if (!order.contains(course))   // ensure not added twice
                order.add(course);
            return true;
        }

        // if in recursion stack → cycle
        if (visited.contains(course))
            return false;

        visited.add(course);

        for (int next : graph.get(course)) {
            if (!dfs(next))
                return false;
        }

        visited.remove(course);

        // mark the course as fully processed
        graph.put(course, null);

        // ADD to topological order
        order.add(course);

        return true;
    }
}