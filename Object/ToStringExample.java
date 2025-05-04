import utility.Printer;

public class ToStringExample {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.printf(
        "%-40s: %s\n"
        +"%-40s: %s\n"
        +"%-40s: %s\n"
        +"%-40s: %s\n"
        +"%-40s: %s\n",
        "object",
        Printer.GREEN + object + Printer.RESET,
        "object.toString()",
        Printer.GREEN + object.toString() + Printer.RESET,
        "object.getClass()",
        Printer.GREEN + object.getClass() + Printer.RESET,
        "object.hashCode()",
        Printer.GREEN + object.hashCode() + Printer.RESET,
        "Integer.toHexString(object.hashCode())",
        Printer.GREEN + Integer.toHexString(object.hashCode()) + Printer.RESET
        );
    }
}
