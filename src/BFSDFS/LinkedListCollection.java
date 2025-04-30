package BFSDFS;

import java.util.LinkedList;

public class LinkedListCollection {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.addLast(2);
        list.addFirst(3);
        list.add(1,5);
        System.out.println(list);

        list.removeFirst();
    }

}
