// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;


class GenericQueue<T> {
    
    private List<T> list;
    
    public GenericQueue(){
        this.list = new LinkedList<T>();
    }
    
    void enqueue(T t){
        list.add(t);
    }
    
    T dequeue(){
        if(list.size()==0){
            return null;
        }
        T current = list.get(0);
        
        list.remove(current);
        return current;
    }
    
    public static void main(String[] args) {
        GenericQueue<Integer> queue = new GenericQueue<Integer>();
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
