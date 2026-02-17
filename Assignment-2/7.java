import java.util.*;

class Prob{
    //palin check
    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        //count of a
        int countA = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.toLowerCase(input.charAt(i)) == 'a') {
                countA++;
            }
        }
        System.out.println("Total a count: " + countA);

        //and count
        String lowerInput = input.toLowerCase();
        int countAnd = 0;
        int pos = 0;
        while ((pos = lowerInput.indexOf("and", pos)) != -1) {
            countAnd++;
            pos += 3; 
        }
        System.out.println(" Total and count: " + countAnd);

        //"the" check
        System.out.println("Starts with \"The\": " + input.startsWith("The"));

        //Put the String into an array of characters
        char[] charArray = input.toCharArray();
        System.out.println("Char array created. Length: " + charArray.length);

        // Display tokens (separated by space, @, or .)
        System.out.println(" Tokens in the String:");
        String[] tokens = input.split("[ @.]+");//regex
        for (String token : tokens) {
            if (!token.isEmpty()) {
                System.out.println("   - " + token);
            }
        }

        //  largest palindrome after removing non-alphanumeric characters
        String cleaned = input.replaceAll("[^a-zA-Z0-9 ]", "");
        String[] words = cleaned.split("\\s+"); // Split by one or more spaces
        
        String largestPalindrome = "";
        for (String word : words) {
            // Check word as a palindrome (case-insensitive)
            if (isPalindrome(word.toLowerCase()) && word.length() > 1) {
                if (word.length() > largestPalindrome.length()) {
                    largestPalindrome = word;
                }
            }
        }

        System.out.println(" Largest palindrome found: " + 
            (largestPalindrome.isEmpty() ? "None" : largestPalindrome));

        sc.close();
    }
}