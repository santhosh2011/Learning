// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;


class StackQueue<T> {
    
    
    private Stack<T> reverse;
    private Stack<T> straight;
    
    public StackQueue(){
        this.reverse = new Stack<T>();
        this.straight = new Stack<T>();
    }
    
    void enqueue(T t){
        this.reverse.push(t);
    }
    
    T dequeue(){
        if(this.straight.size()==0){
            if(this.reverse.isEmpty()){
                return null;
            }
            while(!this.reverse.isEmpty()){
                this.straight.push(this.reverse.pop());
            }
            
        }
        
        return this.straight.pop();
    }
    
    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue<Integer>();
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
