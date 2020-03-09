package store.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import store.main.database.UserRepositoryAuthenticationProvider;

@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider userRepoAuthProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/api/**");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/logIn").authenticated();
		
		// URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/posts/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/posts/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/posts/**").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/users/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/users/**").hasRole("USER");
		
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/users/{id}/images").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/users/{id}/images").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/posts/{id}/images").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/posts/{id}-{nimg}/images").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/ratings/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/ratings/**").hasRole("USER");
				
		// Other URLs can be accessed without authentication
		http.authorizeRequests().anyRequest().permitAll();

		// Disable CSRF protection (it is difficult to implement in REST APIs)
		http.csrf().disable();

		// Use Http Basic Authentication
		http.httpBasic();

		// Do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> {	});
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Database authentication provider
		auth.authenticationProvider(userRepoAuthProvider);
	}
}