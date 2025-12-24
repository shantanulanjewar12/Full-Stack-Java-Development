package CONCURRENCY.II_LOCK_FREE_MECHANISM;


import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReference_ABA_Problem {

    public static void main(String[] args) throws InterruptedException {

        // Initial value = 100, stamp(version) = 1
        AtomicStampedReference<Integer> balance =
                new AtomicStampedReference<>(100, 1);

        System.out.println("Initial Value: " + balance.getReference());
        System.out.println("Initial Stamp: " + balance.getStamp());

        // ---------------- Thread 1 (Causes ABA) ----------------
        Thread t1 = new Thread(() -> {
            int stamp = balance.getStamp();

            System.out.println("\n[T1] Read Value = " + balance.getReference()
                    + ", Stamp = " + stamp);

            // A -> B
            balance.compareAndSet(100, 50, stamp, stamp + 1);
            System.out.println("[T1] Changed 100 → 50");

            // B -> A
            balance.compareAndSet(50, 100, balance.getStamp(),
                    balance.getStamp() + 1);
            System.out.println("[T1] Changed 50 → 100");
        });

        // ---------------- Thread 2 (Victim) ----------------
        Thread t2 = new Thread(() -> {
            int stamp = balance.getStamp();

            System.out.println("\n[T2] Read Value = " + balance.getReference()
                    + ", Stamp = " + stamp);

            try {
                Thread.sleep(2000); // Let T1 do ABA
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean result = balance.compareAndSet(
                    100, 200, stamp, stamp + 1);

            System.out.println("\n[T2] CAS Result = " + result);
            System.out.println("[T2] Final Value = " + balance.getReference());
            System.out.println("[T2] Final Stamp = " + balance.getStamp());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

