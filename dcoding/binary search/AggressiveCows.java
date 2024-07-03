/*
 Given a sorted array arr[] consisting of N integers which denote the position of a stall. 
 You are also given an integer K which denotes the number of aggressive cows. 

 You are given the task of assigning stalls to K cows such that the minimum distance between any two of them is the maximum possible.

 Input: N = 5, K = 3, arr[] = {1, 2, 4, 8, 9}
 Output: 3
 Explanation: 
   We can place cow 1 at position 1, 
   cow 2 at position 4 and 
   cow 3 at position 9. 
   So, the maximum possible minimum distance between two cows is 3.


 Input: N = 6, K = 4, arr[] = {6, 7,  9, 11, 13, 15}
 Output: 2
 Explanation: 
   We can place cow 1 at position 6, 
   cow 2 at position 9 and 
   cow 3 is placed at position 11 or 13
   cow 4 at position 15. 
   So, the maximum possible minimum distance between two cows is 2.

*/

class AggressiveCows {
    
    /**
     * Evaluates the maximum of minimum distance between the aggressive cows 
     * uses Binary search -> search space.
     * 
     * Time Complexity = O(N*log(K)) -> K = search space max value is Integer.MAX_VALUE;
     * 
     */
    public int getMaxMinDistance(int[] stalls, int cows){
        int left = 1; 
        int right = stalls[stalls.length-1]-stalls[0]+1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(!this.validDistance(stalls, mid, cows)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left-1;
    }

  
    /**
     * Validates if there is a possibility of placing cows 
     * with the given distance
     * return true when possible else false;
     * 
     * Time Complexity -> O(N) -> sizeof array
     * 
     */
    private boolean validDistance(int[] stalls, int distance, int cows){ 
        int last = stalls[0];
        int tempCows = 1;
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=distance){
                tempCows++;
                last = stalls[i];
            }
        }
        return tempCows>=cows;
        
    }
  
    public static void main(String[] args) {
        AggressiveCows ser = new AggressiveCows();
        System.out.println(ser.getMaxMinDistance(new int[]{1, 2, 4, 8, 9}, 3)==3);
        System.out.println(ser.getMaxMinDistance(new int[]{6, 7,  9, 11, 13, 15}, 4)==2);
        System.out.println(ser.getMaxMinDistance(new int[]{1, 2,3,4,5,6,7, 8,9}, 3)==4);
        System.out.println(ser.getMaxMinDistance(new int[]{1, 2,3,4,5,6,7, 8,9,10}, 2)==9);
        System.out.println(ser.getMaxMinDistance(new int[]{100,200,400}, 3)==100);
    }
}
