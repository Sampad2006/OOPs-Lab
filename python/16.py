from operator import itemgetter
from collections import defaultdict

def main():
    # 1. Create first dictionary with user input (preserves insertion order)
    stock_dict1 = {}
    print("--- Stock Dictionary 1 Setup ---")
    while True:
        name = input("Enter stock name (or 'done'): ").strip()
        if name.lower() == 'done': break
        price = int(input(f"Enter price for {name}: "))
        stock_dict1[name] = price

    if not stock_dict1:
        print("Dictionary 1 is empty. Exiting.")
        return

    # 2. Min, Max, and Sort by Price
    min_stock = min(stock_dict1.items(), key=itemgetter(1))
    max_stock = max(stock_dict1.items(), key=itemgetter(1))
    sorted_dict1 = dict(sorted(stock_dict1.items(), key=lambda item: item[1]))

    print(f"\nMin Price: {min_stock}")
    print(f"Max Price: {max_stock}")
    print(f"Sorted Dictionary 1: {sorted_dict1}")

    # 3. Create second stock dictionary
    stock_dict2 = {}
    print("\n--- Stock Dictionary 2 Setup ---")
    while True:
        name = input("Enter stock name (or 'done'): ").strip()
        if name.lower() == 'done': break
        price = int(input(f"Enter price for {name}: "))
        stock_dict2[name] = price

    # 4. Dictionary Set Operations
    # Items only in first dictionary (Keys)
    only_in_1 = stock_dict1.keys() - stock_dict2.keys()
    
    # Prices that do not match for common keys
    mismatched_prices = {k: (stock_dict1[k], stock_dict2[k]) 
                         for k in stock_dict1.keys() & stock_dict2.keys() 
                         if stock_dict1[k] != stock_dict2[k]}

    print(f"\nStocks only in Dict 1: {only_in_1}")
    print(f"Mismatched prices (Key: (Price1, Price2)): {mismatched_prices}")

    # 5. Remove Duplicate Items (Keys are unique by nature, but we ensure Dict 1 is clean)
    # If the assignment implies removing stocks with same name/price already in Dict 2:
    stock_dict1 = {k: v for k, v in stock_dict1.items() if (k, v) not in stock_dict2.items()}
    print(f"\nDict 1 after removing items present in Dict 2: {stock_dict1}")

    # 6. Sort both for incrementing prices
    sorted_1 = dict(sorted(stock_dict1.items(), key=itemgetter(1)))
    sorted_2 = dict(sorted(stock_dict2.items(), key=itemgetter(1)))
    print(f"Sorted Dict 1: {sorted_1}")
    print(f"Sorted Dict 2: {sorted_2}")

    # 7. Group items in Dict 1 by price multiples of 500
    grouped_stocks = defaultdict(list)
    for name, price in stock_dict1.items():
        group = (price // 500) * 500
        grouped_stocks[group].append(name)
    
    print(f"\nStocks grouped by multiples of 500: {dict(grouped_stocks)}")

    # 8. Find item with price = 800 in both
    find_800 = {k for k, v in {**stock_dict1, **stock_dict2}.items() if v == 800}
    print(f"Stocks with price 800: {find_800 if find_800 else 'None found'}")

if __name__ == "__main__":
    main()