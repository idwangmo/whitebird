package top.idwangmo.whitebird.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * web 安全配置.
 *
 * @author idwangmo
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 在 Spring boot 2 或者 Spring Security 5 中一定要设置.
     *
     * @return Authentication
     * @throws Exception exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.csrf().disable()
            .requestMatchers().antMatchers("/oauth/**", "/login/**", "/logout/**", "/users/registry")
            .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
            .and()
                .formLogin().permitAll();
        // @formatter:on
    }
}
