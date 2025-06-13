package BFSDFS;

import java.util.*;

public class DFSwithGunRe {
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> route = new ArrayList<>();
        dfsRecursive(graph, start, visited, route);
        return route;
    }

    private static void dfsRecursive(Map<Integer, List<Integer>> graph, int now, Set<Integer> visited, List<Integer> route) {
        if (visited.contains(now)) {
            return;
        }

        visited.add(now);
        route.add(now);

        List<Integer> neighbours = graph.get(now);
        if (neighbours != null) {
            for (int neighbour : neighbours) {
                dfsRecursive(graph, neighbour, visited, route);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2, 4));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(0));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, Arrays.asList(0));
        graph.put(5, Arrays.asList(3));

        List<Integer> result = dfs(graph, 0);
        System.out.println("DFS 경로: " + result);
    }
}
