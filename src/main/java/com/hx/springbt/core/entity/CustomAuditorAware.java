package com.hx.springbt.core.entity;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class CustomAuditorAware implements AuditorAware<String> {


    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("范海辛");
    }
}
