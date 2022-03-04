package supplier.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityFilter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//       http.authorizeRequests().antMatchers("/welcome","/register").permitAll()
//               .anyRequest().authenticated();
        http.cors().and().csrf().disable();
        http.authorizeRequests().antMatchers("/**").permitAll();
    }
}
