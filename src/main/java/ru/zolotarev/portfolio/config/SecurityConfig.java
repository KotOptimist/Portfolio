package ru.zolotarev.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.zolotarev.portfolio.enums.UserRole;
import ru.zolotarev.portfolio.properties.SecurityProperties;

/**
 * Spring Security Configuration class.
 */
@Configuration
@EnableWebSecurity
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
				.logout()
				.invalidateHttpSession(false)
				.and()
				.authorizeRequests()
				.antMatchers(properties.getPage().getAdmin())
				.hasRole(UserRole.ADMIN.name())
				.anyRequest().permitAll()
				.and()
				.formLogin()
				.loginPage(properties.getPage().getLogin())
				.usernameParameter(properties.getAdmin().getLogin())
				.passwordParameter(properties.getAdmin().getPassword())
				.defaultSuccessUrl(
						properties.getDefaultSuccess().getPage(),
						properties.getDefaultSuccess().isAlwaysUse()
				)
				.and().exceptionHandling()
				.accessDeniedPage(properties.getPage().getAccessDeny())
				.and()
				.csrf().disable();
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
		builder.inMemoryAuthentication().withUser(properties.getUser().getLogin()).password(properties.getUser().getPassword()).roles(UserRole.USER.name())
				.and()
				.withUser(properties.getAdmin().getLogin()).password(properties.getAdmin().getPassword()).roles(UserRole.ADMIN.name(), UserRole.USER.name());
	}
}
