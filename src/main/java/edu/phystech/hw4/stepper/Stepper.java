package edu.phystech.hw4.stepper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kzlv4natoly & notjik
 */

public class Stepper {

    public enum Side {
        LEFT, RIGHT
    }

    private final List<Side> history = new ArrayList<>();
    private final Object lock = new Object();
    private boolean isLeftTurn = true;

    public void leftStep() {
        synchronized (lock) {
            try {
                while (!isLeftTurn) {
                    lock.wait();
                }
                history.add(Side.LEFT);
                isLeftTurn = false;
                lock.notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void rightStep() {
        synchronized (lock) {
            try {
                while (isLeftTurn) {
                    lock.wait();
                }
                history.add(Side.RIGHT);
                isLeftTurn = true;
                lock.notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public List<Side> getHistory() {
        return history;
    }
}