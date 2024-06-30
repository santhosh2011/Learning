// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;


class ArrayQueue<T> {
    
    
    private T[] arr;
    private int size;
    private int start;
    private int end;
    
    public ArrayQueue(){
        this.arr = (T[])new Object[1];
        this.size = 0;
        this.start =0;
        this.end=0;
    }
    
    void enqueue(T t){
        if(this.size>0 && this.start==this.end){
            T[] extendedArray = (T[]) new Object[2*this.size];
            int i=0;
            while(i<this.size){
                this.start%=this.arr.length;
                extendedArray[i]= this.arr[this.start];
                this.start++;
                i++;
            }
            this.arr = extendedArray;
        }
        
        this.arr[start++] = t;
        this.start%=this.arr.length;
        this.size++;
    }
    
    T dequeue(){
        if(this.size==0){
                return null;
        }
        T result = this.arr[this.end++];
        this.end%= this.arr.length;
        this.size--;
        return result;
    }
    
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
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
