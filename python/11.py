class TextAnalyzer:
    def __init__(self, text):
        # String method: lower() and split() to get a list of words
        self.words = text.lower().split()

    @classmethod
    def is_palindrome(cls, word):
        """Class method to check if a single word is a palindrome."""
        # String method: reverse using slicing [::-1]
        cleaned_word = "".join(char for char in word if char.isalnum())
        return cleaned_word == cleaned_word[::-1] and len(cleaned_word) > 1

    def find_palindromes(self):
        """Instance method calling the class method."""
        return [word for word in self.words if self.is_palindrome(word)]

    def get_unique_words(self):
        """Uses set and string methods to find unique words."""
        # set() naturally removes duplicates
        unique_set = set(self.words)
        return sorted(list(unique_set))

# --- Testing the Code ---
input_text = "The radar was at noon for the civic meeting at noon"
analyzer = TextAnalyzer(input_text)

# 1. Searching for Palindromes
palindromes = analyzer.find_palindromes()
print(f"Palindromes found: {palindromes}")

# 2. Searching for Unique Words
unique_words = analyzer.get_unique_words()
print(f"Unique words found: {unique_words}")