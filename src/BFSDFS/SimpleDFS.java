//package BFSDFS;
//
//import java.util.*;
//import java.util.LinkedList;
//
//class Graph {
//
//    private Map<Integer, Node> nodes = new HashMap<>();
//
//    // Node 클래스
//    private static class Node {
//        int id;
//        List<Node> neighbors;
//
//        Node(int id) {
//            this.id = id;
//            neighbors = new ArrayList<>();
//        }
//
//        void addNeighbor(Node neighbor) {
//            neighbors.add(neighbor);
//        }
//    }
//
//    // 노드 추가
//    public void addNode(int id) {
//        nodes.putIfAbsent(id, new Node(id));
//    }
//
//    // 간선 추가 (양방향)
//    public void addEdge(int fromId, int toId) {
//        Node from = nodes.get(fromId);
//        Node to = nodes.get(toId);
//        if (from != null && to != null) {
//            from.addNeighbor(to);
//            to.addNeighbor(from); // 양방향
//        }
//    }
//
//    // DFS 구현 (Stack 사용)
//    public void dfs(int startId) {
//        Set<Integer> visited = new HashSet<>();
//        Stack<Node> stack = new Stack<>();
//        Node start = nodes.get(startId);
//        if (start == null) return;
//
//        stack.push(start);
//
//        while (!stack.isEmpty()) {
//            Node current = stack.pop();
//            if (!visited.contains(current.id)) {
//                visited.add(current.id);
//                System.out.print(current.id + " ");
//
//                // 이웃 노드를 스택에 추가 (정렬하면 순서 조절 가능)
//                for (int i = current.neighbors.size() - 1; i >= 0; i--) {
//                    Node neighbor = current.neighbors.get(i);
//                    if (!visited.contains(neighbor.id)) {
//                        stack.push(neighbor);
//                    }
//                }
//            }
//        }
//        System.out.println();
//    }
//
//    // BFS 구현 (Queue 사용)
//    public void bfs(int startId) {
//        Set<Integer> visited = new HashSet<>();
//        LinkedList<Object> queue = new LinkedList<>();
//        Node start = nodes.get(startId);
//        if (start == null) return;
//
//        queue.add(start);
//        visited.add(start.id);
//
//        while (!queue.isEmpty()) {
//            Node current = (Node) queue.poll();
//            System.out.print(current.id + " ");
//
//            for (Node neighbor : current.neighbors) {
//                if (!visited.contains(neighbor.id)) {
//                    visited.add(neighbor.id);
//                    queue.add(neighbor);
//                }
//            }
//        }
//        System.out.println();
//    }
//
//    // 테스트 메인 함수
//    public static void main(String[] args) {
//        Graph graph = new Graph();
//        for (int i = 1; i <= 5; i++) {
//            graph.addNode(i);
//        }
//
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 4);
//        graph.addEdge(3, 5);
//
//        System.out.println("DFS:");
//        graph.dfs(1);
//
//        System.out.println("BFS:");
//        graph.bfs(1);
//    }
//}
