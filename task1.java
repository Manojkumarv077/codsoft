import random

def play_game():
    random_number = random.randint(1, 100)
    attempts = 7
    score = 0

    print("Welcome to the Number Guessing Game!")
    print("I'm thinking of a number between 1 and 100.")
    print(f"You have {attempts} attempts to guess it.")

    while attempts > 0:
        guess = int(input("Enter your guess: "))
        
        if guess == random_number:
            print("Congratulations! You guessed it right!")
            score += attempts  # add remaining attempts to score
            break
        elif guess < random_number:
            print("Too low!")
        else:
            print("Too high!")
        
        attempts -= 1
        print(f"You have {attempts} attempts left.")

    if attempts == 0:
        print(f"Sorry, you're out of attempts! The number was {random_number}.")

    print(f"Your score: {score}")

def main():
    while True:
        play_game()
        play_again = input("Do you want to play again? (yes/no): ").strip().lower()
        if play_again != 'yes':
            break

    print("Thanks for playing!")

if __name__ == "__main__":
    main()
