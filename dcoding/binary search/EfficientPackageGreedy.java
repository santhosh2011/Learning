// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class EfficientPackageGreedy {
    
    
    /**
     * Evaluates the minimum of max container that can ship the package in given days
     * uses Binary search -> search space.
     * 
     * Time Complexity = O(N*log(K)) -> K = search space max value is Integer.MAX_VALUE;
     * 
     */
    public int getMinMaxContainer(int[] packages, int days){
        Arrays.sort(packages);
        int searchSpace = 0;
        for(int pack : packages){
            searchSpace += pack;
        }
        int left = 1; 
        int right = searchSpace;
        while(left<right){
            int mid = left + (right-left)/2;
            if(this.validContainer(packages,days, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    /**
     * Validates if we can pack all the packages in the given number of containers 
     * with the given container size
     * return true when possible else false;
     * 
     * Time Complexity -> O(N) -> sizeof array
     * 
     * 
     */
    private boolean validContainer(int[] packages, int maxContainers, int containerSize){ 
        if(packages.length==0|| packages[packages.length-1]>containerSize){
                return false;
        }
        PriorityQueue<Integer> remaining = new PriorityQueue<Integer>(Collections.reverseOrder());
        int containers = 0;
        for(int i=packages.length-1;i>=0;i--){
            if(remaining.size()>0 && remaining.peek()>=packages[i]){
                int size = remaining.poll() - packages[i];
                if(size!=0){
                    remaining.add(size);
                }
            }else{
                containers++;
                if(containerSize-packages[i]>0){
                    remaining.add(containerSize-packages[i]);
                }
            }
        }
        return containers<=maxContainers;
        
    }
    
    
    
    public static void main(String[] args) {
        EfficientPackageGreedy ser = new EfficientPackageGreedy();

        System.out.println(ser.getMinMaxContainer(new int[]{1,2,3,4,5,6,7,8,9,10}, 1)==55);
        System.out.println(ser.getMinMaxContainer(new int[]{1,2,3,4,5,6,7,8,9,10}, 8)==10);
        System.out.println(ser.getMinMaxContainer(new int[]{1,2,3,4,5,6}, 3)==7);
        
    }
}
