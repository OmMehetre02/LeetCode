class Solution {
    public boolean backspaceCompare(String s, String t) {
       String a ="";
       String b="";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='#'){
                if(a.length()>0){
                    a=a.substring(0,a.length()-1);
                        
                    
                }

            }else{
                    a+=ch;
                }
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch=='#'){
                if(b.length()>0){
                    b=b.substring(0,b.length()-1);
                       
                    }
                }
                else{
                         b+=ch;
                    }
            
        }
        return a.equals(b);
    }
}