package com.example.bookstore.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomMetricsConfig {

    @Autowired
    public CustomMetricsConfig(MeterRegistry meterRegistry) {
        meterRegistry.counter("custom_metric_total_requests").increment();
        meterRegistry.gauge("custom_metric_books_available", 100);
    }
}
