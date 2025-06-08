//package BFSDFS;
//
//class Node {
//    int data;
//    Node next = null;
//
//    Node(int d) {
//        this.data = d;
//    }
//
//    void append(int d){
//        Node end = new Node(d);
//        Node n = this;
//        while(n.next != null){
//            n = n.next;
//        }
//        n.next = end;
//    }
//
//    void delete(int d){
//        Node n = this;
//        while(n.next != null){
//            if(n.next.data == d){
//                n.next = n.next.next;
//            }else {
//                n = n.next;
//            }
//        }
//    }
//
//    void retrieve() {
//        Node n = this;
//        while(n.next != null){
//            System.out.print(n.data + " -> ");
//            n = n.next;
//        }
//        System.out.println(n.data);
//    }
//}
//
//class LinkedList {
//    Node header;
//
//    static class Node {
//        int data;
//        Node next = null;
//    }
//
//    LinkedList() {
//        header = new Node();
//    }
//
//    void append(int d){
//        Node end = new Node();
//        end.data = d;
//        Node n = header;
//        while(n.next != null){
//            n = n.next;
//        }
//        n.next = end;
//    }
//
//    void delete(int d){
//        Node n = header;
//        while(n.next != null){
//            if(n.next.data == d){
//                n.next = n.next.next;
//            }else {
//                n = n.next;
//            }
//        }
//    }
//
//    void retrieve() {
//        Node n = header;
//        while(n.next != null){
//            System.out.print(n.data + " -> ");
//            n = n.next;
//        }
//        System.out.println(n.data);
//    }
//
//    void removeDups() {
//        Node n = header;
//        while(n.next != null){
//            Node r = n;
//            while(r.next != null){
//                if(n.data == r.next.data){
//                    r.next = r.next.next;
//                } else {
//                    r = r.next;
//                }
//            }
//            n = n.next;
//        }
//    }
//}
//public class SimpleSinglyLinkedList {
//
//    public static void main(String[] args) {
//        Node head = new Node(1);
//        head.append(2);
//        head.append(3);
//        head.append(4);
//        head.retrieve();
//        head.delete(2);
//        head.retrieve();
//
//        LinkedList ll = new LinkedList();
//        ll.append(1);
//        ll.append(2);
//        ll.append(3);
//        ll.append(4);
//        ll.retrieve();
//        ll.delete(1);
//        ll.retrieve();
//
//        ll.append(2);
//        ll.append(3);
//        ll.retrieve();
//        ll.removeDups();
//        ll.retrieve();
//    }
//}
