class BankAccount:
    def __init__(self, initial_balance, pin):
        self._balance = initial_balance [cite: 24]
        self._pin = pin [cite: 24]

    def deposit(self, amount):
        if amount > 0:
            self._balance += amount [cite: 24]
            print(f"Deposited: ${amount:.2f}")
        else:
            print("Invalid deposit amount.")

    def withdraw(self, amount):
        if 0 < amount <= self._balance:
            self._balance -= amount [cite: 24]
            print(f"Withdrew: ${amount:.2f}")
            return True
        else:
            print("Insufficient funds or invalid amount.")
            return False

    def get_balance(self):
        return self._balance [cite: 24]

    def change_pin(self, old_pin, new_pin):
        if old_pin == self._pin:
            self._pin = new_pin [cite: 24]
            print("PIN changed successfully.")
        else:
            print("Incorrect old PIN.")

class SavingsAccount(BankAccount):
    def __init__(self, initial_balance, pin, interest_rate):
        super().__init__(initial_balance, pin) [cite: 26]
        self.interest_rate = interest_rate [cite: 26]

    def add_interest(self):
        interest = self._balance * self.interest_rate [cite: 26]
        self._balance += interest [cite: 26]
        print(f"Interest of ${interest:.2f} added.")

class FeeSavingsAccount(SavingsAccount):
    def __init__(self, initial_balance, pin, interest_rate, fee):
        super().__init__(initial_balance, pin, interest_rate) [cite: 27, 28]
        self.fee = fee [cite: 27, 28]

    def withdraw(self, amount):
        total_deduction = amount + self.fee [cite: 27, 28]
        print(f"Applying withdrawal fee: ${self.fee:.2f}")
        return super().withdraw(total_deduction) [cite: 27, 28]

def main_bank():
    print("--- Bank Account Setup ---")
    bal = float(input("Initial Balance: "))
    pin = input("Set PIN: ")
    rate = float(input("Interest Rate (e.g., 0.05 for 5%): "))
    fee = float(input("Withdrawal Fee: "))
    
    acc = FeeSavingsAccount(bal, pin, rate, fee)

    while True:
        print("\nOptions: 1.Deposit 2.Withdraw 3.Balance 4.Add Interest 5.Exit")
        choice = input("Select an option: ")

        if choice == '1':
            amt = float(input("Enter deposit amount: "))
            acc.deposit(amt)
        elif choice == '2':
            amt = float(input("Enter withdrawal amount: "))
            acc.withdraw(amt)
        elif choice == '3':
            print(f"Current Balance: ${acc.get_balance():.2f}")
        elif choice == '4':
            acc.add_interest()
        elif choice == '5':
            break
        else:
            print("Invalid Choice.")

if __name__ == "__main__":
    main_bank()