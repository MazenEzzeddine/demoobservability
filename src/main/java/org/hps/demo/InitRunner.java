package org.hps.demo;


import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitRunner implements CommandLineRunner {

    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public void run(String... args) throws Exception {
        (new Thread(new DemoCounters(meterRegistry))).start();
        (new Thread(new DemoDistribution(meterRegistry))).start();
        new DemoGauge(meterRegistry);
    }
}
