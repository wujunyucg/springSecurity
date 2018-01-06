package cc.wujunyu.security.browser;

import cc.wujunyu.security.core.properties.SecurityProperties;
import cc.wujunyu.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailureHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter filter = new ValidateCodeFilter();
        filter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
        filter.setSecurityProperties(securityProperties);
        filter.afterPropertiesSet();
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
            .formLogin()
            .loginPage("/authentication/require")
            .loginProcessingUrl("/authentication/form")
            .successHandler(myAuthenticationSuccessHandler)
            .failureHandler(myAuthenticationFailureHandler)
            .and()
            .authorizeRequests()
            .antMatchers("/code/image",
                    "/authentication/require", securityProperties.getBrowser().getLoginPage()).permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf().disable();
    }
}
