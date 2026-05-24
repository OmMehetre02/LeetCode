class Solution {
    public String firstPalindrome(String[] words) {
       
        for(int i=0;i<words.length;i++){
             String s=words[i];
             boolean palindrom =true;

             int start=0;
             int end=s.length()-1;
             while(start<end){
                if(s.charAt(start)!=s.charAt(end)){
                    palindrom=false;
                    break;

                }
                start++;
                end--;
             }
             if(palindrom){
                return s;
             }
        }
        return "";
    }
}