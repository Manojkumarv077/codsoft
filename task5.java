class Course:
    def __init__(self, code, title, description, capacity, schedule):
        self.code = code
        self.title = title
        self.description = description
        self.capacity = capacity
        self.enrolled_students = 0
        self.schedule = schedule

    def is_full(self):
        return self.enrolled_students >= self.capacity

    def enroll(self):
        if not self.is_full():
            self.enrolled_students += 1
            return True
        return False

    def drop(self):
        if self.enrolled_students > 0:
            self.enrolled_students -= 1
            return True
        return False

    def __str__(self):
        return f"{self.code}: {self.title} ({self.enrolled_students}/{self.capacity} slots filled)\n{self.description}\nSchedule: {self.schedule}"


class Student:
    def __init__(self, student_id, name):
        self.student_id = student_id
        self.name = name
        self.registered_courses = []

    def register_course(self, course):
        if course.enroll():
            self.registered_courses.append(course)
            print(f"{self.name} successfully registered for {course.title}.")
        else:
            print(f"Failed to register for {course.title}. Course is full.")

    def drop_course(self, course):
        if course in self.registered_courses and course.drop():
            self.registered_courses.remove(course)
            print(f"{self.name} successfully dropped {course.title}.")
        else:
            print(f"Failed to drop {course.title}. Not registered or already empty.")

    def list_courses(self):
        if not self.registered_courses:
            print(f"{self.name} is not registered for any courses.")
        else:
            print(f"{self.name}'s Registered Courses:")
            for course in self.registered_courses:
                print(f"- {course.title}")


class CourseManagementSystem:
    def __init__(self):
        self.courses = []
        self.students = {}

    def add_course(self, course):
        self.courses.append(course)

    def add_student(self, student):
        self.students[student.student_id] = student

    def display_courses(self):
        print("\n--- Available Courses ---")
        for course in self.courses:
            print(course)
            print()


def main():
    cms = CourseManagementSystem()

    # Adding courses
    cms.add_course(Course("CS101", "Introduction to Computer Science", "Basics of programming.", 3, "Mon/Wed 10-12"))
    cms.add_course(Course("MATH101", "Calculus I", "Introduction to calculus.", 2, "Tue/Thu 1-3"))
    cms.add_course(Course("ENG101", "English Literature", "Study of classic literature.", 5, "Mon/Wed 2-4"))

    # Adding students
    student1 = Student("S001", "Alice")
    student2 = Student("S002", "Bob")
    cms.add_student(student1)
    cms.add_student(student2)

    # Display available courses
    cms.display_courses()

    # Student registration
    student1.register_course(cms.courses[0])  # Alice registers for CS101
    student1.register_course(cms.courses[1])  # Alice registers for MATH101
    student2.register_course(cms.courses[0])  # Bob registers for CS101
    student2.register_course(cms.courses[1])  # Bob tries to register for MATH101 (full)

    # Listing courses for each student
    student1.list_courses()
    student2.list_courses()

    # Dropping a course
    student1.drop_course(cms.courses[0])  # Alice drops CS101
    student1.list_courses()

    # Display available courses again to see changes
    cms.display_courses()


if __name__ == "__main__":
    main()
