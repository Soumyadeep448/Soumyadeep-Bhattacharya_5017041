package com.example.employeemanagementsystem.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // In a real application, you would get the logged-in user from the security context
        return Optional.of("AdminUser");
    }
}
