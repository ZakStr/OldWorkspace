package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getShaPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests() // Нечего нельзя сделать пока не зарегестрируешься
                .antMatchers("/").hasAnyRole("USER", "ADMIN") // Доступ на переход по URL "/"  имеют все
                .antMatchers("/admin").hasRole("ADMIN") // Доступ на переход по URL "/admin" имеет только Администратор
                .antMatchers("/register").permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/unauthorized")  // В случае если USER пытаеться зайти по URL "/admin" его перекидывает на URL "/unauthorized"
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")  // Action URL для формы, по которому Spring Security ожидает введеный Login & Password
                .failureUrl("/login?error") // Fail URL если введеный Login & Password не правильный
                .usernameParameter("j_login") // Название Input
                .passwordParameter("j_password") // Название Input
                .permitAll() // Доступна всем
                .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);
    }

    private ShaPasswordEncoder getShaPasswordEncoder() {
        return new ShaPasswordEncoder();
    }
}
