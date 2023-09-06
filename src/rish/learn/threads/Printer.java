package rish.learn.threads;

import java.util.concurrent.Semaphore;

public class Printer {

    volatile boolean isOdd;

    private Semaphore semOdd = new Semaphore(1);
    private Semaphore semEven = new Semaphore(0);

    synchronized void printEven(int num) {

        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + ":" + num);
        isOdd = false;
        notify();
    }

    void printEvenUsingSem(int num) {

        try {
            semEven.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " : " + num);
        semOdd.release();
    }

    synchronized void printOdd(int num) {

        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + ":" + num);
        isOdd = true;
        notify();
    }

    void printOddUsingSem(int num) {

        try {
            semOdd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " : " + num);
        semEven.release();
    }

}
