package rish.learn.threads;

public class Even implements Runnable {

    private int limit;
    private Printer printer;

    public Even(int limit, Printer printer) {
        this.limit = limit;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 2; i <= limit; i = i + 2) {
            printer.printEvenUsingSem(i);
        }
    }

}
