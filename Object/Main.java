import utility.Printer;

public class Main {
    public static void main(String[] args) {
        String first = "AbCdEf";
        String second = "AbCdEf";
        String third = new String("AbCdEf");
        StringBuilder fourth = new StringBuilder("AbCdEf");

        System.out.println("Equality Check:");
        Printer.printColored("first == second", "" + (first == second));
        Printer.printColored("first == third",  "" + (first == third));
        Printer.printColored("first == fourth", "" + (first == fourth.toString()));
        Printer.printColored("third == fourth", "" + (third == fourth.toString()));

        Printer.printColored("first.equals(second)", "" + (first.equals(second)));
        Printer.printColored("first.equals(third)",  "" + (first.equals(third)));
        Printer.printColored("first.equals(fourth)", "" + (first.equals(fourth.toString())));
        Printer.printColored("third.equals(fourth)", "" + (third.equals(fourth.toString())));
        
        System.out.println("\nString Comparison Before Mutation:");
        Printer.printColored("Object Hashes", "{"+ first.hashCode() + ", " + second.hashCode() + ", " + third.hashCode() + ", " + fourth.hashCode() +"}");
        Printer.printColored("Memory References", "{"+ System.identityHashCode(first) + ", " + System.identityHashCode(second) + ", " + System.identityHashCode(third) + ", " + System.identityHashCode(fourth) +"}");

        first = first.concat("GhIj");
        second = second.concat("GhIj");
        third = third.concat("GhIj");
        fourth = fourth.append("GhIJ");
        
        System.out.println("Comparison After Mutation:");
        Printer.printColored("Object Hashes", "{"+ first.hashCode() + ", " + second.hashCode() + ", " + third.hashCode() + ", " + fourth.hashCode() +"}");
        Printer.printColored("Memory References", "{"+ System.identityHashCode(first) + ", " + System.identityHashCode(second) + ", " + System.identityHashCode(third) + ", " + System.identityHashCode(fourth) +"}");
    }
}