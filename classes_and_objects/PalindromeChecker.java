package classes_and_objects;

public class PalindromeChecker {
	//Attribute
	String text;
	
	//Constructor
	public PalindromeChecker(String text) {
		this.text = text;
	}
	
	//Method to check if the text is a palindrome
	public boolean isPalindrome() {
		String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int left = 0;
		int right = cleaned.length() - 1;
		while(left < right) {
			if(cleaned.charAt(left) != cleaned.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	// Method to display result
    public void displayResult() {
        System.out.println("Text: " + text);
        if (isPalindrome()) {
            System.out.println("Result: The text is a palindrome.");
        } else {
            System.out.println("Result: The text is NOT a palindrome.");
        }
        System.out.println("--------------------------");
    }
    
 // Main method to test
    public static void main(String[] args) {
        PalindromeChecker pc1 = new PalindromeChecker("Racecar");
        PalindromeChecker pc2 = new PalindromeChecker("Hello");
        PalindromeChecker pc3 = new PalindromeChecker("A man, a plan, a canal, Panama");

        pc1.displayResult();
        pc2.displayResult();
        pc3.displayResult();
    }
}
