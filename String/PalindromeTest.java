package stringDemo;

import java.util.Scanner;

/* Check whether string is palindrome or not?
 * 
 */
class TestString{
	public static boolean isPalindrome(String str){
		if(str == null)
		return false;
		
		if(str.length()<2)
			return false;
		
		for(int i=0;i<str.length()/2;i++){
			if(str.toUpperCase().charAt(i) != str.toUpperCase().charAt((str.length()-1)-i)){
				return false;
			}			
		}
		return true;
	}
}

public class PalindromeTest {
	public static void main(String[] args) {
		String flag="y";		
		while(flag.equalsIgnoreCase("y")){
			System.out.println("Enter the String to test palindrome: ");
			Scanner scan = new Scanner(System.in);
			String test = scan.next();
			System.out.println(test + (TestString.isPalindrome(test)?" is Palindrome":" is not Palindrome"));
			System.out.println("Do you want to test another String?(y/n): ");
			flag = scan.next();
		}
		
	}
}
