package com.company;

import java.util.concurrent.*;

public class Main {

    private static ScheduledExecutorService executor;

    public static void main(String args[]) {
        executor = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<?> future = solution( () -> System.out.println("Hello World"), 1000);

        // Cleanup
        executor.shutdown();
        executor = null;
    }

    public static ScheduledFuture<?> solution(Runnable command, int delay_ms) {
        return executor.schedule( command, delay_ms, TimeUnit.MILLISECONDS );
    }
}
