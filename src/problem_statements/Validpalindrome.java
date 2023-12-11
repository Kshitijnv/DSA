package problem_statements;

public class Validpalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s1 = new Solution();
		System.out.println(s1.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(s1.isPalindromeImproved("A man, a plan, a canal: Panama"));
	}

}

class Solution {
	public Solution() {
		// TODO Auto-generated constructor stub
	}

	public boolean isPalindrome(String s) {
		String newString = s.replaceAll("[^a-zA-Z0-9]", "");
		newString = newString.toLowerCase();
		StringBuilder sb = new StringBuilder(newString).reverse();
		if (newString.equals(sb.toString()))
			return true;
		return false;

	}

	public boolean isPalindromeImproved(String s) {
		// take 2 pointer 1 from start and 1 from end
		int start = 0;
		int last = s.length() - 1;
		while (start <= last) {
			// start ptr will increase if there is No alphaNumeric or special character
			char currFirst = s.charAt(start);
			// last ptr will decrease if there is No alphaNumeric or special character
			char currLast = s.charAt(last);
			if (!Character.isLetterOrDigit(currFirst)) {
				start++;
			} else if (!Character.isLetterOrDigit(currLast)) {
				last--;
			} else {
				if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast))
					return false;
				start++;
				last--;
			}
		}
		return true;
	}
}
