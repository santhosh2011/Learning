// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;


class NodeQueue<T> {
    
    class Node{
        T t;
        Node next;
        
        public Node(T t){
            this.t=t;
        }
    }
    
    private Node root;
    private Node tail;
    
    private int size;
    
    public Queue(){
        this.size = 0;
    }
    
    void enqueue(T t){
        Node current = new Node(t);
        if(this.root==null){
            this.root = current;
            this.tail = current;
        }else{
            this.tail.next = current;
            this.tail = this.tail.next;
        }
        size++;
    }
    
    T dequeue(){
        if(this.size==0){
            return null;
        }
        Node current = this.root;
        this.root = this.root.next;
        this.size--;
        return current.t;
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(1==queue.dequeue());
        System.out.println(2==queue.dequeue());
        queue.enqueue(4);
        System.out.println(3==queue.dequeue());
        System.out.println(4==queue.dequeue());
         System.out.println(null==queue.dequeue());
    }
}
