import utility.Printer;

public class CloneExample implements Cloneable {
    private static class Person implements Cloneable {
        StringBuilder name;
        int age;
        
        public Person(String name, int age) {
            this.name = new StringBuilder(name);
            this.age = age;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone(); // Shallow copy
        }

        public Person deepCopy() {
            return new Person(this.name.toString(), this.age); // Deep copy
        }
        

        @Override
        public String toString() {
            return "Person{{name='" + Printer.BLUE_BACKGROUND + name + Printer.RESET + Printer.GREEN + "'}@" + Printer.YELLOW_BACKGROUND + System.identityHashCode(this.name) + Printer.RESET + Printer.GREEN + ", age=" + age + "}@" + Printer.YELLOW_BACKGROUND + System.identityHashCode(this) + Printer.RESET;
        }
    }
    
    public static void main(String[] args) {
        Person person = new Person("Shahzad", 25);
        try {
            Person clonedPerson = (Person) person.clone();
            System.out.println("Shallow Copy:");
            Printer.printColored("Original Person", person.toString());
            Printer.printColored("Cloned Person", clonedPerson.toString());
            System.out.println("Because the clone is a shallow copy, the original and cloned objects share the same reference for the name field.");
            System.out.println("Modifying the name of the cloned person...");
            clonedPerson.name.append(" Ali");
            Printer.printColored("Original Person", person.toString());
            Printer.printColored("Cloned Person", clonedPerson.toString());
            System.out.println("As you can see, the name of the original person has also changed to 'Shahzad Ali'.\n");

            System.out.println("Deep Copy:");
            Person deepClonedPerson = person.deepCopy();
            Printer.printColored("Original Person", person.toString());
            Printer.printColored("Deep Cloned Person", deepClonedPerson.toString());
            System.out.println("Modifying the name of the deep cloned person...");
            deepClonedPerson.name.append(" Khan");
            Printer.printColored("Original Person", person.toString());
            Printer.printColored("Deep Cloned Person", deepClonedPerson.toString());
            System.out.println("As you can see, the name of the original person has not changed.\nThe deep cloned person has its own copy of the name field.\n");

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}