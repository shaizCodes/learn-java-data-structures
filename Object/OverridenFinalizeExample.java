import utility.Printer;

public class OverridenFinalizeExample {

    private static class DatabaseConnection {
        private String URL;
        public void connect(String URL) {
            this.URL = URL;
            System.out.println(Printer.YELLOW + "Connected to database at " + Printer.BLUE_BACKGROUND + URL + Printer.RESET);
        }

        public void close() {
            System.out.println(Printer.RED + "Database connection at " + Printer.BLUE_BACKGROUND + URL + Printer.RESET +  Printer.RED + " closed" + Printer.RESET);
        }

        @Override
        protected void finalize() throws Throwable {
            close();
            super.finalize();
        }
        
    }

    public static void main(String[] args) {
        DatabaseConnection mySQLConnection = new DatabaseConnection();
        mySQLConnection.connect("jdbc:mysql://localhost:3306/mydb");
        
        DatabaseConnection msAccessConnection = new DatabaseConnection();
        msAccessConnection.connect("jdbc:ucanaccess://localhost:1234/mydb");

        System.out.println("Performing database operations...");
        System.gc();
        System.out.println("Garbage collection requested");
        try {
            System.out.println(Printer.GREEN + "Explicitly calling finalize() " + Printer.RESET + "method on MS Access connection despite it being deprecated in Java 9+");
            msAccessConnection.finalize();
        } catch (Throwable e) {
            System.out.println("Error during finalize() call: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("If MySQL database connection down message is printed, the finalize() is automatically called, else not.");
        System.out.println("Exiting main method");
    }
}
