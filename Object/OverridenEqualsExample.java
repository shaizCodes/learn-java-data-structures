import java.util.Objects;

import utility.Printer;

public class OverridenEqualsExample {
    private static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{name={'" + name + "'}@"+ Printer.YELLOW_BACKGROUND + name.hashCode()+ Printer.RESET + Printer.GREEN + "}@"+ Printer.RED_BACKGROUND + this.hashCode() + Printer.RESET + Printer.GREEN;
        }
    }

    private static class Student extends Person {
        static int count = 0;
        int id;
        int age;

        Student(String name, int age) {
            super(name);
            this.age = age;
            this.id = ++count;
        }

        @Override
        public boolean equals(Object person) {
            if (!(person instanceof Student)) return false;
            Student student = (Student) person;
            return (id == student.id && name.equals(student.name));
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), id, age);
        }

        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "', age=" + age + "}@"+ Printer.RED_BACKGROUND + this.hashCode() + Printer.RESET + Printer.GREEN;
        }
    }

    public static void main(String[] args) {
        String firstName = "Shahzad";
        String lastName = "Shahzad";
        Printer.printColored("Names: ", "Are {'" + firstName + "'}@"+ Printer.YELLOW_BACKGROUND + firstName.hashCode() + Printer.RESET + Printer.GREEN +" and {'" + lastName + "'}@"+ Printer.YELLOW_BACKGROUND + lastName.hashCode() + Printer.RESET + Printer.GREEN +" equal"+ Printer.YELLOW +"? " + Printer.BLUE_BACKGROUND + firstName.equals(lastName));
        System.out.println( Printer.YELLOW + "The hashcode of the strings matches, hence, they are equal.\n" + Printer.RESET);

        Person person1 = new Person(firstName);
        Person person2 = new Person(firstName);
        Printer.printColored("Person 1, 2", "Is " + person1 + " equal to " + person2 + Printer.YELLOW + "? " + person1.equals(person2));
        System.out.println(Printer.YELLOW + "Despite having the same name, they are not equal because the hashcode of the objects do not match and equals() is not overriden.\n");

        Student student1 = new Student(firstName, 20);
        Student student2 = new Student(firstName, 20);
        Printer.printColored("Student 1, 2", "Is " + student1 + " equal to " + student2 + Printer.YELLOW + "? " + student1.equals(student2));
        System.out.println(Printer.YELLOW + "Despite having the same name and age, they are not equal because the IDs do not match according to the equals() method.\n" + Printer.RESET);

        Student student3 = new Student(firstName, 20);
        student3.id = student1.id; // Manually set the same ID for testing
        Printer.printColored("Student 1, 3", "Is " + student1 + " equal to " + student3 + Printer.YELLOW + "? " + Printer.BLUE_BACKGROUND + student1.equals(student3));
        System.out.println(Printer.YELLOW + "They are equal according to the overriden equals() method as IDs and names match.\n" + Printer.RESET);

        Printer.printColored("Student 2, 3", "Is " + student2 + " equal to " + student3 + Printer.YELLOW + "? " + student2.equals(student3));
        System.out.println(Printer.YELLOW + "They are not equal according to the overriden equals() method as IDs do not match.\n" + Printer.RESET);
    }
}
