import time

def geometric_progression(a, q):
    """
    Generator that yields terms of a geometric progression.
    Stops when a term exceeds 100,000.
    """
    term = a
    while True:
        if term > 100000:
            return  # The generator stops with a return statement 
        if term<0.0001:
            return 
        yield term
        term = term * q

# Take common ratio  and starting term as input
try:
    a_input = float(input("Enter the starting term (a): "))
    q_input = float(input("Enter the common ratio (q): "))

    # Start measuring Total Time
    start_total = time.perf_counter()

    # Initialize the generator
    progression = geometric_progression(a_input, q_input)

    print(f"\nGeometric Progression for a={a_input}, q={q_input}:")

    # time counter
    start_loop = time.perf_counter()
    
    for val in progression:
        print(f"{val:.2f}", end="  ")
        
    end_loop = time.perf_counter()
    
    end_total = time.perf_counter()


    print("\nTimes:")
    print(f"Time within loop: {end_loop - start_loop:.10f} seconds")
    print(f"Total execution time: {end_total - start_total:.10f} seconds")

except ValueError:
    print("Error: Please enter valid numbers for the progression.")