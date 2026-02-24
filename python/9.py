enumerated_alphabet = []

for index, ascii_val in enumerate(range(97, 123), start=1):
    # chr() converts an ASCII number back into a character
    letter = chr(ascii_val)
    enumerated_alphabet.append((index, letter))

# Displaying the results
print("Enumerated ASCII letters (97 to 122):")
for pos, char in enumerated_alphabet:
    print(f"{pos}: {char}")