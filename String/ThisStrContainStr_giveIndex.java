package stringDemo;

public class ThisStrContainStr_giveIndex {

	public static void main(String[] args) {
		System.out.println(Search("thisismanmanish", "manish"));//9
	}
	public static int Search(String haystack, String needle){
	    for(int i = 0; i < haystack.length(); i++ ) {
	        
	    	for(int j = 0; j < needle.length() && i+j < haystack.length(); j++ ) {
	        	
	            if(needle.charAt(j) != haystack.charAt(i+j)) {
	                break;
	            } else if (j == needle.length()-1) {//counter of needle should match with length then equal
	                return i;
	            }
	        }
	    }
	    return -1;
	}
}
