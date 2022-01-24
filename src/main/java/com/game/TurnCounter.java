package com.game;

public class TurnCounter {
    private static int count = 0;

    private TurnCounter() {
    }

    public static void reset() {
        count = 0;
    }

    public static void increment() {
        count++;
    }

    public static void decrement() {
        count--;
    }

    public static int get() {
        return count;
    }
}
