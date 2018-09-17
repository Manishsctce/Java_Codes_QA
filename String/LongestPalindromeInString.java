package stringDemo;

public class LongestPalindromeInString {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aabbcccaaaadddddaaaaccccccccccccc"));
	}
	
	public static String longestPalindrome(String input){
		String checkstr = null;
		String longestPalindrome = " ";
		int size = input.length();
		for(int i=0;i<size;i++){			
			for(int j=i+1;j<size;j++){
				checkstr = input.substring(i, j);
				if(isPalindrome(checkstr)){
					if(longestPalindrome.length() < checkstr.length())
						longestPalindrome = checkstr;
					
				}
			}
		}
		return longestPalindrome.toString();
	}
	
	public static boolean isPalindrome(String input){
		int len = input.length();
			
		for(int i=0;i<len-1;i++){
			if(input.charAt(i) != input.charAt(len-1-i))
				return false;
		}
		return true;
	}
}
