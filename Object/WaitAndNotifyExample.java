public class WaitAndNotifyExample {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiting for notification...");
                    lock.wait();
                    System.out.println("Received notification!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        });

        Thread notifier = new Thread(() -> {
            try {
                Thread.sleep(2000);
                synchronized (lock) {
                    System.out.println("Sending notification...");
                    lock.notify();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        });

        waiter.start();
        notifier.start();
    }
}