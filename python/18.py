import pytest

# 1. The Function to be tested
def compute_power(base, exponent):
    return base ** exponent

# 2. Parameterized Test Case
# Each tuple is (base, exponent, expected_result)
@pytest.mark.parametrize("base, exponent, expected", [
    (2, 2, 4),
    (2, 3, 8),
    (1, 9, 1),
    (0, 9, 0)
])
def test_power_values(base, exponent, expected):
    """Checks if compute_power(base, exponent) equals the expected value."""
    assert compute_power(base, exponent) == expected

# --- User Input Provision ---
def main():
    print("--- Power Calculator & Manual Tester ---")
    print("This tool mimics the logic used in the automated tests.")
    
    while True:
        try:
            line = input("\nEnter base and exponent (e.g., '2 3') or 'exit': ").strip()
            if line.lower() == 'exit':
                break
            
            b, e = map(float, line.split())
            result = compute_power(b, e)
            print(f"Result: {b} ^ {e} = {result}")
            
        except ValueError:
            print("Error: Please enter two numbers separated by a space.")

if __name__ == "__main__":
    # If run directly, allow user input. 
    # If run via pytest, the main block is ignored.
    main()