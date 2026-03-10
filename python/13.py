from collections import Counter

class StringAnalyzer:
    def __init__(self, text):
        self.text = text
        self.words = text.lower().split()

    def __len__(self):
        """Returns the total length of repetitive words only."""
        counts = Counter(self.words) [cite: 30]
        # Sum length * count for words appearing more than once
        return sum(len(word) * count for word, count in counts.items() if count > 1) [cite: 29]

    def get_most_common(self, n):
        counts = Counter(self.words)
        return counts.most_common(n) [cite: 30]

def count_4_ways(s):
    # 1. Built-in len() [cite: 30]
    w1 = len(s)
    # 2. For loop [cite: 30]
    w2 = 0
    for _ in s: w2 += 1
    # 3. List comprehension sum [cite: 30]
    w3 = sum(1 for _ in s)
    # 4. Built-in magic method [cite: 30]
    w4 = s.__len__()
    return w1, w2, w3, w4

def main_string():
    user_text = input("Enter a sentence for analysis: ")
    analyzer = StringAnalyzer(user_text)

    # 1. Demonstrate Operator Overloading
    print(f"\nLength of repetitive words (via overloaded len()): {len(analyzer)}") [cite: 29]

    # 2. Most common words
    top_n = int(input("How many 'most common' words to display? "))
    print(f"Top {top_n} words: {analyzer.get_most_common(top_n)}") [cite: 30]

    # 3. Four ways of counting
    ways = count_4_ways(user_text)
    print(f"String length counted in 4 ways: {ways}") [cite: 30]

if __name__ == "__main__":
    main_string()