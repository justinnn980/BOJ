package BFSDFS;

import org.w3c.dom.Node;

public class SinglyLinkedList<E> {
    private Node<E> head; /// 노드의 첫 부분을 가리키는 포인트
    private Node<E> tail; /// 노드의 마지막 부분을 가리키는 포인트

    private int size; /// 요소의 갯수

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E item; /// Node에 담을 데이터
        private Node<E> next; /// 다음 Node 객체를 가르키는 레퍼런스

        /// 생성자
        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> search(int index) {
        /// head(처음위치) 서부터 차례로 index 까지 검색
        Node<E> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next; /// next 필드의 값(다음 노드 주소)를 재대입하면서 순차적으로 요소를 탐색
        }
        return n;
    }

    private void addFirst(E value) {
        /// 1. 먼저 가장 앞의 요소를 가져옴
        Node<E> first = head;

        /// 2. 새 노드 생성 (이때 데이터와 next 포인트를 준다)
        Node<E> newNode = new Node<E>(value, first);

        /// 3. 요소가 추가되었으니 size를 늘린다.
        size++;

        /// 4. 맨앞에 요소가 추가되었으니 head를 업데이트 한다.
        head = newNode;

        /// 5. 만일 최초로 요소가 add된 것이면 head와 tail이 가리키는 요소는 같게 된다.
        if (first == null) {
            tail = newNode;
        }

    }

    public void addLast(E value) {

    }
    public static void main(String[] args) {

    }

}
