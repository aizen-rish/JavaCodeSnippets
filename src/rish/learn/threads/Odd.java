package rish.learn.threads;

public class Odd implements Runnable {

    private int limit;
    private Printer printer;

    public Odd(int limit, Printer printer) {
        this.limit = limit;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i = i + 2) {
            printer.printOddUsingSem(i);
        }
    }

}
