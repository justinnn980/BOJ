package BFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class BFSwithGun {
    /// Visited = 방문한 노드 기록용 자료구조
    /// Route = BFS의 최종 경로를 담는 자료구조
    /// Queue = BFS 로직에 이용되는 자료구조
    /// vertex = 현재 보는 노드 임시 변수
    // 1. 첫 노드를 Queue와 Visited에 먼저 넣는다.
    // 1-1 Queue에 내용이 있는가? 1-2 Queue에 pop해서 route에 추가
    // 인접한 노드 중 처음보는 친구가 있나? 있다면
    // 1. vertex에 추가 2.큐에 추가
    // 없다면 종료

    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> route = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();  // queue.pop(0) 과 같음
            route.add(vertex);

            List<Integer> neighbors = graph.get(vertex); // 인접한 노드 중 첨보는 친구가 있는가
            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                if (!visited.contains(neighbor)) { // set안에 노드라는 값이 있는지 관련하여 검토 없다면 방문한적 없는 노드이다.
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }

//            for (int neighbor : graph.get(vertex)) {
//                if (!visited.contains(neighbor)) {
//                    visited.add(neighbor);
//                    queue.add(neighbor);
//                }
//            }
            
            System.out.println(queue);
        }

        return route;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2, 4));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(0));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, Arrays.asList(0));
        graph.put(5, Arrays.asList(3));

        List<Integer> result = bfs(graph, 0);
        System.out.println("BFS 경로: " + result);
    }

}
