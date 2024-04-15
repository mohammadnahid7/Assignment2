public class LinkedQueueOfStrings {
    public Node first = null;
    public Node last = null;

    public static class Node {
        String item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void push(String s){
        Node newItem = new Node();
        if(first == null){
            first = new Node();
            first.item = s;
            last = first;
        }else{
            newItem.item = s;
            last.next = newItem;
            last = newItem;
        }

    }
    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }
}
