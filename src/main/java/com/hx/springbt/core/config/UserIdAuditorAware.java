package com.hx.springbt.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class UserIdAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        /**
         * 这里要获取当前用户,先随便默认一个用户编号'000000'
         */
        return Optional.of("000000");
    }
}
