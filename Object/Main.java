public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.printf("%-20s: %s\n"
          +"%-20s: %s\n"
          +"%-20s: %s\n"
          +"%-20s: %s\n"
          +"%-20s: %s\n",
          "object",
          object,
          "object.toString()",
          object.toString(),
          "object.getClass()",
          object.getClass(),
          "object.hashCode()",
          object.hashCode(),
          "Integer.toHexString(object.hashCode()): ",
          Integer.toHexString(object.hashCode())
        );
    }
}