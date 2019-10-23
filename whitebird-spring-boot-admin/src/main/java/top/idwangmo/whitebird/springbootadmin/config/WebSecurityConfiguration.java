package top.idwangmo.whitebird.springbootadmin.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * 网页安全配置.
 *
 * @author idwangmo
 */
@Configuration
@EnableOAuth2Sso
@Order(0)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String adminContextPath;

    public WebSecurityConfiguration(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        http.authorizeRequests()
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage(adminContextPath + "/login")
                        .successHandler(successHandler)
                .and()
                    .logout()
                        .logoutUrl(adminContextPath + "/logout")
                        .deleteCookies("spring-boot-authorization-SESSION", "spring-boot-admin-SESSION")
                        .invalidateHttpSession(true)
                .and()
                    .httpBasic()
                .and()
                    .csrf()
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .ignoringAntMatchers(
                                adminContextPath + "/instances",
                                adminContextPath + "/actuator/**"
                        );
        // @formatter:on
    }
}
