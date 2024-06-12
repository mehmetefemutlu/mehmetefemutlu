import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList {

    private Node first;

    public LinkedList(){
        this.first = null;
    }

    public Object getFirst(){
        if(first==null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public void addFirst(Object obj){
        Node newNode = new Node();
        newNode.data = obj;
        newNode.next = first;
        first = newNode;
    }

    public Object removeFirst(){
        if(first==null){
            throw new NoSuchElementException();
        }
        Object obj = first.data;
        first = first.next;
        return obj;
    }

    private class Node{
        public Object data;
        public Node next;
    }

    public ListIterator<Object> listIterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements ListIterator<Object>{
        private Node pos;
        private Node prev;
        private boolean isAfterNext;

        public LinkedListIterator(){
            pos = null;
            prev = null;
            isAfterNext = false;
        }

        public Object next(){
            if(!hasNext()){throw new NoSuchElementException();}
            prev = pos;
            isAfterNext = true;
            if(pos==null){pos= first;}
            else{
                pos = pos.next;
            }
            return pos.data;
        }

        public boolean hasNext(){
            if(pos==null){return first!=null;}
            else{return pos.next!=null;}
        }

        public void remove(){
            if(!isAfterNext){throw new IllegalStateException();}
            if(pos==first){
                removeFirst();
            }
            else{
                prev.next = pos.next;
            }
            pos = prev;
            isAfterNext = false;
        }

        public void add(Object element){
            if(pos==null){
                addFirst(element);
                pos = first;
            }
            else{
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = pos.next;
                pos.next = newNode;
                pos = newNode;
                
            }
            isAfterNext = false;
        }

        public void set(Object element){
            if(!isAfterNext){throw new IllegalStateException();}
            pos.data = element; 
        }

        //These methods are for Doubly-Linked Lists
        public int nextIndex(){
            return 0;
        }

        public int previousIndex(){
            return 0;
        }

        public Object previous(){
            return null;
        }

        public boolean hasPrevious(){
            return false;
        }

    }
}
