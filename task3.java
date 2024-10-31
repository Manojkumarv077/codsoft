class BankAccount:
    def __init__(self, initial_balance=0):
        self.balance = initial_balance

    def deposit(self, amount):
        if amount > 0:
            self.balance += amount
            return True
        return False

    def withdraw(self, amount):
        if 0 < amount <= self.balance:
            self.balance -= amount
            return True
        return False

    def check_balance(self):
        return self.balance


class ATM:
    def __init__(self, bank_account):
        self.bank_account = bank_account

    def display_menu(self):
        print("\n--- ATM Menu ---")
        print("1. Deposit")
        print("2. Withdraw")
        print("3. Check Balance")
        print("4. Exit")

    def deposit(self):
        amount = float(input("Enter amount to deposit: "))
        if self.bank_account.deposit(amount):
            print(f"Successfully deposited ${amount:.2f}.")
        else:
            print("Deposit failed. Please enter a valid amount.")

    def withdraw(self):
        amount = float(input("Enter amount to withdraw: "))
        if self.bank_account.withdraw(amount):
            print(f"Successfully withdrew ${amount:.2f}.")
        else:
            print("Withdrawal failed. Insufficient balance or invalid amount.")

    def check_balance(self):
        balance = self.bank_account.check_balance()
        print(f"Your current balance is: ${balance:.2f}")


def main():
    initial_balance = float(input("Enter initial balance for your bank account: "))
    account = BankAccount(initial_balance)
    atm = ATM(account)

    while True:
        atm.display_menu()
        choice = input("Choose an option (1-4): ")

        if choice == '1':
            atm.deposit()
        elif choice == '2':
            atm.withdraw()
        elif choice == '3':
            atm.check_balance()
        elif choice == '4':
            print("Thank you for using the ATM. Goodbye!")
            break
        else:
            print("Invalid choice. Please select a valid option.")


if __name__ == "__main__":
    main()
