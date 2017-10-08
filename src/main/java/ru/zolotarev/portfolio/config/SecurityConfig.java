package ru.zolotarev.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.zolotarev.portfolio.enums.UserRole;
import ru.zolotarev.portfolio.properties.SecurityProperties;

/**
 * Spring Security Configuration class.
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties properties;

	/**
	 * Setting user access rights to the pages of the site.
	 * To get to these pages, you need to pass authorization.
	 * Override this method to configure the HttpSecurity.
	 * Typically subclasses should not invoke this method by calling
	 * super as it may override their configuration.
	 *
	 * @param httpSecurity a object of the HttpSecurity class.
	 * @throws Exception Exception maybe throws HttpSecurity class methods.
	 */
	@Override
	protected void configure(final HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests().antMatchers(properties.getPage().getAdmin()).hasRole(UserRole.ADMIN.name())
				.anyRequest().permitAll()
				.and()
				.formLogin().defaultSuccessUrl("/admin")
				.loginPage("/login")
				.usernameParameter("login").passwordParameter("password")
				.and()
				.exceptionHandling().accessDeniedPage(properties.getPage().getAccessDeny())
				.and()
				.logout().permitAll().logoutSuccessUrl("/index").invalidateHttpSession(false)
				.and()
				.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"));
	}

	/**
	 * Setting up users with their roles. Users will be loaded from a database
	 * using UserDetailsService implementation of interface methods.
	 *
	 * @param builder a object of the AuthenticationManagerBuilder class.
	 * @throws Exception Exception maybe throws AuthenticationManagerBuilder
	 *                   class methods.
	 */
	@Override
	protected void configure(final AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser(properties.getUser().getLogin()).password(properties.getUser().getPassword()).roles(UserRole.GUESS.name())
				.and()
				.withUser(properties.getAdmin().getLogin()).password(properties.getAdmin().getPassword()).roles(UserRole.ADMIN.name(), UserRole.GUESS.name());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/*.css");
		web.ignoring().antMatchers("/*.js");
	}

}
