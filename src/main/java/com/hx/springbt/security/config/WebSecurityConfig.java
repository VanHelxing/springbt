package com.hx.springbt.security.config;

import com.hx.springbt.security.entity.LoginSuccessHandler;
import com.hx.springbt.security.service.CustomFilterSecurityInterceptor;
import com.hx.springbt.security.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.session.SimpleRedirectSessionInformationExpiredStrategy;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private CustomUserDetailService customUserDetailService;
    @Resource
    private CustomFilterSecurityInterceptor customFilterSecurityInterceptor;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(customFilterSecurityInterceptor, FilterSecurityInterceptor.class) //注入自定义的过滤器实现权限验证
            .authorizeRequests()
            .antMatchers("/**/*.json").permitAll()  //REST请求暂时不拦截,需要用令牌方式验证
            .antMatchers("/customLogin", "/logout").permitAll() //登录控制器
            .antMatchers("/swagger-ui.html", "/swagger-resources", "/v2/**", "/configuration/**").permitAll()  //swagger的静态路径
            .antMatchers("/resource/**", "/smart-admin/**", "/webjars/**").permitAll()  //静态路径
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/customLogin")
            .failureUrl("/customLogin?error").permitAll()
            .successHandler(loginSuccessHandler())
            .and()
            .logout()
            .logoutSuccessUrl("/customLogin").permitAll()
            .and()
            .rememberMe()
            .rememberMeServices(rememberMeServices())
            .key("INTERNAL_SECRET_KEY")
            .and()
            .sessionManagement().maximumSessions(1).expiredUrl("/customLogin?expire").sessionRegistry(sessionRegistry());

        //解决不允许显示在iframe的问题
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }

    @Bean
    public RememberMeServices rememberMeServices(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        PersistentTokenBasedRememberMeServices rememberMeServices =
                new PersistentTokenBasedRememberMeServices("INTERNAL_SECRET_KEY", customUserDetailService, tokenRepository);
        rememberMeServices.setParameter("remember-me");
        return rememberMeServices;
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }

    //session失效跳转
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new SimpleRedirectSessionInformationExpiredStrategy("/customLogin?expire");
    }


}
