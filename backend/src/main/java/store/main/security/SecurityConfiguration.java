package store.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import store.main.database.UserRepositoryAuthenticationProvider;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/error").permitAll();
		http.authorizeRequests().antMatchers("/cart").permitAll();
		http.authorizeRequests().antMatchers("/cart/removeItem-{idRemove}").permitAll();
		http.authorizeRequests().antMatchers("/post/{id}-{img}").permitAll();
		http.authorizeRequests().antMatchers("/post/{id}-{img}/removeItem-{idRemove}").permitAll();
		http.authorizeRequests().antMatchers("/post/{id}-{img}/itemAdded").permitAll();
		http.authorizeRequests().antMatchers("/public_profile/{id}").permitAll();
		http.authorizeRequests().antMatchers("/public_profile/{idSeller}/{idBuyer}").permitAll();
		http.authorizeRequests().antMatchers("/shop/").permitAll();
		http.authorizeRequests().antMatchers("/shop/{tag}").permitAll();
		http.authorizeRequests().antMatchers("/shop/brand/{name}").permitAll();
		
		//Private pages
		http.authorizeRequests().antMatchers("/sell_product/").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/sell_product/added_product").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/logout").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/public_profile").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/account_settings").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/profile/updated").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/payment").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/final_review").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/complete").hasAnyRole("USER");

		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/");
		http.formLogin().failureUrl("/loginerror");

		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");

		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
	}
}
