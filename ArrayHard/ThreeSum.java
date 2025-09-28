import java.util.*;
public class ThreeSum {
    //Brute Force Approach TC : O(n^3) SC : O(m) m is no of triplets
     public static List<List<Integer>>triplet(int[]arr){
        Set<List<Integer>>st=new HashSet<>();
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer>temp=Arrays.asList(arr[i],arr[j],arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>>ans=new ArrayList<>(st);
        return ans;
    }
    //Better Approach TC : O(n^2) SC : O(m+n) m is no of triplets n is size of hashset
    public static List<List<Integer>>tripletBetterApproach(int[]arr){
        Set<List<Integer>>st=new HashSet<>();
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            Set<Integer> hashset=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third=-(arr[i]+arr[j]);
                
                if(hashset.contains(third)){
                    List<Integer>temp=Arrays.asList(arr[i],arr[j],third);
                    temp.sort(null);
                    st.add(temp);
                    
                }
                hashset.add(arr[j]);
            }
        }
        List<List<Integer>>ans=new ArrayList<>(st);
        return ans;
    }
    //Optimal Approach TC : O(n^2) SC : O(m) m is no of triplets
    public static List<List<Integer>> tripletOptimalApproach(int[]arr){
        List<List<Integer>>ans=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j=i+1;
            int k=n-1;
            
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    List<Integer>temp=Arrays.asList(arr[i],arr[j],arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1]) j++;
                    while(j<k && arr[k]==arr[k+1])k--;
                }
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		 int[] arr = { -1, 0, 1, 2, -1, -4};
		 List<List<Integer>>ans=triplet(arr);
		 for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        List<List<Integer>>ans2=triplet(arr);
		 for (List<Integer> it : ans2) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        List<List<Integer>>ans3=tripletOptimalApproach(arr);
		 for (List<Integer> it : ans3) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
	}
} 