public class LargestOddSum {
     public static String largestOddSum(String num){
        int i;
        int ind=-1;

        for(i=num.length()-1;i>=0;i--){
            if((num.charAt(i)-'0')%2==1){
                ind=i;
                break;
            }
        }

        if(ind==-1) return "";
        i=0;
        while(i<=ind && num.charAt(i)=='0' ) i++;
        return num.substring(i,ind+1);
    }
    public static void main(String[] args) {
        String num="504";
        System.out.println(largestOddSum(num));
    }
    
}
