/**
 * Monitor contention example in Java (source: ChatGPT).
 * This example demonstrates how multiple threads can contend for the same monitor lock.
 * It includes three scenarios:
 * 1. Competing for instance monitor using synchronized instance method.
 * 2. Competing for object monitor using synchronized block.
 * 3. Competing for class-level monitor using synchronized static method.
 */
public class MonitorContentionExample {
    public static void main(String[] args) {
        // 1. Competing for instance monitor
        SyncInstanceMethod instanceObj = new SyncInstanceMethod();
        Thread t1 = new Thread(() -> instanceObj.doWork(), "Instance-Thread-1");
        Thread t2 = new Thread(() -> instanceObj.doWork(), "Instance-Thread-2");

        // 2. Competing for object monitor in synchronized block
        SyncBlock blockObj = new SyncBlock();
        Thread t3 = new Thread(() -> blockObj.doWork(), "Block-Thread-1");
        Thread t4 = new Thread(() -> blockObj.doWork(), "Block-Thread-2");

        // 3. Competing for Class-level monitor
        Thread t5 = new Thread(() -> SyncStaticMethod.doWork(), "Static-Thread-1");
        Thread t6 = new Thread(() -> SyncStaticMethod.doWork(), "Static-Thread-2");

        // Start all threads
        t1.start(); t2.start();
        t3.start(); t4.start();
        t5.start(); t6.start();
    }
}

class SyncInstanceMethod {
    public synchronized void doWork() {
        System.out.println(Thread.currentThread().getName() + " entered instance method.");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + " exiting instance method.");
    }
}

class SyncBlock {
    public void doWork() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " entered synchronized block.");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + " exiting synchronized block.");
        }
    }
}

class SyncStaticMethod {
    public static synchronized void doWork() {
        System.out.println(Thread.currentThread().getName() + " entered static synchronized method.");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + " exiting static synchronized method.");
    }
}
