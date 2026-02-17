import java.util.*;

class ReverseCharSequence implements CharSequence {
    private String data;

    // Constructor
    public ReverseCharSequence(String data) {
        this.data = data;
    }

    // charAt(int index) - Returns the character at the reversed index
    @Override
    public char charAt(int index) {
        if (index < 0 || index >= data.length()) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return data.charAt(data.length() - 1 - index);
    }

    //  length() - Returns the total length of the sequence
    @Override
    public int length() {
        return data.length();
    }

    //  subSequence(int start, int end) - Returns a new CharSequence
    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end > data.length() || start > end) {
            throw new IndexOutOfBoundsException();
        }
        StringBuilder sb = new StringBuilder(data.substring(data.length() - end, data.length() - start));//builder object
        return new ReverseCharSequence(sb.reverse().toString());
    }

    // Override toString() - Returns the fully reversed string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(data);
        return sb.reverse().toString();
    }

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a sentence to reverse:");
        String userInput = sc.nextLine();
        
        ReverseCharSequence rev = new ReverseCharSequence(userInput);

        System.out.println("\n--- Testing ReverseCharSequence Methods ---");
        
        // 1. toString()
        System.out.println("1. Full Reversed String: " + rev.toString());

        // 2. length()
        System.out.println("2. Sequence Length: " + rev.length());

        // 3. charAt()
        if (rev.length() > 0) {
            System.out.println("3. Character at index 0 (last of original): " + rev.charAt(0));
        }

        // 4. subSequence()
        if (rev.length() >= 5) {
            System.out.println("4. Sub-sequence (0 to 5): " + rev.subSequence(0, 5));
        } else {
            System.out.println("4. Sub-sequence: String too short for 0-5 test.");
        }

    }
}