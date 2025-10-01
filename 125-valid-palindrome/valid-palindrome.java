class Solution {
    public boolean isPalindrome(String s) {
        
     String original=s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
     int i=0;
     int j=original.length()-1;
     while(i<=j){
        
        if(original.charAt(i)!=original.charAt(j)){
            return false;
        }
        i++;
        j--;
     }
      
     return true;
    }
}