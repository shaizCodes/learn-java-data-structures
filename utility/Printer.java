package utility;

public class Printer {
    public static String RED = "\u001B[31m";
    public static String RED_BACKGROUND = "\u001B[41m";
    public static String GREEN = "\u001B[32m";
    public static String GREEN_BACKGROUND = "\u001B[42m";
    public static String BLUE = "\u001B[34m";
    public static String BLUE_BACKGROUND = "\u001B[44m";
    public static String YELLOW = "\u001B[33m";
    public static String YELLOW_BACKGROUND = "\u001B[43m";
    public static String RESET = "\u001B[0m";
    
    public static void printColored(String message, String result) {
        System.out.printf("%s%-20s: %s%s%s\n", BLUE, message, GREEN, result, RESET);
    }
    
    public static void printError(String message, String result) {
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
        System.out.printf("%s%-20s: %s%s%s\n", RED, message, RESET, result, RESET);
    }
}
