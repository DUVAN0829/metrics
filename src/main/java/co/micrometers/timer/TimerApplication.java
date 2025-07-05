package co.micrometers.timer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import java.util.concurrent.TimeUnit;

public class TimerApplication {

    public static void main(String[] args) {

        MeterRegistry registry = new SimpleMeterRegistry();

        Timer timer = registry.timer("execution.time");

        timer.record(() -> {

            for (int i = 1; i < 10; i++) {

                System.out.println(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }

            }

        });

        System.out.println(timer.totalTime(TimeUnit.SECONDS));

    }

}
