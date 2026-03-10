def flatten_dict(d, parent_key='', sep='_'):
    """
    Recursively flattens a nested dictionary.
    """
    items = []
    for k, v in d.items():
        # Create a new key name based on the parent key
        new_key = f"{parent_key}{sep}{k}" if parent_key else k
        
        if isinstance(v, dict):
            # If the value is a dictionary, recurse
            items.extend(flatten_dict(v, new_key, sep=sep).items())
        else:
            # If it's a base value (int, string, list), add to items
            items.append((new_key, v))
            
    return dict(items)

def main():
    # --- Sample Test Data ---
    nested_sample = {
        'fullname': 'Alessandra',
        'age': 41,
        'phone-numbers': ['+447421234567', '+447423456789'],
        'residence': {
            'address': {
                'first-line': 'Alexandra Rd',
                'second-line': 'Testing',
            },
            'zip': 'N8 0PP',
            'city': 'London',
            'country': 'UK',
        },
    }

    print("--- Sample Data Result ---")
    flat_sample = flatten_dict(nested_sample)
    for key, value in flat_sample.items():
        print(f"{key}: {value}")

    # --- User Input Provision ---
    print("\n" + "="*30)
    print("--- User Input Mode ---")
    print("Enter data in 'key:value' format. For nested items, use 'parent.child:value'.")
    print("Type 'done' to process.")

    user_data = {}
    while True:
        entry = input("Entry (e.g., user.name:John): ").strip()
        if entry.lower() == 'done':
            break
        
        if ':' in entry:
            key_path, val = entry.split(':', 1)
            # Simple logic to build a nested dict from a path string
            keys = key_path.split('.')
            current = user_data
            for key in keys[:-1]:
                current = current.setdefault(key, {})
            current[keys[-1]] = val
        else:
            print("Invalid format. Use 'key:value'")

    if user_data:
        print("\nFlattened User Data:")
        print(flatten_dict(user_data))

if __name__ == "__main__":
    main()