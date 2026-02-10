import java.util.*;

public class StringProcessor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        // i) Number of times 'a' appears
        int countA = 0;
        for (char c : input.toCharArray()) {
            if (c == 'a' || c == 'A') countA++;
        }
        System.out.println("Count of 'a': " + countA);

        // ii) Number of times "and" appears
        int countAnd = 0;
        String[] words = input.toLowerCase().split("\\s+");
        for (String w : words) {
            if (w.equals("and")) countAnd.countAnd++;
        }
        // Note: Using indexOf in a loop is more precise for overlapping or mid-word "and"
        System.out.println("Count of \"and\": " + countAnd);

        // iii) Whether it starts with "The"
        System.out.println("Starts with \"The\": " + input.startsWith("The"));

        // iv) Put the String into an array of characters
        char[] charArray = input.toCharArray();
        System.out.println("Character array created. Length: " + charArray.length);

        // v) Display the tokens separated by space, @, or .
        // Using Regex: [ @\\.]+ means space, @, or dot (one or more)
        System.out.println("Tokens:");
        String[] tokens = input.split("[ @\\.]+");
        for (String token : tokens) {
            if (!token.isEmpty()) System.out.println("- " + token);
        }

        // vi) Find the largest palindrome
        System.out.println("Largest Palindrome: " + findLargestPalindrome(input));
    }

    private static String findLargestPalindrome(String sentence) {
        // Clean the sentence: Remove non-alphanumeric and split into words
        String cleaned = sentence.replaceAll("[^a-zA-Z0-9 ]", "");
        String[] words = cleaned.split("\\s+");
        
        String largest = "";
        for (String word : words) {
            if (isPalindrome(word) && word.length() > largest.length()) {
                largest = word;
            }
        }
        return largest.isEmpty() ? "None" : largest;
    }

    private static boolean isPalindrome(String str) {
        if (str.length() < 2) return false; // Optional: define if single letters count
        String rev = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(rev);
    }
}