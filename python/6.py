# heirarchy
class UserError(Exception):
    """Base class for user-related exceptions."""
    pass

class UsernameNotUniqueError(UserError):
    pass

class InvalidAgeError(UserError):
    pass

class UnderageError(UserError):
    pass

class InvalidEmailError(UserError):
    pass

# --- Logic to Process Users ---
def process_user_data(user_list):
    user_directory = {} # Stores {username: email}

    for user in user_list:
        try:
            username, email, age = user
            
            # 1.integer check
            if not isinstance(age, int) or age <= 0:
                raise InvalidAgeError(f"Error: Age '{age}' is not a positive integer.") 
            
            # 2. age>16
            if age < 16:
                raise UnderageError(f"Error: User '{username}' < 16.") 
            
            # 3.username uniqueness
            if username in user_directory:
                raise UsernameNotUniqueError(f"Error: Username '{username}' is already taken.") 
            
            # 4. email( Simple check: username, @, and domain)
            if "@" not in email or email.startswith("@") or email.endswith("@") or "." not in email.split("@")[1]:
                raise InvalidEmailError(f"Error: '{email}' is not a valid email address.") 

            # If all checks pass, add to directory
            user_directory[username] = email 
            print(f"Success: Added {username} to the directory.")

        except UserError as e:
            print(e)
            continue

    return user_directory

# input
test_data = [
    ("alice", "abcd@example.com", 25),    # Valid
    ("bob", "bcdat_gmail.com", 20),       # Invalid Email
    ("alice", "new_alice@test.com", 30),   # Duplicate Username
    ("charlie", "charlie@web.in", 12),     # Underage
    ("delta", "delta@corp.com", -5),       # Not a positive integer
    ("eve", "eve@domain.org", 18)          # Valid
]

final_directory = process_user_data(test_data)
print("\nFinal User Directory:", final_directory)