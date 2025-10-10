public class SplitArrayLargestSum {
    // Complexity O(N * log(sum(arr[])-max(arr[])+1)) Space Complexity O(1)
    public static int splitArrayLargestSum(int arr[],int k){
        int n=arr.length;
        int low=arr[0];
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }

        for(int i=low;i<=high;i++){
            if(checkIfPossible(arr,i)==k){
                return i;
            }
        }
        return -1;
    }
    // Optimal Approach Time Complexity O(N * log(sum(arr[])-max(arr[])+1)) Space Complexity O(1)
    public static int splitArrayLargestSumOptimalApproach(int arr[],int k){
        int n=arr.length;
        int low=arr[0];
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }
        while(low<=high){
            int mid=(low+high)/2;

            if(checkIfPossible(arr,mid)>k){
               low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;

    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int k=3;
        System.out.println(splitArrayLargestSum(a,k));
        System.out.println(splitArrayLargestSumOptimalApproach(a,k));
    }
    public static int checkIfPossible(int arr[],int sum){
        int count=1;
        int curSum=0;
        for(int i=0;i<arr.length;i++){
        if(curSum+arr[i]<=sum){
            curSum+=arr[i];
        }else{
            curSum=arr[i];
            count++;
        }
    }
        return count;
    }
    
}
