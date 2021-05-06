package boaz.web.proto.boaz.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .httpBasic().disable()
                .logout().disable()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/admin").authenticated()
                .antMatchers("/admin/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/blog/**").authenticated()
                .antMatchers(HttpMethod.POST,"/blog/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/portfolio/**").authenticated()
                .antMatchers(HttpMethod.POST,"/portfolio/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/blog/**").authenticated()
                .antMatchers(HttpMethod.GET,"/**").permitAll()

//                .antMatchers(HttpMethod.DELETE,"/admin/**").hasAuthority("ROLE_MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/admin")
                .permitAll();
    }
}
