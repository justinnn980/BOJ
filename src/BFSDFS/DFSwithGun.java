package BFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFSwithGun {
    /// Visited = 이미 방문한 노드 기록용 자료구조
    /// Route = 그래프 탐색 경로 기록
    /// Stack = DFS 로직 구현
    /// vertex = 현재 보는 노드 임시 변수
    // 1. 시작 노드에서 갈 수 있는 곳들을 오른쪽 부터 Stack에 넣는다.
    // 1-1. Stack에 값이 있는가? 1-2. Stack에 pop을 해서 나온값이 Visited에 있는가?
    // 없다면 아래 3가지 진행, 있다면 다시 1-1로
    // 1. route에 추가, 2. visited에 추가, 3. 인접노드를 스택에 담는다.

    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> route = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            System.out.println(stack);


            int vertex = stack.pop();

            if (!visited.contains(vertex)) {
                visited.add(vertex);
                route.add(vertex);


                // 자식 노드를 역순으로 추가
                List<Integer> neighbors = graph.get(vertex);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    stack.push(neighbors.get(i));
                }

                  // 자식 노드를 역순으로 추가
//                List<Integer> neighbors = graph.get(vertex);
//                ListIterator<Integer> iter = neighbors.listIterator(neighbors.size());
//                while (iter.hasPrevious()) {
//                    int neighbor = iter.previous();
//                    stack.push(neighbor);
//                }
            }
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

        List<Integer> result = dfs(graph, 0);
        System.out.println("DFS 경로: " + result);
    }

}
