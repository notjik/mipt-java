package edu.phystech.hw4.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kzlv4natoly & notjik
 */
public class CASTicketLock {
    private final AtomicInteger nextTicket = new AtomicInteger();
    private final AtomicInteger currentTicket = new AtomicInteger();

    public void lock() {
        int myTicket = nextTicket.getAndIncrement();
        while (currentTicket.get() != myTicket) {
            Thread.onSpinWait();
        }
    }

    public void unlock() {
        currentTicket.incrementAndGet();
    }
}