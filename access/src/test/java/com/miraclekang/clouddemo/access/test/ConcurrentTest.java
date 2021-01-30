package com.miraclekang.clouddemo.access.test;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ConcurrentTest {

    // program will never stop
    // private static boolean stopRequested;

    // program can be stop after 1 second
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1L);
        stopRequested = true;
    }


    @Test
    public void testStopThread() throws InterruptedException {


    }
}
