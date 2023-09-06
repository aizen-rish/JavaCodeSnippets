package rish.learn.threads;

public class TaskEvenOdd implements Runnable {

    private int limit;
    private Printer printer;
    private boolean isEven;

    public TaskEvenOdd(int limit, Printer printer, boolean isEven) {
        this.limit = limit;
        this.printer = printer;
        this.isEven = isEven;
    }

    @Override
    public void run() {

        int i = isEven ? 2 : 1;

        while (i <= limit) {

            if (isEven) {
                printer.printEven(i);
            } else {
                printer.printOdd(i);
            }

            i += 2;
        }
    }

    public static void main(String[] args) {

        Printer printer = new Printer();

        // Using synchronized methods
        Thread t1 = new Thread(new TaskEvenOdd(100, printer, false));
        Thread t2 = new Thread(new TaskEvenOdd(100, printer, true));

        t1.start();
        t2.start();

        // Using semaphores
        Thread odd = new Thread(new Odd(10, printer), "Odd");
        Thread even = new Thread(new Even(10, printer), "Even");
        odd.start();
        even.start();
    }

}
