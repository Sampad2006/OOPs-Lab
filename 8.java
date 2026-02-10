public class ReverseCharSequence implements CharSequence {
    private final String data;

    public ReverseCharSequence(String data) {
        this.data = data;
    }

    // (i) charAt(int index) - Return character from the back
    @Override
    public char charAt(int index) {
        if (index < 0 || index >= data.length()) {
            throw new IndexOutOfBoundsException();
        }
        // Logic: index 0 is actually length-1, index 1 is length-2, etc.
        return data.charAt(data.length() - 1 - index);
    }

    // (ii) int length()
    @Override
    public int length() {
        return data.length();
    }

    // (iii) CharSequence subSequence(int start, int end)
    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end < 0 || start > end || end > data.length()) {
            throw new IndexOutOfBoundsException();
        }
        // We get the substring normally, then wrap it in a new ReverseCharSequence
        // to maintain the "backwards" behavior for the sub-sequence.
        StringBuilder sub = new StringBuilder(data.substring(data.length() - end, data.length() - start));
        return new ReverseCharSequence(sub.reverse().toString());
    }

    // (iv) Override toString()
    @Override
    public String toString() {
        return new StringBuilder(data).reverse().toString();
    }

    public static void main(String[] args) {
        // Using a common lecture-style sentence
        String sentence = "Java is an object oriented programming language";
        ReverseCharSequence rev = new ReverseCharSequence(sentence);

        System.out.println("Original: " + sentence);
        
        // Testing (iv) toString
        System.out.println("Reverse (toString): " + rev.toString());

        // Testing (ii) length
        System.out.println("Length: " + rev.length());

        // Testing (i) charAt
        System.out.println("Character at index 0 (should be 'e'): " + rev.charAt(0));

        // Testing (iii) subSequence
        // Let's get "Java" from the reversed version
        System.out.println("Subsequence (last 4 chars reversed): " + rev.subSequence(0, 4));
    }
}