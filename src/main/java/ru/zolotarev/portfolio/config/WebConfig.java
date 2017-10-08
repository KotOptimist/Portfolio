package ru.zolotarev.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ru.zolotarev.portfolio.properties.WebProperties;

/**
 * Class Spring MVC configuration. Spring Indicates where the views components,
 * and how to display them. Class is the source of bean definitions.
 */
@EnableWebMvc
@Configuration
@EnableConfigurationProperties(WebProperties.class)
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private WebProperties webProperties;

	/**
	 * Indicates to Spring where are the views components,
	 * and how to display them.
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setContentType(webProperties.getView().getContentType());
		viewResolver.setPrefix(webProperties.getView().getPrefix());
		viewResolver.setSuffix(webProperties.getView().getSuffix());
		viewResolver.setExposeContextBeansAsAttributes(webProperties.getView().isExposeContextBeansAsAttributes());
		registry.viewResolver(viewResolver);
	}

	/**
	 * Add handlers to serve static resources such as images, js, and, css
	 * files from specific locations under web application root, the classpath,
	 * and others.
	 *
	 * @param registry The object of the ResourceHandlerRegistry class.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(webProperties.getResource().getPathPattern())
				.addResourceLocations(webProperties.getResource().getResourceLocation());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/login").setViewName("login");
	}
}
