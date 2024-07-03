// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class EfficientPackage {
    
    
    /**
     * Evaluates the minimum of max container that can ship the package in given days
     * uses Binary search -> search space.
     * 
     * Time Complexity = O(N*log(K)) -> K = search space max value is Integer.MAX_VALUE;
     * 
     */
    public int getMinMaxContainer(int[] packages, int days){
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
     * Validates if we can pack all the packages in the given number of days 
     * with the given container
     * return true when possible else false;
     * 
     * Time Complexity -> O(N) -> sizeof array
     * 
     * alternative approach is to use greedy for optimise storage
     * 
     */
    private boolean validContainer(int[] packages, int days, int containerSize){ 
        int sum = 0;
        int currentDays = 0;
        for(int i=0;i<packages.length;i++){
            if(packages[i]>containerSize){
                return false;
            }
            sum += packages[i];
            if(sum > containerSize){
                currentDays++;
                sum = packages[i];
            
            }
        }
        currentDays++;
        return currentDays<=days;
        
    }
    
    
    
    public static void main(String[] args) {
        EfficientPackage ser = new EfficientPackage();

        System.out.println(ser.getMinMaxContainer(new int[]{1,2,3,4,5,6,7,8,9,10}, 1)==55);
        System.out.println(ser.getMinMaxContainer(new int[]{1,2,3,4,5,6,7,8,9,10}, 8)==10);
        System.out.println(ser.getMinMaxContainer(new int[]{1,2,3,4,5,6}, 3)==9);
        
    }
}
