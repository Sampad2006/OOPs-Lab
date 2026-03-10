import heapq

def get_n_items(data, n, find_largest=True):
    """
    Uses heapq to find the top or bottom N items from a collection.
    """
    if find_largest:
        # Returns N largest items in descending order
        return heapq.nlargest(n, data)
    else:
        # Returns N smallest items in ascending order
        return heapq.nsmallest(n, data)

def main():
    print("--- Collection Filter (Top/Bottom N) ---")
    
    try:
        # 1. Input the initial collection
        raw_input = input("Enter numbers separated by spaces: ")
        # List comprehension to convert string input to a list of floats
        collection = [float(x) for x in raw_input.split()]
        
        if not collection:
            print("The collection is empty.")
            return

        while True:
            # 2. Get user preference for Largest or Smallest
            print("\nOptions: 'largest', 'smallest', 'exit'")
            mode = input("Action: ").strip().lower()

            if mode == 'exit':
                print("Goodbye!")
                break
            
            if mode not in ['largest', 'smallest']:
                print("Invalid option. Choose 'largest' or 'smallest'.")
                continue

            # 3. Get the value of N
            try:
                n = int(input(f"How many {mode} items do you want to see? "))
                
                # Cap N at the size of the collection
                actual_n = min(n, len(collection))
                
                if actual_n <= 0:
                    print("Please enter a positive integer for N.")
                    continue

                is_largest = (mode == 'largest')
                result = get_n_items(collection, actual_n, is_largest)
                
                print(f"The {actual_n} {mode} items are: {result}")

            except ValueError:
                print("Error: N must be an integer.")

    except ValueError:
        print("Error: Please enter only numerical values in the collection.")

if __name__ == "__main__":
    main()