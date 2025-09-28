import java.util.*;

public class MajorityByThree {
     public static List<Integer> majorityByThree(int []arr){
        List<Integer>x=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int count=0;
             if (x.size() == 0 || x.get(0) != arr[i]) {
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>arr.length/3){
                x.add(arr[i]);
            }
             }
            if (x.size() == 2) break;
        }
        return x;
        
    }
    
     public static List<Integer>majorityByThreeBetterApproach(int v[]){
         int n = v.length;
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int mini = (int)(n / 3) + 1;

        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);

            if (mpp.get(v[i]) == mini) {
                ls.add(v[i]);
            }
            if (ls.size() == 2) break;
        }

        return ls;
        
     }
     public static List<Integer>majorityElementOptimalApproach(int []arr){
        int cnt1=0,cnt2=0;
        int ele1=0,ele2=0;
        List<Integer>ans=new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            
            if(cnt1==0 && arr[i]!=ele2){
                cnt1=1;
                ele1=arr[i];
            }else if(cnt2==0 && arr[i]!=ele1){
                cnt2=1;
                ele2=arr[i];
            }else if(ele1==arr[i]){
                cnt1++;
            }else if(ele2==arr[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
            
        }
        
        cnt1=0;
        cnt2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele1)cnt1++;
            if(arr[i]==ele2)cnt2++;
        }
        
        int min=(int)(arr.length/3)+1;
        if(cnt1>=min) ans.add(ele1);
        if(cnt2>=min) ans.add(ele2);
        
        return ans;
        
    }
    
	public static void main(String[] args) {
		int arr[]={11, 33, 33, 11, 33, 11};
		List<Integer>ans=majorityByThree(arr);
        System.out.print("Majority elements are : ");
		for(int x: ans){
		    System.out.print(x+" ");
		}
        System.out.println();
        System.out.print("Majority elements are : ");
		List<Integer>ans2=majorityByThreeBetterApproach(arr);
		for(int x: ans2){
		    System.out.print(x+" ");
		}
        System.out.println();
        List<Integer> ans3 = majorityElementOptimalApproach(arr);
        System.out.print("Majority elements are : ");
        for (int i = 0; i < ans3.size(); i++) {
            System.out.print(ans3.get(i) + " ");
        }
        System.out.println();
	}
    
}
