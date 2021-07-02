package opera.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/users/by-email").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,
                        "/shopping-carts/by-user/*",
                        "/orders/*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/performances", "/stages",
                        "/performance-sessions/available").permitAll()
                .antMatchers(HttpMethod.POST,
                        "/performances/*",
                        "/performance-sessions/*",
                        "/stages/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,
                        "/shopping-carts/performance-sessions/*",
                        "/orders/complete/*").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/performance-sessions")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/performance-sessions")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
