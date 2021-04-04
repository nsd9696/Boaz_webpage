package boaz.web.proto.boaz.common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsUtils;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(WebSecurity web) { // 5
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.cors().disable()
                .csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.DELETE,"/blog/**").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST,"/blog/**").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.GET,"/blog/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/portfolio/**").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST,"/portfolio/**").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.GET,"/portfolio/**").permitAll()
                .anyRequest().authenticated();
    }
}
