numbers = list(range(1, 51))

# lambda to filter multiples of five
# x % 5 == 0 checks if the remainder is zero
multiples_of_five = list(filter(lambda x: x % 5 == 0, numbers))

# Display the results
print("Numbers up to 50 that are multiples of 5:")
print(multiples_of_five)