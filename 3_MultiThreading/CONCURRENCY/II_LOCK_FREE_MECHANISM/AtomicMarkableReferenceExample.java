package CONCURRENCY.II_LOCK_FREE_MECHANISM;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceExample {

    public static void main(String[] args) throws InterruptedException {

        AtomicMarkableReference<Integer> ref =
                new AtomicMarkableReference<>(100, false);

        System.out.println("Initial Value: " + ref.getReference());
        System.out.println("Initial Mark: " + ref.isMarked());

        // ---------------- Thread 1 ----------------
        Thread t1 = new Thread(() -> {
            boolean[] markHolder = new boolean[1];

            Integer value = ref.get(markHolder);
            System.out.println("\n[T1] Read Value = " + value
                    + ", Mark = " + markHolder[0]);

            ref.compareAndSet(100, 50, false, true);
            System.out.println("[T1] Changed 100 → 50 and Mark false → true");

            ref.compareAndSet(50, 100, true, false);
            System.out.println("[T1] Changed 50 → 100 and Mark true → false");
        });

        // ---------------- Thread 2 ----------------
        Thread t2 = new Thread(() -> {
            boolean[] markHolder = new boolean[1];

            Integer value = ref.get(markHolder);
            boolean expectedMark = markHolder[0];

            System.out.println("\n[T2] Read Value = " + value
                    + ", Mark = " + expectedMark);

            try {
                Thread.sleep(2000); // Allow ABA
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean result = ref.compareAndSet(
                    100, 200, expectedMark, !expectedMark);

            System.out.println("\n[T2] CAS Result = " + result);
            System.out.println("[T2] Final Value = " + ref.getReference());
            System.out.println("[T2] Final Mark = " + ref.isMarked());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

