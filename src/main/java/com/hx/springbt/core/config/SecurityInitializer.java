package com.hx.springbt.core.config;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/** Spring Security中的Session放到Redis中
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    /**
     * Security initializer.
     */
    public SecurityInitializer() {
        super(SecurityConfig.class, RedisConfig.class);
    }
}
