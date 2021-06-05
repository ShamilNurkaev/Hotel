package ru.kpfu.itis.hotel.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.kpfu.itis.hotel.security.oauth.VkOAuthAuthenticationFilter;
import ru.kpfu.itis.hotel.security.oauth.VkOAuthenticationProvider;

import javax.sql.DataSource;

/**
 * 04.04.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Order(2)
    @Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        private final PasswordEncoder passwordEncoder;

        private final UserDetailsService userDetailsService;

        private final DataSource dataSource;

        @Autowired
        public WebSecurityConfig(@Qualifier("customUserDetailsService") UserDetailsService userDetailsService,
                                 DataSource dataSource,
                                 PasswordEncoder passwordEncoder) {
            this.userDetailsService = userDetailsService;
            this.dataSource = dataSource;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    /*.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                    and()*/
                    .authorizeRequests()
                    .antMatchers("/profile").authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/signIn")
                    .usernameParameter("email")
                    .defaultSuccessUrl("/main")
                    .failureUrl("/error_page")
                    .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .and()
                    .rememberMe()
                    .rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository())
                    .and()
                    .csrf().ignoringAntMatchers("/booking")
                    .and()
                    .csrf().ignoringAntMatchers("/news")
                    .and()
                    .csrf().ignoringAntMatchers("/availability")
                    .and()
                    .csrf().ignoringAntMatchers("/availability/popular");


        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        }

        @Bean
        public PersistentTokenRepository persistentTokenRepository() {
            JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
            jdbcTokenRepository.setDataSource(dataSource);
            return jdbcTokenRepository;
        }

    }

    @Order(1)
    @Configuration
    public static class OAuthSecurityConfiguration extends WebSecurityConfigurerAdapter {

        private final VkOAuthAuthenticationFilter authenticationFilter;
        private final VkOAuthenticationProvider authenticationProvider;

        @Autowired
        public OAuthSecurityConfiguration(VkOAuthAuthenticationFilter authenticationFilter, VkOAuthenticationProvider authenticationProvider) {
            this.authenticationFilter = authenticationFilter;
            this.authenticationProvider = authenticationProvider;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/auth/**")
                    .authorizeRequests()
                    .antMatchers("/auth/vk").authenticated()
                    .and()
                    .formLogin().disable()
                    .httpBasic().disable()
                    .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) {
            auth.authenticationProvider(authenticationProvider);
        }
    }
}



