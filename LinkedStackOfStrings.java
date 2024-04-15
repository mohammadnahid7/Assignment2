public class LinkedStackOfStrings {
    private Node first = null;

    public static class Node {
        String item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void push(String s){
        Node oldFirst = first;
        first = new Node();
        first.item = s;
        first.next = oldFirst;
    }
    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }
    public Node getFirst(){
        return first;
    }
}
