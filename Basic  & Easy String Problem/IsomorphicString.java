public class IsomorphicString {
    public static boolean isomorphicString(String s, String t){
        int m1[]=new int[256],m2[]=new int[256];

        for(int i=0;i<s.length();i++){
            if(m1[s.charAt(i)]!=m2[t.charAt(i)]) return false;
            m1[s.charAt(i)]=i+1;
            m2[t.charAt(i)]=i+1;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
  
          // Check if strings are isomorphic
        if (isomorphicString(s, t)) {
              System.out.println("Strings are isomorphic.");
        } else {
              System.out.println("Strings are not isomorphic.");
        } 
    }    
}
