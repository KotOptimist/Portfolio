package ru.zolotarev.portfolio.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("mvc")
public class WebProperties {

	private View view;
	private Resource resource;

	@Getter
	@Setter
	public static class View {
		private String contentType;
		private String prefix;
		private String suffix;
		private boolean exposeContextBeansAsAttributes;
	}

	@Getter
	@Setter
	public static class Resource {
		private String pathPattern;
		private String resourceLocation;
	}
}
