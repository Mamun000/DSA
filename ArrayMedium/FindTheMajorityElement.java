import java.util.Arrays;

public class FindTheMajorityElement {
    // Brute Force Approach TC : O(n^2) SC : O(1)
    public static int majorityElement(int[]arr){
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
                
            }
            if(count>=n/2) {return arr[i];}
        }
        return 0;
    }
    
    //Better Approach TC : O(nlogn) SC : O(1)
    public static int majorityElementBetterApproach(int[]arr){
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
    //Optimal Approach TC : O(n) SC : O(1)  using Moore's Voting Algorithm
    public static int majorityElementOptimalApproach(int[]arr){
        int count=0;
        int ele=arr[0];
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                count++;
            }else if(count==0){
                count=1;
                ele=arr[i];
            }else{
                count--;
            }
            
           
        }
        int cnt=0;
        for(int x: arr){
            if(x==ele)cnt++;
        }
        if(cnt>arr.length/2) return ele;
        
        return-1;
    }
	public static void main(String[] args) {
		int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("Brute Force Approach : " + ans);
        ans = majorityElementBetterApproach(arr);
        System.out.println("Better Approach : " + ans);
        ans = majorityElementOptimalApproach(arr);
        System.out.println("Optimal Approach : " + ans);
        
	}
    
}
