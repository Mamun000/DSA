public class FindArrayRotation {
     public static int countArrayRotation(int []arr){
        int low=0,high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high){
            int mid=(low+high)/2;
            
            if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                ans=arr[low];
                index=low;
                }
                 low=mid+1;
            }else{
                if(arr[mid]<ans){
                ans=arr[mid];
                index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
		System.out.println(countArrayRotation(arr));
	}
    
}
