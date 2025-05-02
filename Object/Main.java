public class Main {
    public static void main(String[] args) {
        String first = "AbCdEf";
        String second = "AbCdEf";
        String third = new String("AbCdEf");
        StringBuilder fourth = new StringBuilder("AbCdEf");

        System.out.println("Equality Check:");
        printColored("first == second", "" + (first == second));
        printColored("first == third",  "" + (first == third));
        printColored("first == fourth", "" + (first == fourth.toString()));
        printColored("third == fourth", "" + (third == fourth.toString()));
        
        printColored("first.equals(second)", "" + (first.equals(second)));
        printColored("first.equals(third)",  "" + (first.equals(third)));
        printColored("first.equals(fourth)", "" + (first.equals(fourth.toString())));
        printColored("third.equals(fourth)", "" + (third.equals(fourth.toString())));
        
        System.out.println("\nString Comparison Before Mutation:");
        printColored("Object Hashes", "{"+ first.hashCode() + ", " + second.hashCode() + ", " + third.hashCode() + ", " + fourth.hashCode() +"}");
        printColored("Memory References", "{"+ System.identityHashCode(first) + ", " + System.identityHashCode(second) + ", " + System.identityHashCode(third) + ", " + System.identityHashCode(fourth) +"}");

        first = first.concat("GhIj");
        second = second.concat("GhIj");
        third = third.concat("GhIj");
        fourth = fourth.append("GhIJ");
        
        System.out.println("Comparison After Mutation:");
        printColored("Object Hashes", "{"+ first.hashCode() + ", " + second.hashCode() + ", " + third.hashCode() + ", " + fourth.hashCode() +"}");
        printColored("Memory References", "{"+ System.identityHashCode(first) + ", " + System.identityHashCode(second) + ", " + System.identityHashCode(third) + ", " + System.identityHashCode(fourth) +"}");
    }

    private static void printColored(String message, String result) {
        String BLUE = "\u001B[34m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";
        System.out.printf("%s%-20s: %s%s%s\n", BLUE, message, GREEN, result, RESET);
    }
}