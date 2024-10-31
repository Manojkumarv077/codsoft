def calculate_grade(average):
    if average >= 90:
        return 'A+'
    elif average >= 80:
        return 'A'
    elif average >= 70:
        return 'B'
    elif average >= 60:
        return 'C'
    elif average >= 50:
        return 'D'
    else:
        return 'F'

def main():
    # Input: Take marks obtained in each subject
    subjects = int(input("Enter the number of subjects: "))
    marks = []

    for i in range(subjects):
        mark = float(input(f"Enter marks obtained in subject {i + 1} (out of 100): "))
        marks.append(mark)

    # Calculate Total Marks
    total_marks = sum(marks)

    # Calculate Average Percentage
    average_percentage = total_marks / subjects

    # Grade Calculation
    grade = calculate_grade(average_percentage)

    # Display Results
    print("\n--- Results ---")
    print(f"Total Marks: {total_marks} out of {subjects * 100}")
    print(f"Average Percentage: {average_percentage:.2f}%")
    print(f"Grade: {grade}")

if __name__ == "__main__":
    main()
